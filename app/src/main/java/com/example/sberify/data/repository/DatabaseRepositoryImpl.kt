package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.sberify.data.converters.DbConverter
import com.example.sberify.domain.DatabaseRepository
import com.example.sberify.models.domain.Suggestion
import com.kvlg.spotify_api.models.domain.AlbumDomainModel
import com.kvlg.spotify_api.models.domain.TrackDomainModel
import com.kvlg.spotify_impl.data.database.AppDatabase
import com.kvlg.spotify_impl.data.database.suggestions.SuggestionsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DatabaseRepositoryImpl(
    private val database: com.kvlg.spotify_impl.data.database.AppDatabase,
    private val dbConverter: DbConverter
) : DatabaseRepository {
    override suspend fun insertSuggestion(suggestion: Suggestion) {
        withContext(Dispatchers.IO) {
            database.getSuggestionsDao()
                .insertSuggestion(com.kvlg.spotify_impl.data.database.suggestions.SuggestionsEntity.from(suggestion))
            database.getSuggestionsDao()
                .checkLimitAndDelete()
        }
    }

    override suspend fun getAllSuggestions(): List<Suggestion> {
        return withContext(Dispatchers.IO) {
            database.getSuggestionsDao()
                .getAllSuggestions()
                .map(com.kvlg.spotify_impl.data.database.suggestions.SuggestionsEntity::toSuggestion)
        }
    }

    override suspend fun setTrackIsFavorite(id: String, isFavorite: Boolean) = withContext(Dispatchers.IO) {
        database.getTrackDao().setTrackIsFavorite(id, isFavorite)
    }

    override fun loadFavoriteTracks(): LiveData<List<TrackDomainModel>> =
        liveData(Dispatchers.IO) {
            val data = database.getTrackDao().loadFavoriteTracks().map {
                it.map(dbConverter::convertTrackEntityToDomain)
            }
            emitSource(data)
        }

    override suspend fun setAlbumIsFavorite(id: String, isFavorite: Boolean) {
        database.getAlbumDao().setAlbumIsFavorite(id, isFavorite)
    }

    override fun loadFavoriteAlbums(): LiveData<List<AlbumDomainModel>> =
        liveData(Dispatchers.IO) {
            val data = database.getAlbumDao().loadFavoriteAlbums().map {
                it.map(dbConverter::convertAlbumEntityToDomain)
            }
            emitSource(data)
        }

}
