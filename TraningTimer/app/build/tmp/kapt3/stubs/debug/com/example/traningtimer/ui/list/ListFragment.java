package com.example.traningtimer.ui.list;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0017\u001a\u00020\u00182\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006%"}, d2 = {"Lcom/example/traningtimer/ui/list/ListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/traningtimer/databinding/FragmentListBinding;", "dataSet1", "Lcom/github/mikephil/charting/data/LineDataSet;", "dataSets", "Ljava/util/ArrayList;", "Lcom/github/mikephil/charting/interfaces/datasets/ILineDataSet;", "lineData", "Lcom/github/mikephil/charting/data/LineData;", "list", "", "Lcom/example/traningtimer/database/TrainingEntity;", "listEntry1", "Lcom/github/mikephil/charting/data/Entry;", "listViewModel", "Lcom/example/traningtimer/ui/list/ListFragmentViewModel;", "getListViewModel", "()Lcom/example/traningtimer/ui/list/ListFragmentViewModel;", "listViewModel$delegate", "Lkotlin/Lazy;", "drawGraph", "", "type", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_debug"})
public final class ListFragment extends androidx.fragment.app.Fragment {
    private com.example.traningtimer.databinding.FragmentListBinding binding;
    private final kotlin.Lazy listViewModel$delegate = null;
    private java.util.List<com.example.traningtimer.database.TrainingEntity> list;
    private java.util.ArrayList<com.github.mikephil.charting.data.Entry> listEntry1;
    private com.github.mikephil.charting.data.LineDataSet dataSet1;
    private java.util.ArrayList<com.github.mikephil.charting.interfaces.datasets.ILineDataSet> dataSets;
    private com.github.mikephil.charting.data.LineData lineData;
    
    public ListFragment() {
        super();
    }
    
    private final com.example.traningtimer.ui.list.ListFragmentViewModel getListViewModel() {
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
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void drawGraph(java.util.List<com.example.traningtimer.database.TrainingEntity> list, int type) {
    }
}