package com.kvlg.shared.domain.lyrics

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kvlg.model.common.Result
import com.kvlg.model.presentation.Artist
import com.kvlg.model.presentation.Track
import com.kvlg.shared.data.LyricsRepository
import com.kvlg.shared.domain.suggestions.MainCoroutineRule
import com.kvlg.shared.domain.suggestions.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * @author Konstantin Koval
 * @since 03.11.2020
 */
class LyricsUseCasesTest {

    private val track = Track(
        id = "1",
        name = "name",
        image = null,
        artists = listOf(
            Artist(
                id = "2",
                image = null,
                name = "artist name",
                genres = null
            )
        ),
        lyrics = "hey thats lyrics",
        isFavorite = true
    )

    private val repo = object : LyricsRepository {
        override fun getLyricsFromDb(track: Track): Track? {
            return track
        }

        override suspend fun parseLyricsFromGenius(track: Track): Track {
            return track
        }
    }

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @Test
    fun submit() {
        coroutineRule.runBlockingTest {
            val result = GetLyricsUseCase(repo, coroutineRule.testDispatcher)(track)
            assertEquals(Result.success(track), result)
        }

        coroutineRule.runBlockingTest {
            val result = ParseLyricsFromGeniusUseCase(repo, coroutineRule.testDispatcher)(track)
            assertEquals(Result.success(track), result)
        }
    }
}