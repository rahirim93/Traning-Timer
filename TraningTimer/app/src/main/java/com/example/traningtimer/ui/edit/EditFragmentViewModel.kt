package com.example.traningtimer.ui.edit

import androidx.lifecycle.*
import com.example.traningtimer.TrainingRepository
import com.example.traningtimer.database.TrainingEntity
import kotlinx.coroutines.launch
import java.util.UUID

class EditFragmentViewModel(
    private val trainingRepository: TrainingRepository): ViewModel() {

    private val itemIdLiveData = MutableLiveData<UUID>()
    var itemLiveData: LiveData<TrainingEntity?> =
        Transformations
            .switchMap(itemIdLiveData) { itemId ->
                trainingRepository.find(itemId)
            }

    fun getItem(id: UUID) {
        itemIdLiveData.value = id
    }

    fun save(model: TrainingEntity) {
        viewModelScope.launch {
            trainingRepository.save(model)
        }
    }

    fun delete(model: TrainingEntity) {
        viewModelScope.launch {
            trainingRepository.delete(model)
        }
    }
}

data class EditFragmentViewState(
    val item: TrainingEntity? = null
)