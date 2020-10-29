package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Track

interface IDatabaseRepository {
    suspend fun updateAlbum(album: Album)
    fun loadFavoriteTracks(): LiveData<List<Track>>
    fun loadFavoriteAlbums(): LiveData<List<Album>>
}