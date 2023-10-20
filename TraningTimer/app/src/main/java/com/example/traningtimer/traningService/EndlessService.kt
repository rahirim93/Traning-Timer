package com.example.traningtimer.traningService

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.*
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.traningtimer.*
import kotlinx.coroutines.*
import java.util.*

//private const val TAG = "rahirim"

private const val MODE_WAITING = 0
private const val MODE_ALARM_SET = 1

class EndlessService : Service(), SensorEventListener {
    // Переменные для функции однократного срабатывания звонка
    // за 30 секунд до окончания отдыха (время может меняться)
    // Флаг звонка при времени сигнала об 30 секундах до подхода
    var flagBeep = false
    // Время до окончания подхода для срабатывания однократного звонка
    var timeBeep = 30

    // Переменные датчика положения
    private lateinit var mSensorManager: SensorManager
    private lateinit var mOrientation: Sensor
    private var xyAngle = 0f
    private var xzAngle = 0f
    private var zyAngle = 0f
    // Переменные датчика положения

    // Переменные для обработки движений
    private var rightMove: Boolean = false
    private var leftMove: Boolean = false
    private var mode = MODE_WAITING
    // Переменные для обработки движений

    // Переменные для таймера
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent // Для поиска будильника
    private var timeToAlarm: Calendar = Calendar.getInstance()
    // Переменные для таймера

    // Переменные сервиса
    private var wakeLock: PowerManager.WakeLock? = null
    private var isServiceStarted = false
    // Переменные сервиса

    private var timeTraining = 0

    private var timeRightMove: Long = 0

    private var counter: Long = 0

    private lateinit var ringtone: Ringtone         // Для основного звонка
    private lateinit var notificationUri: Uri       // Для основного звонка
    private lateinit var ringtoneBeep: Ringtone     // Для единократного за 30 сек до подхода звонка
    private lateinit var notificationUriBeep: Uri   // Для единократного за 30 сек до подхода звонка


    // Счетчик времени работы сервиса без запуска приложения
    private var counterTimeWork: Double = 0.0

    private lateinit var builder: NotificationCompat.Builder
    private lateinit var notificationManagerCompat: NotificationManagerCompat

    private var sharedPreferences: SharedPreferences? = null

    private lateinit var vibratorHelper: VibrateHelper

