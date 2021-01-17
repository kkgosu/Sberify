package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.models.domain.Suggestion
import com.kvlg.spotify_api.models.domain.AlbumDomainModel
import com.kvlg.spotify_api.models.domain.TrackDomainModel

interface DatabaseRepository {
    suspend fun getAllSuggestions(): List<Suggestion>
    suspend fun insertSuggestion(suggestion: Suggestion)
    suspend fun setAlbumIsFavorite(id: String, isFavorite: Boolean)
    suspend fun setTrackIsFavorite(id: String, isFavorite: Boolean)
    fun loadFavoriteTracks(): LiveData<List<TrackDomainModel>>
    fun loadFavoriteAlbums(): LiveData<List<AlbumDomainModel>>
}