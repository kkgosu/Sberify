package com.example.sberify.ui.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Track
import com.kvlg.shared.domain.album.AlbumUseCasesProvider
import com.kvlg.shared.domain.track.TrackUseCasesProvider

class FavoriteViewModel @ViewModelInject constructor(
    private val trackUseCases: TrackUseCasesProvider,
    private val albumUseCases: AlbumUseCasesProvider
) : ViewModel() {

    private val favoriteTracksTrigger = MutableLiveData<Unit>()
    private val favoriteAlbumsTrigger = MutableLiveData<Unit>()

    val favoriteTracks: LiveData<List<Track>> = favoriteTracksTrigger.switchMap {
        liveData {
            emit(trackUseCases.getFavoriteTracks(Unit).data!!)
        }
    }

    val favoriteAlbums: LiveData<List<Album>> = favoriteAlbumsTrigger.switchMap {
        liveData {
            emit(albumUseCases.getFavoriteTracks(Unit).data!!)
        }
    }

    fun loadFavorite() {
        favoriteTracksTrigger.value = Unit
        favoriteAlbumsTrigger.value = Unit
    }
}