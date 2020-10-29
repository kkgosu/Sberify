package com.example.sberify.presentation.ui.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.sberify.domain.IDatabaseRepository
import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Track
import com.kvlg.shared.domain.track.TrackUseCasesProvider

class FavoriteViewModel @ViewModelInject constructor(
    private val databaseRepo: IDatabaseRepository,
    private val trackUseCases: TrackUseCasesProvider
) : ViewModel() {

    private val favoriteTracksTrigger = MutableLiveData<Unit>()
    private val favoriteAlbumsTrigger = MutableLiveData<Unit>()

    val favoriteTracks: LiveData<List<Track>> = favoriteTracksTrigger.switchMap {
        liveData {
            trackUseCases.getFavoriteTracks(Unit)
        }
    }

    val favoriteAlbums: LiveData<List<Album>> = favoriteAlbumsTrigger.switchMap {
        databaseRepo.loadFavoriteAlbums()
    }

    fun loadFavorite() {
        favoriteTracksTrigger.value = Unit
        favoriteAlbumsTrigger.value = Unit
    }
}