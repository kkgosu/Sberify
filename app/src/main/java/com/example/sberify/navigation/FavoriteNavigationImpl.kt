package com.example.sberify.navigation

import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigator
import com.kvlg.favorite.FavoriteFragmentDirections
import com.kvlg.favorite.FavoriteNavigation
import com.kvlg.spotify_common.presentation.AlbumModel
import com.kvlg.spotify_common.presentation.TrackModel

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
class FavoriteNavigationImpl : FavoriteNavigation {

    override fun navigateToLyrics(navController: NavController, item: TrackModel, extras: FragmentNavigator.Extras) {
        navController.navigate(FavoriteFragmentDirections.actionToLyricsFragment(item), extras)
    }

    override fun navigateToAlbumDetails(navController: NavController, item: AlbumModel, extras: FragmentNavigator.Extras) {
        navController.navigate(FavoriteFragmentDirections.actionToAlbumDetailsFragment(item), extras)
    }
}