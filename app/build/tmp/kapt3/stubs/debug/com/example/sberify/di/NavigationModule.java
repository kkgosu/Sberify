package com.example.sberify.di;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ActivityRetainedComponent.class})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\b\u0010\u0005\u001a\u00020\u0006H\u0017J\b\u0010\u0007\u001a\u00020\bH\u0017J\b\u0010\t\u001a\u00020\nH\u0017\u00a8\u0006\u000b"}, d2 = {"Lcom/example/sberify/di/NavigationModule;", "Lcom/example/sberify/di/NavigationProvider;", "()V", "albumDetailsNavigation", "Lcom/kvlg/albumdetails/AlbumDetailsNavigation;", "favoriteNavigation", "Lcom/kvlg/favorite/FavoriteNavigation;", "newReleasesNavigation", "Lcom/kvlg/newreleases/NewReleasesNavigation;", "searchNavigation", "Lcom/kvlg/search/SearchNavigation;", "app_debug"})
@dagger.Module()
public final class NavigationModule implements com.example.sberify.di.NavigationProvider {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.sberify.di.NavigationModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @dagger.Provides()
    public com.kvlg.newreleases.NewReleasesNavigation newReleasesNavigation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @dagger.Provides()
    public com.kvlg.search.SearchNavigation searchNavigation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @dagger.Provides()
    public com.kvlg.favorite.FavoriteNavigation favoriteNavigation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @dagger.Provides()
    public com.kvlg.albumdetails.AlbumDetailsNavigation albumDetailsNavigation() {
        return null;
    }
    
    private NavigationModule() {
        super();
    }
}