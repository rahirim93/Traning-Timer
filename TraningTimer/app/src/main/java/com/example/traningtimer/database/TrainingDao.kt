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

    //@Query("SELECT * FROM training_table WHERE MAX(date)")
    @Query("SELECT MAX(date) FROM training_table")
    fun findLastTraining(): LiveData<Calendar?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(vararg entities: TrainingEntity)

    @Delete
    suspend fun delete(vararg  entities: TrainingEntity)

    @Query("DELETE FROM training_table")
    fun deleteAll()

    @Insert
    fun addTraining(trainingEntity: TrainingEntity)

    // Запрос последней тренировки подтягиваний
    @Query("SELECT * FROM (SELECT * FROM TRAINING_TABLE WHERE type = 1 OR type = 2) WHERE  date = (SELECT MAX(date) FROM ( SELECT * FROM TRAINING_TABLE WHERE type = 1 OR type = 2))")
    fun getLastTrainingByType() : LiveData<TrainingEntity>

    // Запрос последней тренировки для остальных видов тренировок
    @Query("SELECT * FROM (SELECT * FROM TRAINING_TABLE WHERE type = :type) WHERE  date = (SELECT MAX(date) FROM ( SELECT * FROM TRAINING_TABLE WHERE type = :type))")
    fun getLastTrainingByType2(type: Int) : LiveData<TrainingEntity>

    //SELECT * FROM (SELECT * FROM TRAINING_TABLE WHERE type = 1 OR type = 2) WHERE  date = (SELECT MAX(date) FROM ( SELECT * FROM TRAINING_TABLE WHERE type = 1 OR type = 2))
}