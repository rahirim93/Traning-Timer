package com.example.traningtimer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    version = 1,
    entities = [
        TrainingEntity::class
    ]
)
@TypeConverters(TrainingTypeConverters::class)
abstract class TrainingDatabase : RoomDatabase() {

    abstract fun getTrainingDao(): TrainingDao

    companion object {
        fun newInstance(context: Context) =
            Room.databaseBuilder(
                context,
                TrainingDatabase::class.java,
                "training_database"
            ).build()
    }
}