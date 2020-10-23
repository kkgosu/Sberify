package com.example.sberify.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.sberify.MockTestUtils.Companion.mockTrack
import com.example.sberify.data.db.AppDatabase
import com.kvlg.shared.data.db.suggestions.SuggestionsDao
import com.kvlg.shared.data.db.suggestions.SuggestionsEntity
import com.kvlg.shared.data.db.track.TrackDao
import com.kvlg.shared.data.db.track.TrackEntity
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DatabaseRepositoryTest {

    private val database: AppDatabase = mock()

    private lateinit var repo: DatabaseRepository

    @Before
    fun setUp() {
        repo = DatabaseRepository(database)
    }

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun insertSuggestion() = runBlocking {
        val sDao = mock<SuggestionsDao>()
        whenever(database.getSuggestionsDao()).thenReturn(sDao)

        repo.insertSuggestion(Suggestion("text"))
        verify(database, times(2)).getSuggestionsDao()
        verify(sDao).checkLimitAndDelete()
        verify(sDao).insertSuggestion(SuggestionsEntity.from(Suggestion("text")))

        return@runBlocking
    }

    @Test
    fun getAllSuggestions() = runBlocking {
        val sDao = mock<SuggestionsDao>()
        whenever(database.getSuggestionsDao()).thenReturn(sDao)

        repo.getAllSuggestions()
        verify(database).getSuggestionsDao()
        verify(sDao).getAllSuggestions()
        return@runBlocking
    }

    @Test
    fun updateTrack() = runBlocking {
        val tDao = mock<TrackDao>()
        whenever(database.getTrackDao()).thenReturn(tDao)

        repo.updateTrack(mockTrack())
        verify(database).getTrackDao()
        verify(tDao).updateTrack(TrackEntity.from(mockTrack()))
        return@runBlocking
    }

    @Test
    fun loadFavoriteTracks() = runBlocking {
        val tDao = mock<TrackDao>()
        whenever(database.getTrackDao()).thenReturn(tDao)

        repo.loadFavoriteTracks()
        verify(database).getTrackDao()
        verify(tDao).loadFavoriteTracks()
        return@runBlocking
    }
}