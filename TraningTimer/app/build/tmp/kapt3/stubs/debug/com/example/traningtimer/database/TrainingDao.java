package com.example.traningtimer.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J%\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001a\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\'J\u0010\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\'J\u001a\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\'J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\u0015H\'J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\'J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\'J%\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/example/traningtimer/database/TrainingDao;", "", "addTraining", "", "trainingEntity", "Lcom/example/traningtimer/database/TrainingEntity;", "delete", "entities", "", "([Lcom/example/traningtimer/database/TrainingEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "filtered", "Lkotlinx/coroutines/flow/Flow;", "", "type", "", "filtered12", "findFlow", "itemId", "Ljava/util/UUID;", "findLastTraining", "Landroidx/lifecycle/LiveData;", "Ljava/util/Calendar;", "findLiveData", "getAll", "getAllFlow", "getLastTrainingByType", "getLastTrainingByType2", "save", "app_debug"})
public abstract interface TrainingDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM training_table")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.traningtimer.database.TrainingEntity>> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM training_table ORDER BY date DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.traningtimer.database.TrainingEntity>> getAllFlow();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM training_table WHERE type = :type ORDER BY date DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.traningtimer.database.TrainingEntity>> filtered(int type);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM training_table WHERE type=1 OR type=2 ORDER BY date DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.traningtimer.database.TrainingEntity>> filtered12();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM training_table WHERE id = :itemId")
    public abstract kotlinx.coroutines.flow.Flow<com.example.traningtimer.database.TrainingEntity> findFlow(@org.jetbrains.annotations.Nullable()
    java.util.UUID itemId);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM training_table WHERE id = :itemId")
    public abstract androidx.lifecycle.LiveData<com.example.traningtimer.database.TrainingEntity> findLiveData(@org.jetbrains.annotations.Nullable()
    java.util.UUID itemId);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT MAX(date) FROM training_table")
    public abstract androidx.lifecycle.LiveData<java.util.Calendar> findLastTraining();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object save(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingEntity[] entities, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingEntity[] entities, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @androidx.room.Query(value = "DELETE FROM training_table")
    public abstract void deleteAll();
    
    @androidx.room.Insert()
    public abstract void addTraining(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingEntity trainingEntity);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM (SELECT * FROM TRAINING_TABLE WHERE type = 1 OR type = 2) WHERE  date = (SELECT MAX(date) FROM ( SELECT * FROM TRAINING_TABLE WHERE type = 1 OR type = 2))")
    public abstract androidx.lifecycle.LiveData<com.example.traningtimer.database.TrainingEntity> getLastTrainingByType();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM (SELECT * FROM TRAINING_TABLE WHERE type = :type) WHERE  date = (SELECT MAX(date) FROM ( SELECT * FROM TRAINING_TABLE WHERE type = :type))")
    public abstract androidx.lifecycle.LiveData<com.example.traningtimer.database.TrainingEntity> getLastTrainingByType2(int type);
}