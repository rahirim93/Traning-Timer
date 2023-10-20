package com.example.traningtimer.ui.settings;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/traningtimer/ui/settings/SettingsFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "trainingRepository", "Lcom/example/traningtimer/TrainingRepository;", "(Lcom/example/traningtimer/TrainingRepository;)V", "getDateLiveData", "Landroidx/lifecycle/LiveData;", "Ljava/util/Calendar;", "getStarted", "", "getType", "", "getWeight", "setDate", "", "setStarted", "isStarted", "setType", "type", "setWeight", "weight", "app_debug"})
public final class SettingsFragmentViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.traningtimer.TrainingRepository trainingRepository = null;
    
    public SettingsFragmentViewModel(@org.jetbrains.annotations.NotNull
    com.example.traningtimer.TrainingRepository trainingRepository) {
        super();
    }
    
    public final boolean getStarted() {
        return false;
    }
    
    public final void setStarted(boolean isStarted) {
    }
    
    public final int getWeight() {
        return 0;
    }
    
    public final void setWeight(int weight) {
    }
    
    public final int getType() {
        return 0;
    }
    
    public final void setType(int type) {
    }
    
    public final void setDate() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.Calendar> getDateLiveData() {
        return null;
    }
}