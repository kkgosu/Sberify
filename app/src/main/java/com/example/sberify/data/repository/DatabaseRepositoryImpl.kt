package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.sberify.data.DbConverter
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.suggestions.SuggestionsEntity
import com.example.sberify.domain.DatabaseRepository
import com.example.sberify.models.domain.AlbumDomainModel
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.TrackDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val dbConverter: DbConverter
) : DatabaseRepository {
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
        database.getAlbumDao().updateAlbum(id, isFavorite)
    }

    override fun loadFavoriteAlbums(): LiveData<List<AlbumDomainModel>> =
        liveData(Dispatchers.IO) {
            val data = database.getAlbumDao().loadFavoriteAlbums().map {
                it.map(dbConverter::convertAlbumEntityToDomain)
            }
            emitSource(data)
        }

}
