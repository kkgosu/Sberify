package com.kvlg.shared.domain.suggestions

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kvlg.model.common.Result
import com.kvlg.model.presentation.Suggestion
import com.kvlg.shared.data.suggestions.SuggestionsRepository
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * Unit tests for [LoadSuggestionUseCase] and [SaveSuggestionUseCase]
 *
 * @author Konstantin Koval
 * @since 25.10.2020
 */
class SuggestionUseCaseTest {

    private val repo = object : SuggestionsRepository {
        override fun getAllSuggestions(): List<Suggestion> {
            return listOf(Suggestion("text"))
        }

        override fun insertSuggestion(suggestion: Suggestion) {

        }
    }

    // Executes tasks in the Architecture Components in the same thread
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    // Overrides Dispatchers.Main used in Coroutines
    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @Test
    fun submit() {
        coroutineRule.runBlockingTest {
            val result = LoadSuggestionUseCase(
                repo,
                coroutineRule.testDispatcher
            )(Unit)
            assertEquals(
                result,
                Result.success(
                    listOf(Suggestion("text"))
                )
            )
        }

        coroutineRule.runBlockingTest {
            val result = SaveSuggestionUseCase(
                repo,
                coroutineRule.testDispatcher
            )("text")
            assertEquals(result, Result.success(Unit))
        }
    }
}