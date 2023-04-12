package com.example.traningtimer.ui.save;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\fJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/traningtimer/ui/save/SaveFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "trainingRepository", "Lcom/example/traningtimer/TrainingRepository;", "(Lcom/example/traningtimer/TrainingRepository;)V", "addItem", "", "trainingEntity", "Lcom/example/traningtimer/database/TrainingEntity;", "changeBlocked", "clearDatabase", "getAllLiveData", "Landroidx/lifecycle/LiveData;", "", "getBlocked", "", "getColor", "", "id", "defaultValue", "getDate", "Ljava/util/Calendar;", "getText", "", "getType", "getWeight", "app_debug"})
public final class SaveFragmentViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.traningtimer.TrainingRepository trainingRepository = null;
    
    public SaveFragmentViewModel(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.TrainingRepository trainingRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getText(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultValue) {
        return null;
    }
    
    public final int getColor(int id, int defaultValue) {
        return 0;
    }
    
    public final int getWeight() {
        return 0;
    }
    
    public final int getType() {
        return 0;
    }
    
    public final void addItem(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingEntity trainingEntity) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.traningtimer.database.TrainingEntity>> getAllLiveData() {
        return null;
    }
    
    public final void clearDatabase() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Calendar getDate() {
        return null;
    }
    
    public final boolean getBlocked() {
        return false;
    }
    
    public final void changeBlocked() {
    }
}