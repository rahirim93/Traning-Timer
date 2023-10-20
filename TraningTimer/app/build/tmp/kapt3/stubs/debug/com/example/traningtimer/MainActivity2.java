package com.example.traningtimer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0012\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u0012\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020#H\u0014R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/example/traningtimer/MainActivity2;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "arrayButtons", "Ljava/util/ArrayList;", "Landroid/widget/Button;", "getArrayButtons", "()Ljava/util/ArrayList;", "setArrayButtons", "(Ljava/util/ArrayList;)V", "button21", "button210", "button211", "button212", "button22", "button23", "button24", "button25", "button26", "button27", "button28", "button29", "counte", "", "getCounte", "()I", "setCounte", "(I)V", "numberButton", "seekBar", "Landroid/widget/SeekBar;", "sharedPreferences", "Landroid/content/SharedPreferences;", "initArrayButtons", "", "initButtons", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_debug"})
public final class MainActivity2 extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    private android.content.SharedPreferences sharedPreferences;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<android.widget.Button> arrayButtons;
    private android.widget.SeekBar seekBar;
    private int counte = 0;
    private android.widget.Button button21;
    private android.widget.Button button22;
    private android.widget.Button button23;
    private android.widget.Button button24;
    private android.widget.Button button25;
    private android.widget.Button button26;
    private android.widget.Button button27;
    private android.widget.Button button28;
    private android.widget.Button button29;
    private android.widget.Button button210;
    private android.widget.Button button211;
    private android.widget.Button button212;
    private int numberButton = 0;
    
    public MainActivity2() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<android.widget.Button> getArrayButtons() {
        return null;
    }
    
    public final void setArrayButtons(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<android.widget.Button> p0) {
    }
    
    public final int getCounte() {
        return 0;
    }
    
    public final void setCounte(int p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initButtons() {
    }
    
    private final void initArrayButtons() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.Nullable
    android.view.View v) {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
}