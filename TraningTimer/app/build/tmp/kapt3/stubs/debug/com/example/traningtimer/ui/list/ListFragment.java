package com.example.traningtimer.ui.list;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001e\u0010\u0018\u001a\u00020\u00192\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\u001c\u0010%\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\u00112\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006+"}, d2 = {"Lcom/example/traningtimer/ui/list/ListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/github/mikephil/charting/listener/OnChartValueSelectedListener;", "()V", "binding", "Lcom/example/traningtimer/databinding/FragmentListBinding;", "dataSet1", "Lcom/github/mikephil/charting/data/LineDataSet;", "dataSets", "Ljava/util/ArrayList;", "Lcom/github/mikephil/charting/interfaces/datasets/ILineDataSet;", "lineData", "Lcom/github/mikephil/charting/data/LineData;", "list", "", "Lcom/example/traningtimer/database/TrainingEntity;", "listEntry1", "Lcom/github/mikephil/charting/data/Entry;", "listViewModel", "Lcom/example/traningtimer/ui/list/ListFragmentViewModel;", "getListViewModel", "()Lcom/example/traningtimer/ui/list/ListFragmentViewModel;", "listViewModel$delegate", "Lkotlin/Lazy;", "drawGraph", "", "type", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onNothingSelected", "onValueSelected", "e", "h", "Lcom/github/mikephil/charting/highlight/Highlight;", "onViewCreated", "view", "app_debug"})
public final class ListFragment extends androidx.fragment.app.Fragment implements com.github.mikephil.charting.listener.OnChartValueSelectedListener {
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
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void drawGraph(java.util.List<com.example.traningtimer.database.TrainingEntity> list, int type) {
    }
    
    @java.lang.Override
    public void onValueSelected(@org.jetbrains.annotations.Nullable
    com.github.mikephil.charting.data.Entry e, @org.jetbrains.annotations.Nullable
    com.github.mikephil.charting.highlight.Highlight h) {
    }
    
    @java.lang.Override
    public void onNothingSelected() {
    }
}