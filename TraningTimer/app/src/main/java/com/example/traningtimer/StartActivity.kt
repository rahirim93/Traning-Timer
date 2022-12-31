package com.example.traningtimer

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import android.view.Gravity
import android.widget.TextView

class StartActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        textView = findViewById(R.id.textView)


        // Проверка приложения, применена ли к нему оптимизация батареи
        val powerManager = getSystemService(POWER_SERVICE) as PowerManager
        val isIgnoring = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            powerManager.isIgnoringBatteryOptimizations(packageName)
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        if (isIgnoring) {
            startActivity(Intent(this, MainActivity::class.java))
            //textView.text = "Выключите оптимизацию расхода батареии"
        } else {
            textView.gravity = Gravity.CENTER
            textView.text = "Выключите оптимизацию расхода батареи\n и перезапустите приложение"
            startActivity(Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS))
        }



    }
}