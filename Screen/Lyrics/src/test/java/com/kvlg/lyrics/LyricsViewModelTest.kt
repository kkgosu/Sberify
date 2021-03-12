package com.kvlg.lyrics

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.kvlg.core_db.DatabaseRepository
import com.kvlg.core_utils.Result
import com.kvlg.core_utils.models.RawTrackModel
import com.kvlg.genius_api.GeniusApi
import com.kvlg.genius_api.GeniusInteractor
import com.kvlg.shared.MainCoroutineRule
import com.kvlg.shared.runBlockingTest
import com.kvlg.spotify_common.presentation.TrackModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * @author Konstantin Koval
 * @since 12.03.2021
 */
class LyricsViewModelTest {
    @JvmField
    @Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @JvmField
    @Rule
    val coroutineRule = MainCoroutineRule()

    private val trackModel: LiveData<Result<TrackModel?>> = mockk(relaxed = true)
    private val interactor: GeniusInteractor = mockk {
        coEvery { getLyrics(any()) } returns trackModel
    }
    private val geniusApi: GeniusApi = mockk {
        every { interactor() } returns interactor
    }
    private val repo: DatabaseRepository = mockk(relaxed = true)

    private val lyricsObserver: Observer<Result<TrackModel?>> = mockk(relaxed = true)

    private val viewModel = LyricsViewModel(geniusApi, repo, coroutineRule.testDispatcher)

    @Before
    fun setUp() {
        setupObservers()
    }

    @Test
    fun getLyrics() {
        val trackModel: TrackModel = mockk {
            every { id } returns "id"
            every { name } returns "name"
            every { artistNames } returns "artist name"
        }

        coroutineRule.runBlockingTest {
            viewModel.getLyrics(trackModel)
        }

        coVerify {
            interactor.getLyrics(RawTrackModel("id", "name", "artist name"))
        }
    }

    private fun setupObservers() {
        viewModel.lyrics.observeForever(lyricsObserver)
    }
}