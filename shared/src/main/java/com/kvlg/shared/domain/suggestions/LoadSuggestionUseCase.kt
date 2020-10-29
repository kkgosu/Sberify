package com.kvlg.shared.domain.suggestions

import com.kvlg.model.presentation.Suggestion
import com.kvlg.shared.data.SuggestionsRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Loads all suggestions in search
 *
 * @author Konstantin Koval
 * @since 23.10.2020
 */
class LoadSuggestionUseCase(
    private val repository: SuggestionsRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Unit, List<Suggestion>>(dispatcher) {

    override suspend fun execute(parameters: Unit): List<Suggestion> {
        return repository.getAllSuggestions()
    }
}