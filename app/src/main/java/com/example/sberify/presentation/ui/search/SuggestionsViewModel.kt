package com.example.sberify.presentation.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.kvlg.model.common.Result
import com.kvlg.model.presentation.Suggestion
import com.kvlg.shared.domain.suggestions.LoadSuggestionUseCase
import com.kvlg.shared.domain.suggestions.SaveSuggestionUseCase
import kotlinx.coroutines.launch

/**
 * @author Konstantin Koval
 * @since 24.10.2020
 */
class SuggestionsViewModel @ViewModelInject constructor(
    loadSuggestionUseCase: LoadSuggestionUseCase,
    private val saveSuggestionUseCase: SaveSuggestionUseCase
) : ViewModel() {

    private val trigger = MutableLiveData<Unit>()

    fun loadSuggestions() {
        trigger.value = Unit
    }

    val suggestions: LiveData<List<Any>> = trigger.switchMap {
        liveData {
            val loadSuggestionsResult = loadSuggestionUseCase(Unit)
            when (loadSuggestionsResult.status) {
                Result.Status.LOADING -> emit(listOf(Result.loading<Suggestion>()))
                Result.Status.SUCCESS -> emit(loadSuggestionsResult.data ?: emptyList<Suggestion>())
                Result.Status.ERROR -> emit(listOf(Result.error<Suggestion>("Error while loading suggestions")))
            }
        }
    }

    fun saveSuggestion(text: String) {
        viewModelScope.launch {
            saveSuggestionUseCase(text)
        }
    }
}