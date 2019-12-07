package com.example.sberify.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.ViewModelFactory
import com.example.sberify.presentation.ui.favorite.FavoriteViewModel
import com.example.sberify.presentation.ui.lyrics.LyricsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SharedViewModel::class)
    protected abstract fun sharedViewModel(sharedViewModel: SharedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LyricsViewModel::class)
    protected abstract fun lyricsViewModel(lyricsViewModel: LyricsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    protected abstract fun favoriteViewModel(favoriteViewModel: FavoriteViewModel): ViewModel
}