package com.example.traningtimer

import androidx.lifecycle.ViewModel
import com.example.traningtimer.database.TrainingEntity

class MainViewModel(private val trainingRepository: TrainingRepository): ViewModel() {

    var allLiveData = trainingRepository.getAllLiveData()

    fun addTraining(trainingEntity: TrainingEntity) = trainingRepository.addItem(trainingEntity)

    fun deleteAll() = trainingRepository.deleteAll()
}