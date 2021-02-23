package com.example.sberify.navigation

import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigator
import com.kvlg.albumdetails.AlbumDetailsFragmentDirections
import com.kvlg.albumdetails.AlbumDetailsNavigation
import com.kvlg.spotify_common.presentation.TrackModel

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
class AlbumDetailsNavigationImpl : AlbumDetailsNavigation {

    override fun navigateToLyrics(navController: NavController, item: TrackModel, extras: FragmentNavigator.Extras) {
        navController.navigate(AlbumDetailsFragmentDirections.actionToLyricsFragment(item), extras)
    }
}