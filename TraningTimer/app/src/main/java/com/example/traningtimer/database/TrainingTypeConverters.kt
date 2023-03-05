package com.example.traningtimer.database

import androidx.room.TypeConverter
import java.util.*

class TrainingTypeConverters {

    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }

    @TypeConverter
    fun toCalendar(dateInMillis: Long): Calendar {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = dateInMillis
        return calendar
    }

    @TypeConverter
    fun fromCalendar(dateCalendar: Calendar): Long {
        return dateCalendar.timeInMillis
    }
}