package com.example.sberify.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.sberify.SberifyApp
import com.example.sberify.data.repository.GeniusRepository
import com.example.sberify.data.DataConverter
import com.example.sberify.data.GeniusParser
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.repository.DatabaseRepository
import com.example.sberify.data.repository.SpotifyRepository
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.presentation.ui.favorite.FavoriteViewModel
import com.example.sberify.presentation.ui.lyrics.LyricsViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory() : ViewModelProvider.Factory {
    //private val appContext = context.applicationContext

    private val appDatabase by lazy {
        Room.databaseBuilder(SberifyApp.getContext(), AppDatabase::class.java, "database")
                .fallbackToDestructiveMigration()
                .build()
    }

    private val spotifyRepo by lazy {
        SpotifyRepository(DataConverter(), appDatabase)
    }

    private val geniusRepo by lazy {
        GeniusRepository(GeniusParser(), appDatabase)
    }

    private val databaseRepo by lazy {
        DatabaseRepository(appDatabase) as IDatabaseRepository
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SharedViewModel::class.java) -> SharedViewModel(
                    spotifyRepo, geniusRepo, databaseRepo) as T
            modelClass.isAssignableFrom(LyricsViewModel::class.java) -> LyricsViewModel(
                    databaseRepo) as T
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> FavoriteViewModel(
                    databaseRepo) as T
            else -> null as T
        }
    }
}