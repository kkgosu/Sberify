package com.kvlg.core_db

import androidx.lifecycle.LiveData
import com.kvlg.core_utils.models.Suggestion
import com.kvlg.spotify_models.domain.AlbumDomainModel
import com.kvlg.spotify_models.domain.TrackDomainModel

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
interface DatabaseRepository {
    suspend fun getAllSuggestions(): List<Suggestion>
    suspend fun insertSuggestion(suggestion: Suggestion)
    suspend fun setAlbumIsFavorite(id: String, isFavorite: Boolean)
    suspend fun setTrackIsFavorite(id: String, isFavorite: Boolean)
    fun loadFavoriteTracks(): LiveData<List<TrackDomainModel>>
    fun loadFavoriteAlbums(): LiveData<List<AlbumDomainModel>>
}