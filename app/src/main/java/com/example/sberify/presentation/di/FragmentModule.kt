package com.example.sberify.presentation.di

import com.example.sberify.presentation.ui.albuminfo.AlbumInfoFragment
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
    abstract fun contributeAlbumInfoFragment(): AlbumInfoFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoriteFragment(): FavoriteFragment

    @ContributesAndroidInjector
    abstract fun contributeLyricsFragment(): LyricsFragment

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment
}