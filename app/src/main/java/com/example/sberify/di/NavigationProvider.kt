package com.example.sberify.di

import com.kvlg.albumdetails.AlbumDetailsNavigation
import com.kvlg.favorite.FavoriteNavigation
import com.kvlg.newreleases.NewReleasesNavigation
import com.kvlg.search.SearchNavigation

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
interface NavigationProvider {

    fun newReleasesNavigation(): NewReleasesNavigation

    fun searchNavigation(): SearchNavigation

    fun favoriteNavigation(): FavoriteNavigation

    fun albumDetailsNavigation(): AlbumDetailsNavigation
}