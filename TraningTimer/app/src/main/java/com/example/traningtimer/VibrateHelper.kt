package com.example.traningtimer

import android.app.Service
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

class VibrateHelper(context: Context) {

    private var vibrator: Vibrator = context.getSystemService(Service.VIBRATOR_SERVICE) as Vibrator
    var vibrateDelay = 1000

    fun vibrate() {
        if (vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // API 26
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        400,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                // This method was deprecated in API level 26
                vibrator.vibrate(400)
            }
        }
    }
}