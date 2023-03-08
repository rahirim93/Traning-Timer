package com.example.traningtimer.ui.main

import android.widget.Button
import androidx.lifecycle.ViewModel
import com.example.traningtimer.TrainingRepository

class MainViewModelFrag(private val trainingRepository: TrainingRepository): ViewModel() {

    fun saveStateArrayButtons(listButtons: ArrayList<Button>) = trainingRepository.saveStateArrayButtons(listButtons)

    fun loadStateArrayButtons(listButtons: ArrayList<Button>) = trainingRepository.loadStateArrayButtons(listButtons)

    fun clearSharedPreferences(listButtons: ArrayList<Button>) = trainingRepository.clearSharedPreferences(listButtons)
}