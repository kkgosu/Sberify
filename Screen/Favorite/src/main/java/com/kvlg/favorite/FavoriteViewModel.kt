package com.kvlg.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.kvlg.core_db.DatabaseRepository
import com.kvlg.core_utils.Result
import com.kvlg.spotify_api.converter.ViewModelConverter
import com.kvlg.spotify_common.domain.AlbumDomainModel
import com.kvlg.spotify_common.domain.TrackDomainModel
import com.kvlg.spotify_common.presentation.AlbumModel
import com.kvlg.spotify_common.presentation.TrackModel

class FavoriteViewModel @ViewModelInject constructor(
    private val databaseRepo: DatabaseRepository,
    private val modelConverter: ViewModelConverter
) : ViewModel() {

    private val favoriteTracksTrigger = MutableLiveData<String>()
    private val favoriteAlbumsTrigger = MutableLiveData<String>()

    val favoriteTracks: LiveData<List<TrackModel>> = favoriteTracksTrigger.switchMap { query ->
        if (query == TRIGGER_WITHOUT_FILTER) {
            loadFavoriteTracks { databaseRepo.loadFavoriteTracks() }
        } else {
            loadFavoriteTracks { databaseRepo.loadFavoriteTracksByName(query) }
        }
    }

    val favoriteAlbums: LiveData<List<AlbumModel>> = favoriteAlbumsTrigger.switchMap { query ->
        if (query == TRIGGER_WITHOUT_FILTER) {
            loadFavoriteAlbums { databaseRepo.loadFavoriteAlbums() }
        } else {
            loadFavoriteAlbums { databaseRepo.loadFavoriteAlbumsByName(query) }
        }
    }

    fun loadFavorite(query: String = TRIGGER_WITHOUT_FILTER) {
        favoriteTracksTrigger.value = query
        favoriteAlbumsTrigger.value = query
    }

    private fun loadFavoriteTracks(block: () -> LiveData<List<TrackDomainModel>>) =
        block().map { list -> list.map(modelConverter::makeTrackModel) }

    private fun loadFavoriteAlbums(block: () -> LiveData<List<AlbumDomainModel>>) =
        block().map { it.map { album -> modelConverter.makeAlbumModel(album, Result.Status.SUCCESS, null) } }

    companion object {
        private const val TRIGGER_WITHOUT_FILTER = ""
    }
}