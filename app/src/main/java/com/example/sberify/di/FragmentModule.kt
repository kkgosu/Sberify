package com.example.sberify.di

import com.example.sberify.presentation.ui.albuminfo.AlbumDetailsFragment
import com.example.sberify.presentation.ui.favorite.FavoriteFragment
import com.example.sberify.presentation.ui.lyrics.LyricsFragment
import com.example.sberify.presentation.ui.newreleases.NewReleasesFragment
import com.example.sberify.presentation.ui.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeNewReleasesFragment(): NewReleasesFragment 

    @ContributesAndroidInjector
    abstract fun contributeAlbumInfoFragment(): AlbumDetailsFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoriteFragment(): FavoriteFragment

    @ContributesAndroidInjector
    abstract fun contributeLyricsFragment(): LyricsFragment

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment
}