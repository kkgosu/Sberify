package com.example.sberify.presentation.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FavoriteViewModelTest {

    private lateinit var databaseRepo: IDatabaseRepository
    private lateinit var favoriteViewModel: FavoriteViewModel

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        databaseRepo = mock()
        favoriteViewModel = FavoriteViewModel(databaseRepo)
    }

    @Test
    fun loadFavorite() = runBlocking {
        val observer = mock<Observer<List<Track>>>()
        val tracks = MutableLiveData(listOf<Track>())
        whenever(databaseRepo.loadFavoriteTracks()).thenReturn(tracks)

        favoriteViewModel.favoriteTracks.observeForever(observer)
        favoriteViewModel.loadFavorite()

        delay(1000)
        verify(databaseRepo).loadFavoriteTracks()
        verify(observer).onChanged(tracks.value)
        verifyNoMoreInteractions(databaseRepo)
        return@runBlocking
    }
}