package com.example.sberify.domain

import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.Track

interface IDatabaseRepository {
    suspend fun getAllSuggestions(): List<Suggestion>
    suspend fun insertSuggestion(suggestion: Suggestion)
    suspend fun updateTrack(track: Track)
    suspend fun loadFavoriteTracks(): List<Track>
}