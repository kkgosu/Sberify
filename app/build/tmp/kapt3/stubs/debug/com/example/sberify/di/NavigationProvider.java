package com.example.sberify.di;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/example/sberify/di/NavigationProvider;", "", "albumDetailsNavigation", "Lcom/kvlg/albumdetails/AlbumDetailsNavigation;", "favoriteNavigation", "Lcom/kvlg/favorite/FavoriteNavigation;", "newReleasesNavigation", "Lcom/kvlg/newreleases/NewReleasesNavigation;", "searchNavigation", "Lcom/kvlg/search/SearchNavigation;", "app_debug"})
public abstract interface NavigationProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.newreleases.NewReleasesNavigation newReleasesNavigation();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.search.SearchNavigation searchNavigation();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.favorite.FavoriteNavigation favoriteNavigation();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.albumdetails.AlbumDetailsNavigation albumDetailsNavigation();
}