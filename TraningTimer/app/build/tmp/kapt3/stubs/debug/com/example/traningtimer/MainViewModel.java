package com.example.traningtimer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u000eR&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/traningtimer/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "trainingRepository", "Lcom/example/traningtimer/TrainingRepository;", "(Lcom/example/traningtimer/TrainingRepository;)V", "allLiveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/traningtimer/database/TrainingEntity;", "getAllLiveData", "()Landroidx/lifecycle/LiveData;", "setAllLiveData", "(Landroidx/lifecycle/LiveData;)V", "addTraining", "", "trainingEntity", "deleteAll", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.traningtimer.TrainingRepository trainingRepository = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.LiveData<java.util.List<com.example.traningtimer.database.TrainingEntity>> allLiveData;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.TrainingRepository trainingRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.traningtimer.database.TrainingEntity>> getAllLiveData() {
        return null;
    }
    
    public final void setAllLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.List<com.example.traningtimer.database.TrainingEntity>> p0) {
    }
    
    public final void addTraining(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingEntity trainingEntity) {
    }
    
    public final void deleteAll() {
    }
}