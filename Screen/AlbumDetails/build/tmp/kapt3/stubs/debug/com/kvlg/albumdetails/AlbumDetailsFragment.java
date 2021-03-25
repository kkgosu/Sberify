package com.kvlg.albumdetails;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001aH\u0016J\b\u0010&\u001a\u00020\"H\u0014J\b\u0010\'\u001a\u00020\"H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006("}, d2 = {"Lcom/kvlg/albumdetails/AlbumDetailsFragment;", "Lcom/kvlg/design/BaseViewBindingFragment;", "Lcom/kvlg/albumdetails/databinding/FragmentAlbumDetailsBinding;", "Lcom/kvlg/spotify_common/adapters/TrackInteraction;", "()V", "adapter", "Lcom/kvlg/spotify_common/adapters/TrackListedAdapter;", "navArgs", "Lcom/kvlg/albumdetails/AlbumDetailsArgs;", "getNavArgs", "()Lcom/kvlg/albumdetails/AlbumDetailsArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "navigation", "Lcom/kvlg/albumdetails/AlbumDetailsNavigation;", "getNavigation", "()Lcom/kvlg/albumdetails/AlbumDetailsNavigation;", "setNavigation", "(Lcom/kvlg/albumdetails/AlbumDetailsNavigation;)V", "sharedViewModel", "Lcom/kvlg/shared/SharedViewModel;", "getSharedViewModel", "()Lcom/kvlg/shared/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "getViewBinding", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onTrackSelected", "", "item", "Lcom/kvlg/spotify_common/presentation/TrackModel;", "view", "setupViews", "subscribeToObservers", "AlbumDetails_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class AlbumDetailsFragment extends com.kvlg.design.BaseViewBindingFragment<com.kvlg.albumdetails.databinding.FragmentAlbumDetailsBinding> implements com.kvlg.spotify_common.adapters.TrackInteraction {
    @javax.inject.Inject()
    public com.kvlg.albumdetails.AlbumDetailsNavigation navigation;
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private final androidx.navigation.NavArgsLazy navArgs$delegate = null;
    private com.kvlg.spotify_common.adapters.TrackListedAdapter adapter;
    
    @org.jetbrains.annotations.NotNull()
    public final com.kvlg.albumdetails.AlbumDetailsNavigation getNavigation() {
        return null;
    }
    
    public final void setNavigation(@org.jetbrains.annotations.NotNull()
    com.kvlg.albumdetails.AlbumDetailsNavigation p0) {
    }
    
    private final com.kvlg.shared.SharedViewModel getSharedViewModel() {
        return null;
    }
    
    private final com.kvlg.albumdetails.AlbumDetailsArgs getNavArgs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected android.view.View getViewBinding(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    protected void setupViews() {
    }
    
    @java.lang.Override()
    public void onTrackSelected(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_common.presentation.TrackModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void subscribeToObservers() {
    }
    
    public AlbumDetailsFragment() {
        super();
    }
}