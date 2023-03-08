package com.example.traningtimer

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Button
import androidx.lifecycle.LiveData
import com.example.traningtimer.database.TrainingDao
import com.example.traningtimer.database.TrainingEntity
import kotlinx.coroutines.CoroutineScope
import java.util.concurrent.Executors


private const val SHARED_PREFERENCES_NAME1 = "shared_preferences_training_timer"

class TrainingRepository(
    private val trainingDao: TrainingDao,
    private val appScope: CoroutineScope,
    private val context: Context) {

    // Работа с базой данных.
    private val executor = Executors.newSingleThreadExecutor()
    fun getAllLiveData(): LiveData<List<TrainingEntity>> = trainingDao.getAll()
    fun addItem(trainingEntity: TrainingEntity) { executor.execute { trainingDao.addTraining(trainingEntity) } }
    fun deleteAll() { executor.execute { trainingDao.deleteAll() } }

    /**
     * Сохранение состояния кнопок сделаем пока следующим образом.
     * В активити создаем массив кнопок которые хотим сохранить и передаем
     * сюда и здесь сохраняем в sharPref. Подгружаем также.
     */
    // Работа с SharedPreferences
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME1, Context.MODE_PRIVATE)
    // Сохранение состояния массива кнопок.
    fun saveStateArrayButtons(listButtons: ArrayList<Button>) {
        val editor = sharedPreferences.edit()
        listButtons.forEach {
            editor.putString("${it.id}", it.text.toString()) // Сохраняем текст
            editor.putInt("${it.id}C", it.currentTextColor) // Сохраняем цвет текста
            editor.putBoolean("${it.id}E", it.isEnabled) // Сохраняем состояние isEnabled
            editor.putInt("${it.id}V", it.visibility) // Сохраняем состояние visibility
        }
        editor.apply()
    }
    fun loadStateArrayButtons(listButtons: ArrayList<Button>) {
        listButtons.forEach {
            it.text = sharedPreferences.getString("${it.id}", "")
            it.setTextColor(sharedPreferences.getInt("${it.id}C", Color.BLACK))
            it.isEnabled = sharedPreferences.getBoolean("${it.id}E", true)
            it.visibility = sharedPreferences.getInt("${it.id}V", View.VISIBLE)
        }
    }
    fun clearSharedPreferences(listButtons: ArrayList<Button>) {
        val editor = sharedPreferences.edit()
        editor.clear()
        listButtons.forEachIndexed { index, button ->
            editor.putString("${button.id}", "${index + 1}")
        }
        editor.apply()
    }
}