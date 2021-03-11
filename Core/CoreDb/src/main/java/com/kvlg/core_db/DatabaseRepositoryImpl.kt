package com.kvlg.core_db

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.kvlg.core_db.database.AppDatabase
import com.kvlg.core_db.database.DbConverter
import com.kvlg.core_db.database.suggestions.SuggestionsEntity
import com.kvlg.spotify_common.domain.AlbumDomainModel
import com.kvlg.spotify_common.domain.TrackDomainModel
import com.kvlg.suggestion.Suggestion
import kotlinx.coroutines.Dispatchers

internal class DatabaseRepositoryImpl(
    private val database: AppDatabase,
    private val dbConverter: DbConverter
) : DatabaseRepository {

    override suspend fun insertSuggestion(suggestion: Suggestion) {
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

    override fun getAllSuggestions(): LiveData<List<Suggestion>> {
        return database.getSuggestionsDao()
            .getAllSuggestions()
            .map {
                it.map { s -> Suggestion(s.text) }
            }

    }

    override suspend fun setTrackIsFavorite(id: String, isFavorite: Boolean) {
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
