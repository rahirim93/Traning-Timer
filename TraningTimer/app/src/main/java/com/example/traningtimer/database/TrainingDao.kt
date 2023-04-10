package com.example.traningtimer.database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface TrainingDao {

    @Query("SELECT * FROM training_table")
    fun getAll() : LiveData<List<TrainingEntity>>

    @Query("SELECT * FROM training_table ORDER BY date DESC")
    fun getAllFlow() : Flow<List<TrainingEntity>>

    @Query("SELECT * FROM training_table WHERE type = :type ORDER BY date DESC")
    fun filtered(type: Int): Flow<List<TrainingEntity>>

    @Query("SELECT * FROM training_table " +
            "WHERE type=1 " +
            "OR type=2 " +
            "ORDER BY date DESC")
    fun filtered12(): Flow<List<TrainingEntity>>

    @Query("SELECT * FROM training_table WHERE id = :itemId")
    fun findFlow(itemId: UUID?): Flow<TrainingEntity?>

    @Query("SELECT * FROM training_table WHERE id = :itemId")
    fun findLiveData(itemId: UUID?): LiveData<TrainingEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(vararg entities: TrainingEntity)

    @Delete
    suspend fun delete(vararg  entities: TrainingEntity)

    @Query("DELETE FROM training_table")
    fun deleteAll()

    @Insert
    fun addTraining(trainingEntity: TrainingEntity)
}