package com.example.sberify.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ApplicationComponent.class})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/example/sberify/di/DbModule;", "", "()V", "provideAlbumDao", "Lcom/example/sberify/data/db/album/AlbumDao;", "appDatabase", "Lcom/example/sberify/data/db/AppDatabase;", "provideArtistDao", "Lcom/example/sberify/data/db/artists/ArtistDao;", "provideDatabase", "application", "Landroid/app/Application;", "provideTrackDao", "Lcom/example/sberify/data/db/track/TrackDao;", "app_debug"})
@dagger.Module()
public final class DbModule {
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.sberify.data.db.AppDatabase provideDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.sberify.data.db.album.AlbumDao provideAlbumDao(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.AppDatabase appDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.sberify.data.db.artists.ArtistDao provideArtistDao(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.AppDatabase appDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.sberify.data.db.track.TrackDao provideTrackDao(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.AppDatabase appDatabase) {
        return null;
    }
    
    public DbModule() {
        super();
    }
}