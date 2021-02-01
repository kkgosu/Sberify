package com.kvlg.core_db

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.kvlg.core_db.database.AppDatabase
import com.kvlg.core_db.database.DbConverter
import com.kvlg.core_db.database.suggestions.SuggestionsEntity
import com.kvlg.core_utils.models.Suggestion
import com.kvlg.spotify_models.domain.AlbumDomainModel
import com.kvlg.spotify_models.domain.TrackDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DatabaseRepositoryImpl(
    private val database: AppDatabase,
    private val dbConverter: DbConverter
) : DatabaseRepository {

    override suspend fun insertSuggestion(suggestion: Suggestion) {
        withContext(Dispatchers.IO) {
            database.getSuggestionsDao()
                .insertSuggestion(
                    SuggestionsEntity(
                        id = null,
                        text = suggestion.text
                    )
                )
            database.getSuggestionsDao()
                .checkLimitAndDelete()
        }
    }

    override suspend fun getAllSuggestions(): List<Suggestion> {
        return withContext(Dispatchers.IO) {
            database.getSuggestionsDao()
                .getAllSuggestions()
                .map { Suggestion(it.text) }
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
