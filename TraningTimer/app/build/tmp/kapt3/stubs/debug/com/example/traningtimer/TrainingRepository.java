package com.example.traningtimer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\u000f2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016J\u0006\u0010\u0017\u001a\u00020\u000fJ\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001a0\u0019J\u001e\u0010\u001b\u001a\u00020\u000f2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016J\u001e\u0010\u001c\u001a\u00020\u000f2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/traningtimer/TrainingRepository;", "", "trainingDao", "Lcom/example/traningtimer/database/TrainingDao;", "appScope", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "(Lcom/example/traningtimer/database/TrainingDao;Lkotlinx/coroutines/CoroutineScope;Landroid/content/Context;)V", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "sharedPreferences", "Landroid/content/SharedPreferences;", "addItem", "", "trainingEntity", "Lcom/example/traningtimer/database/TrainingEntity;", "clearSharedPreferences", "listButtons", "Ljava/util/ArrayList;", "Landroid/widget/Button;", "Lkotlin/collections/ArrayList;", "deleteAll", "getAllLiveData", "Landroidx/lifecycle/LiveData;", "", "loadStateArrayButtons", "saveStateArrayButtons", "app_debug"})
public final class TrainingRepository {
    private final com.example.traningtimer.database.TrainingDao trainingDao = null;
    private final kotlinx.coroutines.CoroutineScope appScope = null;
    private final android.content.Context context = null;
    private final java.util.concurrent.ExecutorService executor = null;
    
    /**
     * Сохранение состояния кнопок сделаем пока следующим образом.
     * В активити создаем массив кнопок которые хотим сохранить и передаем
     * сюда и здесь сохраняем в sharPref. Подгружаем также.
     */
    private final android.content.SharedPreferences sharedPreferences = null;
    
    public TrainingRepository(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingDao trainingDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope appScope, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
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
    
    public final void saveStateArrayButtons(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<android.widget.Button> listButtons) {
    }
    
    public final void loadStateArrayButtons(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<android.widget.Button> listButtons) {
    }
    
    public final void clearSharedPreferences(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<android.widget.Button> listButtons) {
    }
}