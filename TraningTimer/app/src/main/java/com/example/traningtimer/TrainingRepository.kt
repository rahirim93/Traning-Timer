package com.example.traningtimer

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
import com.example.traningtimer.database.TrainingDao
import com.example.traningtimer.database.TrainingEntity
import com.example.traningtimer.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import java.util.concurrent.Executors


private const val SHARED_PREFERENCES_NAME1 = "shared_preferences_training_timer"

class TrainingRepository(
    private val trainingDao: TrainingDao,
    private val appScope: CoroutineScope,
    private val context: Context) {

    // Работа с базой данных
    private val executor = Executors.newSingleThreadExecutor()
    fun getAllLiveData(): LiveData<List<TrainingEntity>> = trainingDao.getAll()
    fun addItem(trainingEntity: TrainingEntity) { executor.execute { trainingDao.addTraining(trainingEntity) } }
    fun deleteAll() { executor.execute { trainingDao.deleteAll() } }

    // Работа с SharedPreferences
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME1, Context.MODE_PRIVATE)
    fun saveState(listViews: ArrayList<View>) {


    }
    // Массив с кнопками подходов
}