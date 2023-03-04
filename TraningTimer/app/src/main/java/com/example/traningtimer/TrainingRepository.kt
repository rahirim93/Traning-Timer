package com.example.traningtimer

import androidx.lifecycle.LiveData
import com.example.traningtimer.database.TrainingDao
import com.example.traningtimer.database.TrainingEntity
import kotlinx.coroutines.CoroutineScope
import java.util.concurrent.Executors


class TrainingRepository(
    private val trainingDao: TrainingDao,
    private val appScope: CoroutineScope) {

    private val executor = Executors.newSingleThreadExecutor()

    fun getAllLiveData(): LiveData<List<TrainingEntity>> = trainingDao.getAll()

    fun addItem(trainingEntity: TrainingEntity) {
        executor.execute {
            trainingDao.addTraining(trainingEntity)
        }
    }

    fun deleteAll() {
        executor.execute {
            trainingDao.deleteAll()
        }
    }
}