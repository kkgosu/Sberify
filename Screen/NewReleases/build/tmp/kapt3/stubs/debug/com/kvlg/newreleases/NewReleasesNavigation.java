package com.kvlg.newreleases;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/kvlg/newreleases/NewReleasesNavigation;", "", "navigateToAlbumDetails", "", "navController", "Landroidx/navigation/NavController;", "item", "Lcom/kvlg/spotify_common/presentation/AlbumModel;", "extras", "Landroidx/navigation/fragment/FragmentNavigator$Extras;", "NewReleases_debug"})
public abstract interface NewReleasesNavigation {
    
    public abstract void navigateToAlbumDetails(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_common.presentation.AlbumModel item, @org.jetbrains.annotations.NotNull()
    androidx.navigation.fragment.FragmentNavigator.Extras extras);
}