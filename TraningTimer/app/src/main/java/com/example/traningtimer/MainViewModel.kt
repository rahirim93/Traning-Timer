package com.example.traningtimer

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.traningtimer.database.TrainingEntity

class MainViewModel(private val trainingRepository: TrainingRepository): ViewModel() {

    var weight = -1
    var type = -1

    override fun onCleared() {
        super.onCleared()
        Log.d("viewmodel", "onCleared")
    }

    var allLiveData = trainingRepository.getAllLiveData()

    fun addTraining(trainingEntity: TrainingEntity) = trainingRepository.addItem(trainingEntity)

    fun deleteAll() = trainingRepository.deleteAll()
}