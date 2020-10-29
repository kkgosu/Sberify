package com.kvlg.shared.domain.suggestions

import com.kvlg.model.presentation.Suggestion
import com.kvlg.shared.data.SuggestionsRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Save suggestion into DB
 *
 * @author Konstantin Koval
 * @since 25.10.2020
 */
class SaveSuggestionUseCase(
    private val suggestionsRepository: SuggestionsRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<String, Unit>(dispatcher) {

    override suspend fun execute(parameters: String) {
        suggestionsRepository.insertSuggestion(Suggestion(parameters))
    }
}