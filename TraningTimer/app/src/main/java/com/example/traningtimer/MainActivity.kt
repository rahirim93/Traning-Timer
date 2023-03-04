package com.example.traningtimer

import android.app.Activity
import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.*
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.Observer
import com.example.traningtimer.database.TrainingEntity
import com.example.traningtimer.traningService.Actions
import com.example.traningtimer.traningService.EndlessService
import com.example.traningtimer.traningService.ServiceState
import com.example.traningtimer.traningService.getServiceState
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*


const val EXTRA_BUTTON_1 = "button1"
const val TAG = "myMain"
const val SHARED_PREFERENCES_NAME = "shared_pref_training_timer"
const val BROADCAST_ACTION = "broadcastAction"
const val SHARED_TRAINING_TIME = "training time"
const val SET_ALARM = "setAlarm"



class MainActivity : AppCompatActivity(), View.OnClickListener, SensorEventListener {

    // Кнопки /////////////////////////////////////////////////////////////////////////////////
    private lateinit var button1: Button            // Кнопка для подхода
    private lateinit var button2: Button            // Кнопка для подхода
    private lateinit var button3: Button            // Кнопка для подхода
    private lateinit var button4: Button            // Кнопка для подхода
    private lateinit var button5: Button            // Кнопка для подхода
    private lateinit var button6: Button            // Кнопка для подхода
    private lateinit var button7: Button            // Кнопка для подхода
    private lateinit var button8: Button            // Кнопка для подхода
    private lateinit var button9: Button            // Кнопка для подхода
    private lateinit var button10: Button           // Кнопка для подхода                              ///
    private var arrayButtons = ArrayList<Button>()  // Массив для хранения кнопок подходов             ///
    private lateinit var buttonReport: Button       // Кнопка для формирования отчета о тренировке     ///
    private lateinit var buttonReset: Button        // Кнопка сброса состояния тренировки              ///
    private lateinit var buttonStart: Button        // Кнопка запуска сервиса                          ///
    private lateinit var buttonStop: Button         // Кнопка остановки сервиса                        ///
    private lateinit var buttonStopAlarm: Button    // Кнопка отмены таймера                           ///
    private lateinit var button3minTimer: Button    // Выбор времени таймера 2 мин                     ///
    private lateinit var button4minTimer: Button    // Выбор времени таймера 3 мин                     ///
    // Кнопки ////////////////////////////////////////////////////////////////////////////////////////////

    // Переменные для датчика положения
    private lateinit var mSensorManager: SensorManager
    private lateinit var mOrientation: Sensor
    private var xyAngle = 0f
    private var xzAngle = 0f
    private var zyAngle = 0f
    private lateinit var xyView: TextView
    private lateinit var xzView: TextView
    private lateinit var zyView: TextView
    // Переменные для датчика положения

    private lateinit var notificationManager: NotificationManager
    private lateinit var notificationManagerCompat: NotificationManagerCompat

    private lateinit var alarmManager: AlarmManager

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private var sharedPreferences: SharedPreferences? = null

    private var timeTraining = 0

    private lateinit var pendingIntent: PendingIntent // Для поиска будильника

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Инициализируем все переменные
        init()

        // Инициализация кнопок
        initButtons()

        // Запускаем сервис
        actionOnService(Actions.START)

        // При запуске переключаем на громкий режим
        setRingerModeMine(AudioManager.RINGER_MODE_NORMAL)

