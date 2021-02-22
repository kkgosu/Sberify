package com.kvlg.navigation

/**
 * @author Konstantin Koval
 * @since 22.02.2021
 */
sealed class NavigationFlow {
    object NewReleasesFlow: NavigationFlow()
    object AlbumDetailsFlow: NavigationFlow()
    object LyricsFlow: NavigationFlow()
    object SearchFlow: NavigationFlow()
    object FavoriteFlow: NavigationFlow()
}
