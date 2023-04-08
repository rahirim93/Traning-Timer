package com.example.traningtimer.ui.save

import androidx.lifecycle.ViewModel
import com.example.traningtimer.TrainingRepository
import com.example.traningtimer.database.TrainingEntity

class SaveFragmentViewModel(private val trainingRepository: TrainingRepository): ViewModel() {
    fun getText(id: Int, defaultValue: String) = trainingRepository.getText(id, defaultValue)
    fun getColor(id: Int, defaultValue: Int) = trainingRepository.getColor(id, defaultValue)

    fun getWeight() = trainingRepository.getWeight()

    fun getType() = trainingRepository.getType()

    fun addItem(trainingEntity: TrainingEntity) = trainingRepository.addItem(trainingEntity)

    fun getAllLiveData() = trainingRepository.getAllLiveData()

    fun clearDatabase() = trainingRepository.deleteAll()

    fun getDate() = trainingRepository.getDate()
}