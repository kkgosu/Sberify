package com.example.sberify.presentation.ui.favorite;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/sberify/presentation/ui/favorite/FavoriteViewModel;", "Landroidx/lifecycle/ViewModel;", "databaseRepo", "Lcom/example/sberify/domain/DatabaseRepository;", "(Lcom/example/sberify/domain/DatabaseRepository;)V", "favoriteAlbums", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/sberify/models/newdomain/AlbumDomainModel;", "getFavoriteAlbums", "()Landroidx/lifecycle/LiveData;", "favoriteAlbumsTrigger", "Landroidx/lifecycle/MutableLiveData;", "", "favoriteTracks", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "getFavoriteTracks", "favoriteTracksTrigger", "loadFavorite", "", "app_debug"})
public final class FavoriteViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> favoriteTracksTrigger = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> favoriteAlbumsTrigger = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.sberify.models.newdomain.TrackDomainModel>> favoriteTracks = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>> favoriteAlbums = null;
    private final com.example.sberify.domain.DatabaseRepository databaseRepo = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.sberify.models.newdomain.TrackDomainModel>> getFavoriteTracks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>> getFavoriteAlbums() {
        return null;
    }
    
    public final void loadFavorite() {
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public FavoriteViewModel(@org.jetbrains.annotations.NotNull()
    com.example.sberify.domain.DatabaseRepository databaseRepo) {
        super();
    }
}