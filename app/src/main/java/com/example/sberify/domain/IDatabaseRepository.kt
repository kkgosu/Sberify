package com.example.sberify.domain

import com.example.sberify.domain.model.Suggestion

interface IDatabaseRepository {
    fun getAllSuggestions(): List<Suggestion>
    fun insertSuggestion(suggestion: Suggestion)
}