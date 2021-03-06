package com.kvlg.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.kvlg.core_db.DatabaseRepository
import com.kvlg.core_utils.Result
import com.kvlg.spotify_api.converter.ViewModelConverter
import com.kvlg.spotify_common.presentation.AlbumModel
import com.kvlg.spotify_common.presentation.TrackModel

class FavoriteViewModel @ViewModelInject constructor(
    private val databaseRepo: DatabaseRepository,
    private val modelConverter: ViewModelConverter
) : ViewModel() {

    private val favoriteTracksTrigger = MutableLiveData<Boolean>()
    private val favoriteAlbumsTrigger = MutableLiveData<Boolean>()

    val favoriteTracks: LiveData<List<TrackModel>> = Transformations.switchMap(favoriteTracksTrigger) {
        databaseRepo.loadFavoriteTracks().map { list ->
            list.map(modelConverter::makeTrackModel)
        }
    }

    val favoriteAlbums: LiveData<List<AlbumModel>> = Transformations.switchMap(favoriteAlbumsTrigger) {
        databaseRepo.loadFavoriteAlbums().map { list ->
            list.map { album -> modelConverter.makeAlbumModel(album, Result.Status.SUCCESS, null) }
        }
    }

    fun loadFavorite() {
        favoriteTracksTrigger.value = true
        favoriteAlbumsTrigger.value = true
    }
}