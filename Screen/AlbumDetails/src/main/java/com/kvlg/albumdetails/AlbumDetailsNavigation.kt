package com.kvlg.albumdetails

import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigator
import com.kvlg.spotify_common.presentation.TrackModel

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
interface AlbumDetailsNavigation {

    fun navigateToLyrics(
        navController: NavController,
        item: TrackModel,
        extras: FragmentNavigator.Extras
    )
}