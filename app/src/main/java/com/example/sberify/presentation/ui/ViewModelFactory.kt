package com.example.sberify.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sberify.data.AlbumConverter
import com.example.sberify.data.AlbumsConverter
import com.example.sberify.data.TracksConverter
import com.example.sberify.data.repository.SpotifyRepository

class ViewModelFactory() : ViewModelProvider.Factory {
    //private val appContext = context.applicationContext

    private val spotifyRepo by lazy {
        SpotifyRepository(AlbumsConverter(), TracksConverter(), AlbumConverter())
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
            return SharedViewModel(spotifyRepo) as T
        }
        return null as T
    }
}