package com.example.sberify.data.repository

import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.suggestions.SuggestionsEntity
import com.example.sberify.data.db.track.TrackEntity
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.model.Suggestion
import com.example.sberify.domain.model.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DatabaseRepository(private val database: AppDatabase) : IDatabaseRepository {
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
            val sugs = database.getSuggestionsDao()
                    .getAllSuggestions()
            
            sugs.map { it.toSuggestion() }
        }
    }

    override suspend fun updateTrack(track: Track) {
        withContext(Dispatchers.IO) {
            database.getTrackDao()
                    .updateTrack(TrackEntity.from(track))
        }
    }
}