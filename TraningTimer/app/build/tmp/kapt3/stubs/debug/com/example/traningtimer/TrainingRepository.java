package com.example.traningtimer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0019\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u000fJ\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u001dJ\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u0018J\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u001dJ\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020!J\u0016\u0010)\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020%J\u0006\u0010*\u001a\u00020\u001bJ\u0006\u0010+\u001a\u00020%J\u0016\u0010,\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020-J\u0006\u0010.\u001a\u00020\u001bJ\u0016\u0010/\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\u001bJ\u0006\u00100\u001a\u00020\u001bJ\u0019\u00101\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0016\u00102\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001bJ\u0006\u00104\u001a\u00020\u000fJ\u0016\u00105\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u00106\u001a\u00020%J\u000e\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u001bJ\u000e\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020%J\u0016\u0010;\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020-J\u000e\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u001bJ\u0016\u0010?\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u001bJ\u000e\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006C"}, d2 = {"Lcom/example/traningtimer/TrainingRepository;", "", "trainingDao", "Lcom/example/traningtimer/database/TrainingDao;", "appScope", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "(Lcom/example/traningtimer/database/TrainingDao;Lkotlinx/coroutines/CoroutineScope;Landroid/content/Context;)V", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "sharedPreferences", "Landroid/content/SharedPreferences;", "addItem", "", "trainingEntity", "Lcom/example/traningtimer/database/TrainingEntity;", "changeBlocked", "clearSharPref", "delete", "(Lcom/example/traningtimer/database/TrainingEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "filtered", "Lkotlinx/coroutines/flow/Flow;", "", "filterMode", "", "find", "Landroidx/lifecycle/LiveData;", "id", "Ljava/util/UUID;", "findLastTraining", "Ljava/util/Calendar;", "getAllFlow", "getAllLiveData", "getBlocked", "", "getColor", "defaultValue", "getDate", "getEnabled", "getSeekBarState", "getStarted", "getText", "", "getType", "getVisibility", "getWeight", "save", "setColor", "color", "setDate", "setEnabled", "isEnabled", "setSeekBarState", "state", "setStarted", "isStarted", "setText", "text", "setType", "type", "setVisibility", "visibility", "setWeight", "weight", "app_debug"})
public final class TrainingRepository {
    private final com.example.traningtimer.database.TrainingDao trainingDao = null;
    private final kotlinx.coroutines.CoroutineScope appScope = null;
    private final android.content.Context context = null;
    private final java.util.concurrent.ExecutorService executor = null;
    
    /**
     * Отразить в окне настроек уже выбранные вес и тип.
     * Отразить также что тренировка была уже начата если мы зашли туда после ее начала.
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.traningtimer.database.TrainingEntity>> getAllFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.traningtimer.database.TrainingEntity>> filtered(int filterMode) {
        return null;
    }
    
    public final void addItem(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingEntity trainingEntity) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.traningtimer.database.TrainingEntity> find(@org.jetbrains.annotations.Nullable()
    java.util.UUID id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Calendar> findLastTraining() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object save(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingEntity trainingEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingEntity trainingEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void deleteAll() {
    }
    
    public final void clearSharPref() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getText(int id, @org.jetbrains.annotations.NotNull()
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
    
    public final void setText(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void setColor(int id, int color) {
    }
    
    public final void setEnabled(int id, boolean isEnabled) {
    }
    
    public final void setVisibility(int id, int visibility) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Calendar getDate() {
        return null;
    }
    
    public final void setDate() {
    }
    
    public final boolean getBlocked() {
        return false;
    }
    
    public final void changeBlocked() {
    }
    
    public final int getSeekBarState() {
        return 0;
    }
    
    public final void setSeekBarState(int state) {
    }
}