package com.example.traningtimer.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.traningtimer.TrainingRepository
import com.example.traningtimer.database.TrainingEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ListFragmentViewModel(private val trainingRepository: TrainingRepository): ViewModel() {
    val states = trainingRepository.getAllFlow()
        .map { ListViewState(it) }
        .stateIn(viewModelScope, SharingStarted.Eagerly, ListViewState())
}

data class ListViewState(
    val items: List<TrainingEntity> = listOf()
)