    override fun onCreate() {
        super.onCreate()
        counter = Calendar.getInstance().timeInMillis

        notificationManagerCompat = NotificationManagerCompat.from(this)

        //notificationUri = Uri.parse("content://media/internal/audio/media/119?title=Beep-Beep&canonical=1")
        //ringtone = RingtoneManager.getRingtone(this, notificationUri)
        //notificationUriBeep = Uri.parse("content://media/internal/audio/media/119?title=Beep_Once&canonical=1")
        //ringtoneBeep = RingtoneManager.getRingtone(this, notificationUriBeep)

        ringtone = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM))
        ringtoneBeep = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM))



        builder = createNotification()
        val notification = createNotification().build()
        startForeground(1, notification)
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mOrientation = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)
        mSensorManager.registerListener(this, mOrientation, SensorManager.SENSOR_DELAY_UI)
        @Suppress("DEPRECATION")
        //sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        sharedPreferences = applicationContext.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        vibratorHelper = VibrateHelper(applicationContext)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (mode == MODE_WAITING) {

            // Считывание показаний датчика положения
            if (event != null) {
                xyAngle = event.values[0]  //Плоскость XY
                xzAngle = event.values[1] //Плоскость XZ
                zyAngle = event.values[2] //Плоскость ZY
            }

            // Отключение сработанной тревоги
            if (xzAngle > 0 && xzAngle < 10) {
                if (ringtone.isPlaying) {
                    ringtone.stop()
                }
            }

            // Срабатывание правого движения
            if (zyAngle < -40 && !rightMove && xzAngle < 0) {
                Log.d("rahirim", "right")

                rightMove = true
                vibratorHelper.vibrateDelay = 500
                timeRightMove = Calendar.getInstance().timeInMillis
            }

            // Срабатывание левого движения
            if (zyAngle > 40 && rightMove && xzAngle < 0) {
                Log.d("rahirim", "left")

                leftMove = true
            }

            // Вибрация через определенный промежуток времени
            if (Calendar.getInstance().timeInMillis - counter > vibratorHelper.vibrateDelay) {
                Log.d("rahirim", "work")

                counter = Calendar.getInstance().timeInMillis
                vibratorHelper.vibrate()
            }

            // Если сработал признак правого движения и прошло 2 секунды,
            // то признак правого движения сбрасывается.
            if (rightMove && Calendar.getInstance().timeInMillis - timeRightMove > 2000) {
                rightMove = false
                vibratorHelper.vibrateDelay = 1000
            }

            // Если сработали признаки правого и левого движения
            // включаем таймер
            if (rightMove && leftMove) {

                rightMove = false // Сброс состояний движений
                leftMove = false    // Сброс состояний движений

                if (ringtone.isPlaying) ringtone.stop() // Отключение проигрывания мелодии

                setTestAlarm()

                mode = MODE_ALARM_SET

                // Поток для обновления времени до срабатывания в уведомлении
                // Неконтролируемый, переделать чтобы можно было управлять
//                flagUpdateNotification = true
//                calendar = Calendar.getInstance().timeInMillis + 180000
//                b = GlobalScope.launch(Dispatchers.IO) {
//                    while (flagUpdateNotification) {
//                        launch(Dispatchers.IO) {
//                            val a = (calendar - Calendar.getInstance().timeInMillis) / 1000
//                            updateNotification("$a")
//                        }
//                        delay(10)
//                    }
//                    log("End of the loop for the service")
//                }
            }
        } else if (mode == MODE_ALARM_SET) {
            val a = (timeToAlarm.timeInMillis - Calendar.getInstance().timeInMillis) / 1000.0
            updateNotification("${a.toInt()}")

            if (a < timeBeep && a > timeBeep - 1 && !flagBeep) {
                ringtoneBeep.play()
                flagBeep = true
            }

            if (a < timeBeep - 1 && ringtoneBeep.isPlaying) {
                ringtoneBeep.stop()
                flagBeep = false
            }
        }
    }

    private fun setTestAlarm() {
        if (sharedPreferences != null) {
            timeTraining = sharedPreferences!!.getInt(SHARED_TRAINING_TIME, 180)
            log("Time = $timeTraining")
        }
        timeToAlarm.timeInMillis = Calendar.getInstance().timeInMillis + (timeTraining * 1000)

        val intent = Intent(this, EndlessService::class.java)
        intent.action = Actions.PLAY.name
        pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        setAlarm(timeToAlarm, pendingIntent)

        val intent2 = Intent(this, EndlessService::class.java)
        intent2.action = Actions.STOP_VIBRATOR.name
        startService(intent2)
    }

    private fun setAlarm(calendar: Calendar, alarmActionPendingIntent: PendingIntent) {
        val alarmInfoIntent = Intent(this, MainActivity::class.java)
        alarmInfoIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        val alarmInfoPendingIntent = PendingIntent
            .getActivity(this, 0, alarmInfoIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        val alarmClockInfo = AlarmManager.AlarmClockInfo(calendar.timeInMillis, alarmInfoPendingIntent)
        alarmManager.setAlarmClock(alarmClockInfo, alarmActionPendingIntent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        log("onStartCommand executed with startId: $startId")
        if (intent != null) {
            val action = intent.action
            log("using an intent with action $action")
            when (action) {
                Actions.START.name -> startService()
                Actions.STOP.name -> stopService()
                Actions.STOP_VIBRATOR.name -> {
                    mode = MODE_ALARM_SET
                }
                Actions.PLAY.name -> {
                    mode = MODE_WAITING
                    vibratorHelper.vibrateDelay = 1000
                    ringtone.play()
                }
                Actions.STOP_ALARM.name -> {
                    try {
                        alarmManager.cancel(pendingIntent)
                    } catch (_: Exception) {

                    }
                    mode = MODE_WAITING
                    vibratorHelper.vibrateDelay = 1000
                }
                else -> log("This should never happen. No action in the received intent")
            }
        } else {
            log(
                "with a null intent. It has been probably restarted by the system."
            )
        }
        // by returning this we make sure the service is restarted if the system kills the service
        return START_STICKY
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    private fun startService() {
        counterTimeWork = 0.0
        if (isServiceStarted) return
        log("Starting the foreground service task")
        Toast.makeText(this, "Service starting its task", Toast.LENGTH_SHORT).show()
        isServiceStarted = true
        setServiceState(this, ServiceState.STARTED)

        // we need this lock so our service gets not affected by Doze Mode
        wakeLock =
            (getSystemService(Context.POWER_SERVICE) as PowerManager).run {
                newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "EndlessService::lock").apply {
                    acquire()
                }
            }

        // we're starting a loop in a coroutine
//        var a = GlobalScope.launch(Dispatchers.IO) {
//            while (isServiceStarted) {
//                launch(Dispatchers.IO) {
//                    //updateNotification()
//                    counterTimeWork += 5
//                }
//                delay(10000)
//            }
//            log("End of the loop for the service")
//        }
    }
    private fun updateNotification(string: String){
        builder.setContentText(string)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        notificationManagerCompat.notify(1, builder.build())
    }
    private fun stopService() {
        log("Stopping the foreground service")
        Toast.makeText(this, "Service stopping", Toast.LENGTH_SHORT).show()
        try {
            wakeLock?.let {
                if (it.isHeld) {
                    it.release()
                }
            }
            stopForeground(true)
            stopSelf()
        } catch (e: Exception) {
            log("Service stopped without being started: ${e.message}")
        }
        if(ringtone.isPlaying) ringtone.stop()
        isServiceStarted = false
        setServiceState(this, ServiceState.STOPPED)
        notificationManagerCompat.cancel(1) // Закрываем уведомление после закрытия приложения
    }
    override fun onTaskRemoved(rootIntent: Intent) {
        val restartServiceIntent = Intent(applicationContext, EndlessService::class.java).also {
            it.setPackage(packageName)
        }
        val restartServicePendingIntent: PendingIntent = PendingIntent.getService(this, 1, restartServiceIntent, PendingIntent.FLAG_IMMUTABLE)
        applicationContext.getSystemService(Context.ALARM_SERVICE)
        val alarmService: AlarmManager = applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmService.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 1000, restartServicePendingIntent)
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Service destroyed", Toast.LENGTH_SHORT).show()
        //builder.setContentText("Service was destroyed")
        //notificationManagerCompat.notify(1, builder.build())
        try {
            alarmManager.cancel(pendingIntent)
        } catch (_: Exception) {}
        mSensorManager.unregisterListener(this)
    }
    private fun createNotification(): NotificationCompat.Builder {
        val builder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)

        return builder
            .setContentTitle("Endless Service")
            .setContentText("This is your favorite endless service working")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setTicker("Ticker text")
            .setSilent(true)
            .setPriority(NotificationManagerCompat.IMPORTANCE_HIGH) // for under android 26 compatibility

    }
    override fun onBind(intent: Intent): IBinder? {
        log("Some component want to bind with the service")
        // We don't provide binding, so return null
        return null
    }
}