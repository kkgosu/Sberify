package com.example.sberify.presentation.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kvlg.model.presentation.Suggestion
import com.kvlg.shared.Result
import com.kvlg.shared.domain.suggestions.LoadSuggestionUseCase

/**
 * @author Konstantin Koval
 * @since 24.10.2020
 */
class SuggestionsViewModel @ViewModelInject constructor(
    loadSuggestionUseCase: LoadSuggestionUseCase
) : ViewModel() {

    val suggestions: LiveData<List<Any>> = liveData {
        val loadSuggestionsResult = loadSuggestionUseCase(Unit)
        when (loadSuggestionsResult.status) {
            Result.Status.LOADING -> emit(listOf(Result.loading<Suggestion>()))
            Result.Status.SUCCESS -> emit(loadSuggestionsResult.data ?: emptyList<Suggestion>())
            Result.Status.ERROR -> emit(listOf(Result.error<Suggestion>("Error while loading suggestions")))
        }
    }
}