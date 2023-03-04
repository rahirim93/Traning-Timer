package com.example.traningtimer.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TrainingDao {

    @Query("SELECT * FROM training_table")
    fun getAll() : LiveData<List<TrainingEntity>>

    @Query("DELETE FROM training_table")
    fun deleteAll()

    @Insert
    fun addTraining(trainingEntity: TrainingEntity)
}