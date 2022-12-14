package com.example.traningtimer

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class StartActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        textView = findViewById(R.id.textView)

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "not ok", Toast.LENGTH_SHORT).show()
                finish()
            }
        }


        // Проверка приложения, применена ли к нему оптимизация батареи
        val powerManager = getSystemService(POWER_SERVICE) as PowerManager
        val isIgnoring = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            powerManager.isIgnoringBatteryOptimizations(packageName)
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        if (isIgnoring) {
            resultLauncher.launch(Intent(this, MainActivity::class.java))
        } else {
            textView.gravity = Gravity.CENTER
            textView.text = "Выключите оптимизацию расхода батареи\n и перезапустите приложение"
            startActivity(Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS))
        }






    }
}