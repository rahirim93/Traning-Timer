package com.example.traningtimer.traningService

import android.content.Context
import android.util.Log
import android.widget.Toast

fun log(msg: String) {
    Log.d("ENDLESS-SERVICE", msg)
}

fun toast(context: Context ,msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}