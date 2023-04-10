package com.example.traningtimer.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J%\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001a\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\'J\u001a\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\'J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\u0015H\'J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J%\u0010\u0018\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/example/traningtimer/database/TrainingDao;", "", "addTraining", "", "trainingEntity", "Lcom/example/traningtimer/database/TrainingEntity;", "delete", "entities", "", "([Lcom/example/traningtimer/database/TrainingEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "filtered", "Lkotlinx/coroutines/flow/Flow;", "", "type", "", "filtered12", "findFlow", "itemId", "Ljava/util/UUID;", "findLiveData", "Landroidx/lifecycle/LiveData;", "getAll", "getAllFlow", "save", "app_debug"})
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
}