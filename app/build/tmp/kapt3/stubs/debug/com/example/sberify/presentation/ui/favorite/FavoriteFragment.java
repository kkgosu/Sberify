package com.example.sberify.presentation.ui.favorite;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016H\u0016J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u001eH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/sberify/presentation/ui/favorite/FavoriteFragment;", "Lcom/example/sberify/base/BaseViewBindingFragment;", "Lcom/example/sberify/databinding/FragmentFavoriteBinding;", "Lcom/example/sberify/adapters/TrackInteraction;", "Lcom/example/sberify/adapters/AlbumInteraction;", "()V", "albumsHorizontalAdapter", "Lcom/example/sberify/adapters/AlbumsHorizontalAdapter;", "favoriteViewModel", "Lcom/example/sberify/presentation/ui/favorite/FavoriteViewModel;", "getFavoriteViewModel", "()Lcom/example/sberify/presentation/ui/favorite/FavoriteViewModel;", "favoriteViewModel$delegate", "Lkotlin/Lazy;", "sharedViewModel", "Lcom/example/sberify/presentation/ui/SharedViewModel;", "getSharedViewModel", "()Lcom/example/sberify/presentation/ui/SharedViewModel;", "sharedViewModel$delegate", "tracksAdapter", "Lcom/example/sberify/adapters/TrackListedAdapter;", "getViewBinding", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onAlbumSelected", "", "item", "Lcom/kvlg/spotify_models/presentation/AlbumModel;", "view", "onTrackSelected", "Lcom/kvlg/spotify_models/presentation/TrackModel;", "setupViews", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class FavoriteFragment extends com.example.sberify.base.BaseViewBindingFragment<com.example.sberify.databinding.FragmentFavoriteBinding> implements com.example.sberify.adapters.TrackInteraction, com.example.sberify.adapters.AlbumInteraction {
    private final kotlin.Lazy favoriteViewModel$delegate = null;
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private final com.example.sberify.adapters.AlbumsHorizontalAdapter albumsHorizontalAdapter = null;
    private final com.example.sberify.adapters.TrackListedAdapter tracksAdapter = null;
    
    private final com.example.sberify.presentation.ui.favorite.FavoriteViewModel getFavoriteViewModel() {
        return null;
    }
    
    private final com.example.sberify.presentation.ui.SharedViewModel getSharedViewModel() {
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
    com.kvlg.spotify_models.presentation.TrackModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onAlbumSelected(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_models.presentation.AlbumModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public FavoriteFragment() {
        super();
    }
}