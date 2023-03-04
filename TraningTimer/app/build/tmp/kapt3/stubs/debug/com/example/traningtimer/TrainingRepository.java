package com.example.traningtimer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/traningtimer/TrainingRepository;", "", "trainingDao", "Lcom/example/traningtimer/database/TrainingDao;", "appScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/example/traningtimer/database/TrainingDao;Lkotlinx/coroutines/CoroutineScope;)V", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "addItem", "", "trainingEntity", "Lcom/example/traningtimer/database/TrainingEntity;", "deleteAll", "getAllLiveData", "Landroidx/lifecycle/LiveData;", "", "app_debug"})
public final class TrainingRepository {
    private final com.example.traningtimer.database.TrainingDao trainingDao = null;
    private final kotlinx.coroutines.CoroutineScope appScope = null;
    private final java.util.concurrent.ExecutorService executor = null;
    
    public TrainingRepository(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingDao trainingDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope appScope) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.traningtimer.database.TrainingEntity>> getAllLiveData() {
        return null;
    }
    
    public final void addItem(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingEntity trainingEntity) {
    }
    
    public final void deleteAll() {
    }
}