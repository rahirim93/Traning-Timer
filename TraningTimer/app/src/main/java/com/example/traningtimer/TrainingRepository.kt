package com.example.traningtimer

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Button
import androidx.lifecycle.LiveData
import com.example.traningtimer.database.TrainingDao
import com.example.traningtimer.database.TrainingEntity
import kotlinx.coroutines.CoroutineScope
import java.util.Calendar
import java.util.concurrent.Executors

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.util.UUID


const val SHARED_PREFERENCES_NAME1 = "shared_preferences_training_timer"

class TrainingRepository(
    private val trainingDao: TrainingDao,
    private val appScope: CoroutineScope,
    private val context: Context) {

    // Работа с базой данных.
    private val executor = Executors.newSingleThreadExecutor()
    fun getAllLiveData(): LiveData<List<TrainingEntity>> = trainingDao.getAll()
    fun getAllFlow(): Flow<List<TrainingEntity>> = trainingDao.getAllFlow()
    fun filtered(filterMode: Int = 0) : Flow<List<TrainingEntity>> {
        return when(filterMode) {
            1 -> trainingDao.filtered(1)
            2 -> trainingDao.filtered(2)
            3 -> trainingDao.filtered(3)
            4 -> trainingDao.filtered(4)
            5 -> trainingDao.filtered12()
            else -> { trainingDao.getAllFlow() }
        }
    }
    fun addItem(trainingEntity: TrainingEntity) { executor.execute { trainingDao.addTraining(trainingEntity) } }
    fun find(id: UUID?): LiveData<TrainingEntity?> = trainingDao.findLiveData(id)
    fun findLastTraining(): LiveData<Calendar?> = trainingDao.findLastTraining()
    suspend fun save(trainingEntity: TrainingEntity) {
        withContext(appScope.coroutineContext) {
            trainingDao.save(trainingEntity)
        }
    }
    suspend fun delete(trainingEntity: TrainingEntity) {
        withContext(appScope.coroutineContext) {
            trainingDao.delete(trainingEntity)
        }
    }
    fun deleteAll() { executor.execute { trainingDao.deleteAll() } }

    // todo
    /**
     * При старте тренировки сделать так, чтобы в репозиторий записывалось время начала тренировки.
     */

    // todo
    /**
     * Расписать все возможные действия во фрагментах и обработать их.
     */

    /**
     * Отразить в окне настроек уже выбранные вес и тип.
     * Отразить также что тренировка была уже начата если мы зашли туда после ее начала.
     */

    // Работа c SharedPreferences
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME1, Context.MODE_PRIVATE)
    // Очистка SharedPreferences
    fun clearSharPref() {
        sharedPreferences.edit().apply {
            clear()
            apply()
        }
    }
    // Получения состояния кнопок
    fun getText(id: Int, defaultValue: String) : String  = sharedPreferences.getString("${id}T", defaultValue).toString()
    fun getColor(id: Int, defaultValue: Int) : Int = sharedPreferences.getInt("${id}C", defaultValue)
    fun getEnabled(id: Int, defaultValue: Boolean) : Boolean = sharedPreferences.getBoolean("${id}E", defaultValue)
    fun getVisibility(id: Int, defaultValue: Int) : Int = sharedPreferences.getInt("${id}V", defaultValue)

    // Сохранение состояния кнопок
    fun setText(id: Int, text: String) {
        sharedPreferences.edit().apply {
            putString("${id}T", text)
            apply()
        }
    }
    fun setColor(id: Int, color: Int) {
        sharedPreferences.edit().apply {
            putInt("${id}C", color)
            apply()
        }
    }
    fun setEnabled(id: Int, isEnabled: Boolean) {
        sharedPreferences.edit().apply {
            putBoolean("${id}E", isEnabled)
            apply()
        }
    }
    fun setVisibility(id: Int, visibility: Int) {
        sharedPreferences.edit().apply {
            putInt("${id}V", visibility)
            apply()
        }
    }

    // todo сделать модель для хранения состояния тренировки
    // Состояние тренировки
    fun getStarted(): Boolean = sharedPreferences.getBoolean("KEY_IS_STARTED", false)
    fun setStarted(isStarted: Boolean) {
        sharedPreferences.edit().apply {
            putBoolean("KEY_IS_STARTED", isStarted)
            apply()
        }
    }
    fun getWeight(): Int = sharedPreferences.getInt("KEY_WEIGHT", 0)
    fun setWeight(weight: Int) {
        sharedPreferences.edit().apply {
            putInt("KEY_WEIGHT", weight)
            apply()
        }
    }
    fun getType(): Int = sharedPreferences.getInt("KEY_TYPE", 1)
    fun setType(type: Int) {
        sharedPreferences.edit().apply {
            putInt("KEY_TYPE", type)
            apply()
        }
    }
    fun getDate(): Calendar {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = sharedPreferences.getLong("KEY_DATE", 0)
        return calendar
    }
    fun setDate() {
        sharedPreferences.edit().apply {
            putLong("KEY_DATE", Calendar.getInstance().timeInMillis)
            apply()
        }
    }
    fun getBlocked(): Boolean = sharedPreferences.getBoolean("KEY_BLOCKED", true)
    fun changeBlocked() {
        if (sharedPreferences.getBoolean("KEY_BLOCKED", true)) {
            sharedPreferences.edit().apply {
                putBoolean("KEY_BLOCKED", false)
                apply()
            }
        } else {
            sharedPreferences.edit().apply {
                putBoolean("KEY_BLOCKED", true)
                apply()
            }
        }
    }
}