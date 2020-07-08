package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.Track

interface IDatabaseRepository {
    suspend fun getAllSuggestions(): List<Suggestion>
    suspend fun insertSuggestion(suggestion: Suggestion)
    suspend fun updateAlbum(album: Album)
    suspend fun updateTrack(track: Track)
    fun loadFavoriteTracks(): LiveData<List<Track>>
    fun loadFavoriteAlbums(): LiveData<List<Album>>
}