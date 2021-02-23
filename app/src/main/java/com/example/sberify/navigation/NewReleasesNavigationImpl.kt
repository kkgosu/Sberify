package com.example.sberify.navigation

import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigator
import com.kvlg.newreleases.NewReleasesFragmentDirections
import com.kvlg.newreleases.NewReleasesNavigation
import com.kvlg.spotify_common.presentation.AlbumModel

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
class NewReleasesNavigationImpl : NewReleasesNavigation {

    override fun navigateToAlbumDetails(
        navController: NavController,
        item: AlbumModel,
        extras: FragmentNavigator.Extras
    ) {
        navController.navigate(NewReleasesFragmentDirections.actionToAlbumDetailsFragment(item), extras)
    }
}