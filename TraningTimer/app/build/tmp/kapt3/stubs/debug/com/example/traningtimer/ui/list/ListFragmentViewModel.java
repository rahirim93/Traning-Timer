package com.example.traningtimer.ui.list;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/traningtimer/ui/list/ListFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "trainingRepository", "Lcom/example/traningtimer/TrainingRepository;", "(Lcom/example/traningtimer/TrainingRepository;)V", "_states", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/traningtimer/ui/list/ListViewState;", "job", "Lkotlinx/coroutines/Job;", "states", "Lkotlinx/coroutines/flow/StateFlow;", "getStates", "()Lkotlinx/coroutines/flow/StateFlow;", "load", "", "filterMode", "", "app_debug"})
public final class ListFragmentViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.traningtimer.TrainingRepository trainingRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.traningtimer.ui.list.ListViewState> _states = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.traningtimer.ui.list.ListViewState> states = null;
    private kotlinx.coroutines.Job job;
    
    public ListFragmentViewModel(@org.jetbrains.annotations.NotNull()
    com.example.traningtimer.TrainingRepository trainingRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.traningtimer.ui.list.ListViewState> getStates() {
        return null;
    }
    
    public final void load(int filterMode) {
    }
}