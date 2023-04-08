package com.example.traningtimer.ui.settings

import androidx.lifecycle.ViewModel
import com.example.traningtimer.TrainingRepository

class SettingsFragmentViewModel(private val trainingRepository: TrainingRepository): ViewModel() {
    fun getStarted(): Boolean = trainingRepository.getStarted()
    fun setStarted(isStarted: Boolean) = trainingRepository.setStarted(isStarted)

    fun getWeight(): Int = trainingRepository.getWeight()
    fun setWeight(weight: Int) = trainingRepository.setWeight(weight)

    fun getType(): Int = trainingRepository.getType()
    fun setType(type: Int) = trainingRepository.setType(type)

    fun setDate() = trainingRepository.setDate()
}