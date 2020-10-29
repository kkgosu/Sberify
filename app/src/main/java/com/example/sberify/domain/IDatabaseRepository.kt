package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.kvlg.model.presentation.Album

interface IDatabaseRepository {
    suspend fun updateAlbum(album: Album)
    fun loadFavoriteAlbums(): LiveData<List<Album>>
}