        val databaseObserver = Observer<List<TrainingEntity>> {
            Log.d("observerMine", it.size.toString())
        }
        mainViewModel.allLiveData.observe(this, databaseObserver)
    }

    private fun init() {
        val filter = IntentFilter(BROADCAST_ACTION)
        registerReceiver(receiver, filter)

        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val button = data?.getIntExtra(EXTRA_BUTTON, 0)
                val count = data?.getIntExtra(EXTRA_COUNT, 0)
                val but = findViewById<Button>(button!!)
                but.setTextColor(Color.GREEN)
                but.text = "$count"
                //finish()
                //var intent = Intent(Intent.ACTION_MAIN)
                //intent.addCategory(Intent.CATEGORY_ALTERNATIVE)
                //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                //startActivity(intent)

                //var intent = Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER)
                //startActivity(intent)
            }
        }

        xyView = findViewById(R.id.xyValue)
        xzView = findViewById(R.id.xzValue)
        zyView = findViewById(R.id.zyValue)
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mOrientation = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)
        mSensorManager.registerListener(this, mOrientation, SensorManager.SENSOR_DELAY_UI)
    }

    private fun initButtons() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button10 = findViewById(R.id.button10)
        createArrayButtons()
        arrayButtons.forEach {
            // Настройка кнопок
            it.textSize = 20.0F
            it.setOnClickListener(this)

            // Заполнение сохраненными значениями и цветом
            val key1 = it.id.toString()
            val key2 = it.id.toString() + "C"
            val text = sharedPreferences?.getString(key1, "")
            it.text = text
            val color = sharedPreferences?.getInt(key2, 0)
            if (color != null) {
                it.setTextColor(color)
            }
        }

        buttonReport = findViewById(R.id.buttonReport)
        buttonReport.setOnClickListener {
            buttonReset.isEnabled = true
            var string = ""
            var counter = 0

            val date = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                .format(Calendar.getInstance().time)
            string = string + date + "\n"

            for (i in 1..arrayButtons.size) {
                counter += arrayButtons[i-1].text.toString().toInt()
                string = string + "$i - ${arrayButtons[i-1].text} $counter 3" + "\n"
            }
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.setPackage("com.google.android.keep")
            intent.putExtra(Intent.EXTRA_TEXT, string)
            startActivity(intent)
        }

        buttonReset = findViewById(R.id.buttonReset)
        buttonReset.isEnabled = true
        buttonReset.setOnClickListener {
            // Очищаем сохраненные состояния кнопок
            val editor = sharedPreferences?.edit()
            editor?.clear()
            editor?.apply()
            // Кнопки заполняем значения от 1 до 10
            for (a in 1..arrayButtons.size) {
                arrayButtons[a-1].text = a.toString()
                arrayButtons[a-1].setTextColor(Color.BLACK)
            }
        }

        buttonStop = findViewById(R.id.buttonStop)
        buttonStop.setOnClickListener {
            actionOnService(Actions.STOP)
            try {
                alarmManager.cancel(pendingIntent)
            } catch (e: Exception) {
                Toast.makeText(this, "Исключение при отключении будильника", Toast.LENGTH_SHORT).show()
            }
            setRingerModeMine(AudioManager.RINGER_MODE_SILENT)
            finish()
        }

        buttonStart = findViewById(R.id.buttonStart)
        buttonStart.setOnClickListener {
            actionOnService(Actions.START)
        }

        buttonStopAlarm = findViewById(R.id.buttonStopAlarm)
        buttonStopAlarm.setOnClickListener {
            actionOnService(Actions.STOP_ALARM)
        }

        button3minTimer = findViewById(R.id.button3minTimer)
        button3minTimer.isEnabled = false
        button3minTimer.setOnClickListener {
            button3minTimer.isEnabled = false
            button4minTimer.isEnabled = true
            val editor = sharedPreferences?.edit()
            editor?.putInt(SHARED_TRAINING_TIME, 180)
            editor?.apply()
        }

        button4minTimer = findViewById(R.id.button4minTimer)
        button4minTimer.setOnClickListener {
            button3minTimer.isEnabled = true
            button4minTimer.isEnabled = false
            val editor = sharedPreferences?.edit()
            editor?.putInt(SHARED_TRAINING_TIME, 240)
            editor?.apply()
        }
    }

    private fun setTestAlarm() {
        if (sharedPreferences != null) {
            timeTraining = sharedPreferences!!.getInt(SHARED_TRAINING_TIME, 0)
        }
        val calendar = Calendar.getInstance().timeInMillis + (timeTraining * 1000)
        val calendar2 = Calendar.getInstance()
        calendar2.timeInMillis = calendar

        val intent = Intent(this, EndlessService::class.java)
        intent.action = Actions.PLAY.name
        pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        setAlarm(calendar2, pendingIntent)

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

//    private fun getAlarmInfoPendingIntent(): PendingIntent {
//        //val alarmInfoIntent = Intent(this, MainActivity::class.java)
//        //alarmInfoIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
//        //return PendingIntent.getActivity(this, 0, alarmInfoIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
//    }

    override fun onClick(v: View?) {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra(EXTRA_BUTTON_1, v?.id)
        resultLauncher.launch(intent)
    }

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val startAlarm = intent?.getIntExtra(SET_ALARM, 0)
            if (startAlarm == 100) {
                Toast.makeText(context, "Сработала тревога", Toast.LENGTH_SHORT).show()
                setTestAlarm()
            }
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            xyAngle = event.values[0]  //Плоскость XY
            xzAngle = event.values[1] //Плоскость XZ
            zyAngle = event.values[2] //Плоскость ZY
        }

        xyView.text = xyAngle.toInt().toString()
        xzView.text = xzAngle.toInt().toString()
        zyView.text = zyAngle.toInt().toString()
    }

    private fun setRingerModeMine(ringerMode: Int){
        if (!notificationManager.isNotificationPolicyAccessGranted) {
            val intent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
            startActivity(intent)
        }
        val am = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        am.ringerMode = ringerMode
    }

    private fun actionOnService(action: Actions) {
        if (getServiceState(this) == ServiceState.STOPPED && action == Actions.STOP) return
        Intent(this, EndlessService::class.java).also {
            it.action = action.name
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //log("Starting the service in >=26 Mode")
                startForegroundService(it)
                return
            }
            //log("Starting the service in < 26 Mode")
            startService(it)
        }
    }

    override fun onResume() {
        super.onResume()
        mSensorManager.registerListener(this, mOrientation, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onDestroy() {
        super.onDestroy()
        arrayButtons.forEach {
            val editor = sharedPreferences?.edit()
            editor?.putString("${it.id}", it.text.toString())
            editor?.putInt("${it.id}C", it.currentTextColor)
            editor?.apply()
        }
        unregisterReceiver(receiver)
        setRingerModeMine(AudioManager.RINGER_MODE_SILENT)
        //mSensorManager.unregisterListener(this)
        val date = Intent()
        setResult(Activity.RESULT_OK, date)
        finish()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    private fun createArrayButtons() {
        arrayButtons.add(button1)
        arrayButtons.add(button2)
        arrayButtons.add(button3)
        arrayButtons.add(button4)
        arrayButtons.add(button5)
        arrayButtons.add(button6)
        arrayButtons.add(button7)
        arrayButtons.add(button8)
        arrayButtons.add(button9)
        arrayButtons.add(button10)
    }
}