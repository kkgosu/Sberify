package com.example.sberify.presentation.ui.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Track

class FavoriteViewModel @ViewModelInject constructor(
    private val databaseRepo: IDatabaseRepository
) : ViewModel() {

    private val favoriteTracksTrigger = MutableLiveData<Boolean>()
    private val favoriteAlbumsTrigger = MutableLiveData<Boolean>()

    val favoriteTracks: LiveData<List<Track>> = Transformations.switchMap(favoriteTracksTrigger) {
        databaseRepo.loadFavoriteTracks()
    }

    val favoriteAlbums: LiveData<List<Album>> = Transformations.switchMap(favoriteAlbumsTrigger) {
        databaseRepo.loadFavoriteAlbums()
    }

    fun loadFavorite() {
        favoriteTracksTrigger.value = true
        favoriteAlbumsTrigger.value = true
    }
}