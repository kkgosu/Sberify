package com.kvlg.shared.data.suggestions

import com.kvlg.model.presentation.Suggestion
import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.data.db.suggestions.SuggestionsEntity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Single point of access to suggestions data for the presentation layer
 *
 * @author Konstantin Koval
 * @since 23.10.2020
 */
interface SuggestionsRepository {
    fun getAllSuggestions(): List<Suggestion>
    fun insertSuggestion(suggestion: Suggestion)
}

@Singleton
class SuggestionRepositoryImpl @Inject constructor(
    private val database: AppDatabase
) : SuggestionsRepository {

    override fun getAllSuggestions(): List<Suggestion> {
        return database.getSuggestionsDao().getAllSuggestions().map {
            Suggestion(it.text)
        }
    }

    override fun insertSuggestion(suggestion: Suggestion) {
        val suggestionEntity = SuggestionsEntity(
            id = null,
            text = suggestion.text
        )
        database.getSuggestionsDao().insertSuggestion(suggestionEntity)
        database.getSuggestionsDao().checkLimitAndDelete()
    }
}
