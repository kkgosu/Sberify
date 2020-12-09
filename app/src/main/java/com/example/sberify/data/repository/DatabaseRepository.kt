package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.album.AlbumEntity
import com.example.sberify.data.db.suggestions.SuggestionsEntity
import com.example.sberify.data.db.track.TrackEntity
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DatabaseRepository @Inject constructor(
    private val database: AppDatabase
) : IDatabaseRepository {
    override suspend fun insertSuggestion(suggestion: Suggestion) {
        withContext(Dispatchers.IO) {
            database.getSuggestionsDao()
                .insertSuggestion(SuggestionsEntity.from(suggestion))
            database.getSuggestionsDao()
                .checkLimitAndDelete()
        }
    }

    override suspend fun getAllSuggestions(): List<Suggestion> {
        return withContext(Dispatchers.IO) {
            database.getSuggestionsDao()
                .getAllSuggestions()
                .map {
                    it.toSuggestion()
                }
        }
    }

    override suspend fun updateTrack(track: Track) = withContext(Dispatchers.IO) {
        database.getTrackDao().updateTrack(TrackEntity.from(track))
    }

    override fun loadFavoriteTracks(): LiveData<List<Track>> =
        liveData(Dispatchers.IO) {
            val data = database.getTrackDao().loadFavoriteTracks().map {
                it.map { trackEntity -> trackEntity.toTrack() }
            }
            emitSource(data)
        }

    override suspend fun updateAlbum(album: Album) {
        database.getAlbumDao().updateAlbum(AlbumEntity.from(album))
    }

    override fun loadFavoriteAlbums(): LiveData<List<Album>> =
        liveData(Dispatchers.IO) {
            val data = database.getAlbumDao().loadFavoriteAlbums().map {
                it.map { albumEntity -> albumEntity.toAlbum() }
            }
            emitSource(data)
        }

}
