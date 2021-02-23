package com.kvlg.favorite

import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigator
import com.kvlg.spotify_common.presentation.AlbumModel
import com.kvlg.spotify_common.presentation.TrackModel

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
interface FavoriteNavigation {

    fun navigateToLyrics(
        navController: NavController,
        item: TrackModel,
        extras: FragmentNavigator.Extras
    )

    fun navigateToAlbumDetails(
        navController: NavController,
        item: AlbumModel,
        extras: FragmentNavigator.Extras
    )
}