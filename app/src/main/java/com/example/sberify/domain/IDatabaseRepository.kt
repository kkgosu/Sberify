package com.example.sberify.domain

import com.example.sberify.domain.model.Suggestion
import com.example.sberify.domain.model.Track

interface IDatabaseRepository {
    suspend fun getAllSuggestions(): List<Suggestion>
    suspend fun insertSuggestion(suggestion: Suggestion)
    suspend fun updateTrack(track: Track)
}