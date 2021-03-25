package com.kvlg.favorite;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ.\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\t0\b0\u0019H\u0002J.\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b2\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\t0\b0\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/kvlg/favorite/FavoriteViewModel;", "Landroidx/lifecycle/ViewModel;", "databaseRepo", "Lcom/kvlg/core_db/DatabaseRepository;", "modelConverter", "Lcom/kvlg/spotify_api/converter/ViewModelConverter;", "(Lcom/kvlg/core_db/DatabaseRepository;Lcom/kvlg/spotify_api/converter/ViewModelConverter;)V", "favoriteAlbums", "Landroidx/lifecycle/LiveData;", "", "Lcom/kvlg/spotify_common/presentation/AlbumModel;", "getFavoriteAlbums", "()Landroidx/lifecycle/LiveData;", "favoriteAlbumsTrigger", "Landroidx/lifecycle/MutableLiveData;", "", "favoriteTracks", "Lcom/kvlg/spotify_common/presentation/TrackModel;", "getFavoriteTracks", "favoriteTracksTrigger", "loadFavorite", "", "query", "loadFavoriteAlbums", "block", "Lkotlin/Function0;", "Lcom/kvlg/spotify_common/domain/AlbumDomainModel;", "loadFavoriteTracks", "Lcom/kvlg/spotify_common/domain/TrackDomainModel;", "Companion", "Favorite_debug"})
public final class FavoriteViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.String> favoriteTracksTrigger = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> favoriteAlbumsTrigger = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.presentation.TrackModel>> favoriteTracks = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.presentation.AlbumModel>> favoriteAlbums = null;
    private final com.kvlg.core_db.DatabaseRepository databaseRepo = null;
    private final com.kvlg.spotify_api.converter.ViewModelConverter modelConverter = null;
    private static final java.lang.String TRIGGER_WITHOUT_FILTER = "";
    @org.jetbrains.annotations.NotNull()
    public static final com.kvlg.favorite.FavoriteViewModel.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.presentation.TrackModel>> getFavoriteTracks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.presentation.AlbumModel>> getFavoriteAlbums() {
        return null;
    }
    
    public final void loadFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    private final androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.presentation.TrackModel>> loadFavoriteTracks(kotlin.jvm.functions.Function0<? extends androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.domain.TrackDomainModel>>> block) {
        return null;
    }
    
    private final androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.presentation.AlbumModel>> loadFavoriteAlbums(kotlin.jvm.functions.Function0<? extends androidx.lifecycle.LiveData<java.util.List<com.kvlg.spotify_common.domain.AlbumDomainModel>>> block) {
        return null;
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public FavoriteViewModel(@org.jetbrains.annotations.NotNull()
    com.kvlg.core_db.DatabaseRepository databaseRepo, @org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_api.converter.ViewModelConverter modelConverter) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/kvlg/favorite/FavoriteViewModel$Companion;", "", "()V", "TRIGGER_WITHOUT_FILTER", "", "Favorite_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}