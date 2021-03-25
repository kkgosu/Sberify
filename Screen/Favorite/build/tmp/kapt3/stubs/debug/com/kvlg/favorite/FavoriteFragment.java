package com.kvlg.favorite;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020$H\u0016J\u0018\u0010)\u001a\u00020$2\u0006\u0010%\u001a\u00020*2\u0006\u0010\'\u001a\u00020\u001cH\u0016J\b\u0010+\u001a\u00020$H\u0002J\b\u0010,\u001a\u00020$H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/kvlg/favorite/FavoriteFragment;", "Lcom/kvlg/design/BaseViewBindingFragment;", "Lcom/kvlg/favorite/databinding/FragmentFavoriteBinding;", "Lcom/kvlg/spotify_common/adapters/TrackInteraction;", "Lcom/kvlg/spotify_common/adapters/AlbumInteraction;", "()V", "albumsHorizontalAdapter", "Lcom/kvlg/spotify_common/adapters/AlbumsHorizontalAdapter;", "favoriteViewModel", "Lcom/kvlg/favorite/FavoriteViewModel;", "getFavoriteViewModel", "()Lcom/kvlg/favorite/FavoriteViewModel;", "favoriteViewModel$delegate", "Lkotlin/Lazy;", "navigation", "Lcom/kvlg/favorite/FavoriteNavigation;", "getNavigation", "()Lcom/kvlg/favorite/FavoriteNavigation;", "setNavigation", "(Lcom/kvlg/favorite/FavoriteNavigation;)V", "sharedViewModel", "Lcom/kvlg/shared/SharedViewModel;", "getSharedViewModel", "()Lcom/kvlg/shared/SharedViewModel;", "sharedViewModel$delegate", "tracksAdapter", "Lcom/kvlg/spotify_common/adapters/TrackListedAdapter;", "getViewBinding", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onAlbumSelected", "", "item", "Lcom/kvlg/spotify_common/presentation/AlbumModel;", "view", "onResume", "onTrackSelected", "Lcom/kvlg/spotify_common/presentation/TrackModel;", "setupSearchView", "setupViews", "Favorite_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class FavoriteFragment extends com.kvlg.design.BaseViewBindingFragment<com.kvlg.favorite.databinding.FragmentFavoriteBinding> implements com.kvlg.spotify_common.adapters.TrackInteraction, com.kvlg.spotify_common.adapters.AlbumInteraction {
    @javax.inject.Inject()
    public com.kvlg.favorite.FavoriteNavigation navigation;
    private final kotlin.Lazy favoriteViewModel$delegate = null;
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private final com.kvlg.spotify_common.adapters.AlbumsHorizontalAdapter albumsHorizontalAdapter = null;
    private final com.kvlg.spotify_common.adapters.TrackListedAdapter tracksAdapter = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.kvlg.favorite.FavoriteNavigation getNavigation() {
        return null;
    }
    
    public final void setNavigation(@org.jetbrains.annotations.NotNull()
    com.kvlg.favorite.FavoriteNavigation p0) {
    }
    
    private final com.kvlg.favorite.FavoriteViewModel getFavoriteViewModel() {
        return null;
    }
    
    private final com.kvlg.shared.SharedViewModel getSharedViewModel() {
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
    
    @java.lang.Override()
    public void onAlbumSelected(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_common.presentation.AlbumModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void setupSearchView() {
    }
    
    public FavoriteFragment() {
        super();
    }
}