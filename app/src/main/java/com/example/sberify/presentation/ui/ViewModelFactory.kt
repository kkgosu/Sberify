package com.example.sberify.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sberify.data.repository.GeniusRepository
import com.example.sberify.data.DataConverter
import com.example.sberify.data.GeniusParser
import com.example.sberify.data.repository.SpotifyRepository

class ViewModelFactory() : ViewModelProvider.Factory {
    //private val appContext = context.applicationContext

    private val spotifyRepo by lazy {
        SpotifyRepository(DataConverter())
    }

    private val geniusRepo by lazy {
        GeniusRepository(GeniusParser())
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
            return SharedViewModel(spotifyRepo, geniusRepo) as T
        }
        return null as T
    }
}