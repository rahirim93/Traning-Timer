package com.example.traningtimer.traningService;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u00109\u001a\u00020\u0007H\u0002J\u001a\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u00152\u0006\u0010=\u001a\u00020\u0019H\u0016J\u0012\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020;H\u0016J\b\u0010C\u001a\u00020;H\u0016J\u0012\u0010D\u001a\u00020;2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\"\u0010G\u001a\u00020\u00192\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0019H\u0016J\u0010\u0010J\u001a\u00020;2\u0006\u0010K\u001a\u00020AH\u0016J\u0018\u0010L\u001a\u00020;2\u0006\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020 H\u0002J\b\u0010O\u001a\u00020;H\u0002J\b\u0010P\u001a\u00020;H\u0002J\b\u0010Q\u001a\u00020;H\u0002J\u0010\u0010R\u001a\u00020;2\u0006\u0010S\u001a\u00020TH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\'\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0018\u000103R\u000204X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000206X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000206X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2 = {"Lcom/example/traningtimer/traningService/EndlessService;", "Landroid/app/Service;", "Landroid/hardware/SensorEventListener;", "()V", "alarmManager", "Landroid/app/AlarmManager;", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "counter", "", "counterTimeWork", "", "flagBeep", "", "getFlagBeep", "()Z", "setFlagBeep", "(Z)V", "isServiceStarted", "leftMove", "mOrientation", "Landroid/hardware/Sensor;", "mSensorManager", "Landroid/hardware/SensorManager;", "mode", "", "notificationManagerCompat", "Landroidx/core/app/NotificationManagerCompat;", "notificationUri", "Landroid/net/Uri;", "notificationUriBeep", "pendingIntent", "Landroid/app/PendingIntent;", "rightMove", "ringtone", "Landroid/media/Ringtone;", "ringtoneBeep", "sharedPreferences", "Landroid/content/SharedPreferences;", "timeBeep", "getTimeBeep", "()I", "setTimeBeep", "(I)V", "timeRightMove", "timeToAlarm", "Ljava/util/Calendar;", "timeTraining", "vibratorHelper", "Lcom/example/traningtimer/VibrateHelper;", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "xyAngle", "", "xzAngle", "zyAngle", "createNotification", "onAccuracyChanged", "", "sensor", "accuracy", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "onStartCommand", "flags", "startId", "onTaskRemoved", "rootIntent", "setAlarm", "calendar", "alarmActionPendingIntent", "setTestAlarm", "startService", "stopService", "updateNotification", "string", "", "app_debug"})
public final class EndlessService extends android.app.Service implements android.hardware.SensorEventListener {
    private boolean flagBeep = false;
    private int timeBeep = 30;
    private android.hardware.SensorManager mSensorManager;
    private android.hardware.Sensor mOrientation;
    private float xyAngle = 0.0F;
    private float xzAngle = 0.0F;
    private float zyAngle = 0.0F;
    private boolean rightMove = false;
    private boolean leftMove = false;
    private int mode = 0;
    private android.app.AlarmManager alarmManager;
    private android.app.PendingIntent pendingIntent;
    private java.util.Calendar timeToAlarm;
    private android.os.PowerManager.WakeLock wakeLock;
    private boolean isServiceStarted = false;
    private int timeTraining = 0;
    private long timeRightMove = 0L;
    private long counter = 0L;
    private android.media.Ringtone ringtone;
    private android.net.Uri notificationUri;
    private android.media.Ringtone ringtoneBeep;
    private android.net.Uri notificationUriBeep;
    private double counterTimeWork = 0.0;
    private androidx.core.app.NotificationCompat.Builder builder;
    private androidx.core.app.NotificationManagerCompat notificationManagerCompat;
    private android.content.SharedPreferences sharedPreferences;
    private com.example.traningtimer.VibrateHelper vibratorHelper;
    
    public EndlessService() {
        super();
    }
    
    public final boolean getFlagBeep() {
        return false;
    }
    
    public final void setFlagBeep(boolean p0) {
    }
    
    public final int getTimeBeep() {
        return 0;
    }
    
    public final void setTimeBeep(int p0) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @java.lang.Override
    public void onSensorChanged(@org.jetbrains.annotations.Nullable
    android.hardware.SensorEvent event) {
    }
    
    private final void setTestAlarm() {
    }
    
    private final void setAlarm(java.util.Calendar calendar, android.app.PendingIntent alarmActionPendingIntent) {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override
    public void onAccuracyChanged(@org.jetbrains.annotations.Nullable
    android.hardware.Sensor sensor, int accuracy) {
    }
    
    private final void startService() {
    }
    
    private final void updateNotification(java.lang.String string) {
    }
    
    private final void stopService() {
    }
    
    @java.lang.Override
    public void onTaskRemoved(@org.jetbrains.annotations.NotNull
    android.content.Intent rootIntent) {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    private final androidx.core.app.NotificationCompat.Builder createNotification() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
}