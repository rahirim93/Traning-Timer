package com.example.traningtimer.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006%"}, d2 = {"Lcom/example/traningtimer/ui/main/MainFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/example/traningtimer/databinding/ActivityMainBinding;", "listTrainingButtons", "Ljava/util/ArrayList;", "Landroid/widget/Button;", "mainViewModel", "Lcom/example/traningtimer/ui/main/MainViewModelFrag;", "getMainViewModel", "()Lcom/example/traningtimer/ui/main/MainViewModelFrag;", "mainViewModel$delegate", "Lkotlin/Lazy;", "actionOnService", "", "action", "Lcom/example/traningtimer/traningService/Actions;", "initButtons", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setRingerMode", "ringerMode", "", "setThings", "app_debug"})
public final class MainFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    
    /**
     * Подумать о хранении в следующем виде:
     * вся информация о тренировке будет храниться не в тексте кнопок,
     * а в репозитории. И в зависимости от состояния репозитория будут изменяться состояния кнопок.
     *
     * Нажатие кнопки будем не обрабатывать здесь, а нажатием будем менять состояние репозитория,
     * а при возвращении будем перерисовывать вид исходя из изменений репозитория
     */
    private final kotlin.Lazy mainViewModel$delegate = null;
    private com.example.traningtimer.databinding.ActivityMainBinding binding;
    private final java.util.ArrayList<android.widget.Button> listTrainingButtons = null;
    
    public MainFragment() {
        super();
    }
    
    /**
     * Подумать о хранении в следующем виде:
     * вся информация о тренировке будет храниться не в тексте кнопок,
     * а в репозитории. И в зависимости от состояния репозитория будут изменяться состояния кнопок.
     *
     * Нажатие кнопки будем не обрабатывать здесь, а нажатием будем менять состояние репозитория,
     * а при возвращении будем перерисовывать вид исходя из изменений репозитория
     */
    private final com.example.traningtimer.ui.main.MainViewModelFrag getMainViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    /**
     * При входе:
     * если тренировка не сброшена, то продолжить
     * если сброшена, то выбрать тренировку вес и тп
     * в репозитории []ранить состояние тренировки вес и тп, так пусковой фрагмент будет понимать запускать ся или нет
     */
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    private final void initButtons() {
    }
    
    private final void setThings() {
    }
    
    private final void setRingerMode(int ringerMode) {
    }
    
    private final void actionOnService(com.example.traningtimer.traningService.Actions action) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}