package com.example.traningtimer.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0014\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/example/traningtimer/database/TrainingTypeConverters;", "", "()V", "fromCalendar", "", "dateCalendar", "Ljava/util/Calendar;", "fromUUID", "", "uuid", "Ljava/util/UUID;", "toCalendar", "dateInMillis", "toUUID", "app_debug"})
public final class TrainingTypeConverters {
    
    public TrainingTypeConverters() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.TypeConverter
    public final java.util.UUID toUUID(@org.jetbrains.annotations.Nullable
    java.lang.String uuid) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.TypeConverter
    public final java.lang.String fromUUID(@org.jetbrains.annotations.Nullable
    java.util.UUID uuid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.util.Calendar toCalendar(long dateInMillis) {
        return null;
    }
    
    @androidx.room.TypeConverter
    public final long fromCalendar(@org.jetbrains.annotations.NotNull
    java.util.Calendar dateCalendar) {
        return 0L;
    }
}