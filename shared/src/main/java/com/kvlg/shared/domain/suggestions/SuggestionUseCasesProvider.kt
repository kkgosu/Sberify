package com.kvlg.shared.domain.suggestions

import com.kvlg.shared.data.SuggestionsRepository
import com.kvlg.shared.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author Konstantin Koval
 * @since 28.10.2020
 */
interface SuggestionUseCasesProvider {
    val saveSuggestion: SaveSuggestionUseCase
    val loadSuggestion: LoadSuggestionUseCase
}

class SuggestionUseCasesProviderImpl(
    private val repository: SuggestionsRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : SuggestionUseCasesProvider {

    override val saveSuggestion: SaveSuggestionUseCase
        get() = SaveSuggestionUseCase(repository, dispatcher)

    override val loadSuggestion: LoadSuggestionUseCase
        get() = LoadSuggestionUseCase(repository, dispatcher)
}