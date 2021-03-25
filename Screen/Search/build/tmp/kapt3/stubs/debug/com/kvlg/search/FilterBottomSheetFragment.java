package com.kvlg.search;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 30.06.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001a"}, d2 = {"Lcom/kvlg/search/FilterBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Lcom/kvlg/search/databinding/FilterBottomSheetLayoutBinding;", "binding", "getBinding", "()Lcom/kvlg/search/databinding/FilterBottomSheetLayoutBinding;", "getTheme", "", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", "view", "Companion", "Search_debug"})
public final class FilterBottomSheetFragment extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    private com.kvlg.search.databinding.FilterBottomSheetLayoutBinding _binding;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "FilterBottomSheetFragment";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARTIST_SWITCH_CHECKED_KEY = "ArtistSwitchChecked";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ALBUM_SWITCH_CHECKED_KEY = "AlbumSwitchChecked";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TRACK_SWITCH_CHECKED_KEY = "TrackSwitchChecked";
    @org.jetbrains.annotations.NotNull()
    public static final com.kvlg.search.FilterBottomSheetFragment.Companion Companion = null;
    
    private final com.kvlg.search.databinding.FilterBottomSheetLayoutBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    public int getTheme() {
        return 0;
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
    public void onCancel(@org.jetbrains.annotations.NotNull()
    android.content.DialogInterface dialog) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public FilterBottomSheetFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/kvlg/search/FilterBottomSheetFragment$Companion;", "", "()V", "ALBUM_SWITCH_CHECKED_KEY", "", "ARTIST_SWITCH_CHECKED_KEY", "TAG", "TRACK_SWITCH_CHECKED_KEY", "Search_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}