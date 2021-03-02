package com.kvlg.favorite;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/kvlg/favorite/FavoriteViewModel;", "Landroidx/lifecycle/ViewModel;", "databaseRepo", "Lcom/kvlg/core_db/DatabaseRepository;", "modelConverter", "Lcom/kvlg/spotify_api/converter/ViewModelConverter;", "(Lcom/kvlg/core_db/DatabaseRepository;Lcom/kvlg/spotify_api/converter/ViewModelConverter;)V", "favoriteAlbums", "Landroidx/lifecycle/LiveData;", "", "Lcom/kvlg/spotify_common/presentation/AlbumModel;", "getFavoriteAlbums", "()Landroidx/lifecycle/LiveData;", "favoriteAlbumsTrigger", "Landroidx/lifecycle/MutableLiveData;", "", "favoriteTracks", "Lcom/kvlg/spotify_common/presentation/TrackModel;", "getFavoriteTracks", "favoriteTracksTrigger", "loadFavorite", "", "Favorite_debug"})
public final class FavoriteViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> favoriteTracksTrigger = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> favoriteAlbumsTrigger = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.presentation.TrackModel>> favoriteTracks = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.presentation.AlbumModel>> favoriteAlbums = null;
    private final com.kvlg.core_db.DatabaseRepository databaseRepo = null;
    private final com.kvlg.spotify_api.converter.ViewModelConverter modelConverter = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.presentation.TrackModel>> getFavoriteTracks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.presentation.AlbumModel>> getFavoriteAlbums() {
        return null;
    }
    
    public final void loadFavorite() {
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public FavoriteViewModel(@org.jetbrains.annotations.NotNull()
    com.kvlg.core_db.DatabaseRepository databaseRepo, @org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_api.converter.ViewModelConverter modelConverter) {
        super();
    }
}