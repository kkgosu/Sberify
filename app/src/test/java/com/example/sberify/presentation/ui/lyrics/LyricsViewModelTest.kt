package com.example.sberify.presentation.ui.lyrics

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.sberify.MockTestUtils.Companion.mockTrack
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LyricsViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var databaseRepo: IDatabaseRepository
    private lateinit var lyricsViewModel: LyricsViewModel

    @Before
    fun setUp() {
        databaseRepo = mock()
        lyricsViewModel = LyricsViewModel(databaseRepo)
    }

    @Test
    fun updateTrack() = runBlocking {
        val track = mockTrack()
        lyricsViewModel.updateTrack(track)
        delay(1000)
        verify(databaseRepo).updateTrack(track)
    }
}