package com.example.traningtimer.ui.edit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/traningtimer/ui/edit/EditFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "trainingRepository", "Lcom/example/traningtimer/TrainingRepository;", "(Lcom/example/traningtimer/TrainingRepository;)V", "itemIdLiveData", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/UUID;", "itemLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/example/traningtimer/database/TrainingEntity;", "getItemLiveData", "()Landroidx/lifecycle/LiveData;", "setItemLiveData", "(Landroidx/lifecycle/LiveData;)V", "delete", "", "model", "getItem", "id", "save", "app_debug"})
public final class EditFragmentViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.traningtimer.TrainingRepository trainingRepository = null;
    private final androidx.lifecycle.MutableLiveData<java.util.UUID> itemIdLiveData = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.LiveData<com.example.traningtimer.database.TrainingEntity> itemLiveData;
    
    public EditFragmentViewModel(@org.jetbrains.annotations.NotNull
    com.example.traningtimer.TrainingRepository trainingRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.traningtimer.database.TrainingEntity> getItemLiveData() {
        return null;
    }
    
    public final void setItemLiveData(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LiveData<com.example.traningtimer.database.TrainingEntity> p0) {
    }
    
    public final void getItem(@org.jetbrains.annotations.NotNull
    java.util.UUID id) {
    }
    
    public final void save(@org.jetbrains.annotations.NotNull
    com.example.traningtimer.database.TrainingEntity model) {
    }
    
    public final void delete(@org.jetbrains.annotations.NotNull
    com.example.traningtimer.database.TrainingEntity model) {
    }
}