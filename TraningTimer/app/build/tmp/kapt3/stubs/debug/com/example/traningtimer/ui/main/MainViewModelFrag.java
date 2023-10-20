package com.example.traningtimer.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bJ\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\fJ\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0011J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/traningtimer/ui/main/MainViewModelFrag;", "Landroidx/lifecycle/ViewModel;", "trainingRepository", "Lcom/example/traningtimer/TrainingRepository;", "(Lcom/example/traningtimer/TrainingRepository;)V", "clearSharPref", "", "getColor", "", "id", "defaultValue", "getEnabled", "", "getLastTraining", "Landroidx/lifecycle/LiveData;", "Lcom/example/traningtimer/database/TrainingEntity;", "getText", "", "getVisibility", "setColor", "color", "setEnabled", "isEnabled", "setStarted", "isStarted", "setText", "text", "setVisibility", "visibility", "app_debug"})
public final class MainViewModelFrag extends androidx.lifecycle.ViewModel {
    private final com.example.traningtimer.TrainingRepository trainingRepository = null;
    
    public MainViewModelFrag(@org.jetbrains.annotations.NotNull
    com.example.traningtimer.TrainingRepository trainingRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getText(int id, @org.jetbrains.annotations.NotNull
    java.lang.String defaultValue) {
        return null;
    }
    
    public final int getColor(int id, int defaultValue) {
        return 0;
    }
    
    public final boolean getEnabled(int id, boolean defaultValue) {
        return false;
    }
    
    public final int getVisibility(int id, int defaultValue) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.traningtimer.database.TrainingEntity> getLastTraining() {
        return null;
    }
    
    public final void setText(int id, @org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final void setColor(int id, int color) {
    }
    
    public final void setEnabled(int id, boolean isEnabled) {
    }
    
    public final void setVisibility(int id, int visibility) {
    }
    
    public final void setStarted(boolean isStarted) {
    }
    
    public final void clearSharPref() {
    }
}