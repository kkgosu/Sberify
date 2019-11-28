package com.example.sberify.data.repository

import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.suggestions.SuggestionsEntity
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.model.Suggestion

class DatabaseRepository(private val database: AppDatabase): IDatabaseRepository {
    override fun insertSuggestion(suggestion: Suggestion) {
        database.getSuggestionsDao().insertSuggestion(SuggestionsEntity.from(suggestion))
        database.getSuggestionsDao().checkLimitAndDelete()
    }

    override fun getAllSuggestions(): List<Suggestion> {
        val sugs = database.getSuggestionsDao().getAllSuggestions()
        return sugs.map { it.toSuggestion() }
    }

}