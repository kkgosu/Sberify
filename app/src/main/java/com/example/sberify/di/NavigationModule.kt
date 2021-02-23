package com.example.sberify.di

import com.example.sberify.navigation.AlbumDetailsNavigationImpl
import com.example.sberify.navigation.FavoriteNavigationImpl
import com.example.sberify.navigation.NewReleasesNavigationImpl
import com.example.sberify.navigation.SearchNavigationImpl
import com.kvlg.albumdetails.AlbumDetailsNavigation
import com.kvlg.favorite.FavoriteNavigation
import com.kvlg.newreleases.NewReleasesNavigation
import com.kvlg.search.SearchNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
object NavigationModule : NavigationProvider {

    @Provides
    override fun newReleasesNavigation(): NewReleasesNavigation {
        return NewReleasesNavigationImpl()
    }

    @Provides
    override fun searchNavigation(): SearchNavigation {
        return SearchNavigationImpl()
    }

    @Provides
    override fun favoriteNavigation(): FavoriteNavigation {
        return FavoriteNavigationImpl()
    }

    @Provides
    override fun albumDetailsNavigation(): AlbumDetailsNavigation {
        return AlbumDetailsNavigationImpl()
    }
}