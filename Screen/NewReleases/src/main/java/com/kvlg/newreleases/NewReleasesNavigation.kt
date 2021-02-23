package com.kvlg.newreleases

import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigator
import com.kvlg.spotify_common.presentation.AlbumModel

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
interface NewReleasesNavigation {

    fun navigateToAlbumDetails(
        navController: NavController,
        item: AlbumModel,
        extras: FragmentNavigator.Extras
    )
}