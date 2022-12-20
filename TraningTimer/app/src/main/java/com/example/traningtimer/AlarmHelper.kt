package com.example.traningtimer

import android.content.Context
import android.content.SharedPreferences

class AlarmHelper(val context: Context) {

    private var sharedPreferences: SharedPreferences? = null

    init {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }



}