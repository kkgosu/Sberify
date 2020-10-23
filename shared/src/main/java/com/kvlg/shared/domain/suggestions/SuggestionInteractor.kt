package com.kvlg.shared.domain.suggestions

import com.kvlg.model.presentation.Suggestion
import com.kvlg.shared.data.suggestions.SuggestionsRepository
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Loads all suggestions in search
 *
 * @author Konstantin Koval
 * @since 23.10.2020
 */
class LoadSuggestionUseCase @Inject constructor(
    private val repository: SuggestionsRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Unit, List<Suggestion>>(dispatcher) {

    override suspend fun execute(parameters: Unit): List<Suggestion> {
        return repository.getAllSuggestions()
    }
}