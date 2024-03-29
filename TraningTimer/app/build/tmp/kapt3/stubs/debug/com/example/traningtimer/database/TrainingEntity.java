package com.example.traningtimer.database;

import java.lang.System;

@androidx.room.Entity(tableName = "training_table")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0007H\u00c6\u0003J\t\u0010&\u001a\u00020\tH\u00c6\u0003J\t\u0010\'\u001a\u00020\tH\u00c6\u0003J\t\u0010(\u001a\u00020\fH\u00c6\u0003JE\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010*\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\tH\u00d6\u0001J\t\u0010-\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 \u00a8\u0006."}, d2 = {"Lcom/example/traningtimer/database/TrainingEntity;", "", "id", "Ljava/util/UUID;", "date", "Ljava/util/Calendar;", "count", "", "weight", "", "type", "isChecked", "", "(Ljava/util/UUID;Ljava/util/Calendar;Ljava/lang/String;IIZ)V", "getCount", "()Ljava/lang/String;", "setCount", "(Ljava/lang/String;)V", "getDate", "()Ljava/util/Calendar;", "setDate", "(Ljava/util/Calendar;)V", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "()Z", "setChecked", "(Z)V", "getType", "()I", "setType", "(I)V", "getWeight", "setWeight", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class TrainingEntity {
    @org.jetbrains.annotations.NotNull
    @androidx.room.PrimaryKey
    private java.util.UUID id;
    @org.jetbrains.annotations.NotNull
    private java.util.Calendar date;
    @org.jetbrains.annotations.NotNull
    private java.lang.String count;
    private int weight;
    private int type;
    private boolean isChecked;
    
    @org.jetbrains.annotations.NotNull
    public final com.example.traningtimer.database.TrainingEntity copy(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.Calendar date, @org.jetbrains.annotations.NotNull
    java.lang.String count, int weight, int type, boolean isChecked) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public TrainingEntity(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.Calendar date, @org.jetbrains.annotations.NotNull
    java.lang.String count, int weight, int type, boolean isChecked) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getDate() {
        return null;
    }
    
    public final void setDate(@org.jetbrains.annotations.NotNull
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCount() {
        return null;
    }
    
    public final void setCount(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getWeight() {
        return 0;
    }
    
    public final void setWeight(int p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getType() {
        return 0;
    }
    
    public final void setType(int p0) {
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean isChecked() {
        return false;
    }
    
    public final void setChecked(boolean p0) {
    }
}