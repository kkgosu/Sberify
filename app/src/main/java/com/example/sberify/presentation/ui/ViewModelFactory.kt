package com.example.sberify.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sberify.data.repository.SpotifyRepository

class ViewModelFactory() : ViewModelProvider.Factory {
    //private val appContext = context.applicationContext

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(SpotifyRepository()) as T
        }
        return null as T
    }
}