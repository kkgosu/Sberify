package com.kvlg.core_db

import androidx.lifecycle.LiveData
import com.kvlg.spotify_common.domain.AlbumDomainModel
import com.kvlg.spotify_common.domain.TrackDomainModel
import com.kvlg.suggestion.Suggestion

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
interface DatabaseRepository {
    fun getAllSuggestions(): LiveData<List<Suggestion>>
    suspend fun insertSuggestion(suggestion: Suggestion)
    suspend fun setAlbumIsFavorite(id: String, isFavorite: Boolean)
    suspend fun setTrackIsFavorite(id: String, isFavorite: Boolean)
    fun loadFavoriteTracks(): LiveData<List<TrackDomainModel>>
    fun loadFavoriteAlbums(): LiveData<List<AlbumDomainModel>>
}