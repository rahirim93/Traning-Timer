package com.example.traningtimer.ui.main

import android.widget.Button
import androidx.lifecycle.ViewModel
import com.example.traningtimer.TrainingRepository

class MainViewModelFrag(private val trainingRepository: TrainingRepository): ViewModel() {

    fun getText(id: Int, defaultValue: String) = trainingRepository.getText(id, defaultValue)
    fun getColor(id: Int, defaultValue: Int) = trainingRepository.getColor(id, defaultValue)
    fun getEnabled(id: Int, defaultValue: Boolean) = trainingRepository.getEnabled(id, defaultValue)
    fun getVisibility(id: Int, defaultValue: Int) = trainingRepository.getVisibility(id, defaultValue)

    fun setText(id: Int, text: String) = trainingRepository.setText(id, text)
    fun setColor(id: Int, color: Int) = trainingRepository.setColor(id, color)
    fun setEnabled(id: Int, isEnabled: Boolean) = trainingRepository.setEnabled(id, isEnabled)
    fun setVisibility(id: Int, visibility: Int) = trainingRepository.setVisibility(id, visibility)

    fun setStarted(isStarted: Boolean) = trainingRepository.setStarted(isStarted)

    fun clearSharPref() = trainingRepository.clearSharPref()
}