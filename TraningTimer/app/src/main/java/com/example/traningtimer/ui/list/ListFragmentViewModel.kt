package com.example.traningtimer.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.traningtimer.TrainingRepository
import com.example.traningtimer.database.TrainingEntity
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ListFragmentViewModel(private val trainingRepository: TrainingRepository): ViewModel() {
    private val _states = MutableStateFlow(ListViewState())
    val states = _states.asStateFlow()
    private var job: Job? = null

    init {
        load(0)
    }

    fun load(filterMode: Int) {
        job?.cancel()

        job = viewModelScope.launch {
            trainingRepository.filtered(filterMode).collect {
                _states.emit(ListViewState(it, 0))
            }
        }
    }

    fun getBlocked() = trainingRepository.getBlocked()

    fun changeBlocked() = trainingRepository.changeBlocked()


//    val states = trainingRepository.getAllFlow()
//        .map { ListViewState(it) }
//        .stateIn(viewModelScope, SharingStarted.Eagerly, ListViewState())
}

data class ListViewState(
    val items: List<TrainingEntity> = listOf(),
    val filterMode: Int = 0
)