package com.example.traningtimer.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'\u00a8\u0006\n"}, d2 = {"Lcom/example/traningtimer/database/TrainingDao;", "", "addTraining", "", "trainingEntity", "Lcom/example/traningtimer/database/TrainingEntity;", "deleteAll", "getAll", "Landroidx/lifecycle/LiveData;", "", "app_debug"})
public abstract interface TrainingDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM training_table")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.traningtimer.database.TrainingEntity>> getAll();
    
    @androidx.room.Query(value = "DELETE FROM training_table")
    public abstract void deleteAll();
    
    @androidx.room.Insert()
    public abstract void addTraining(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.database.TrainingEntity trainingEntity);
}