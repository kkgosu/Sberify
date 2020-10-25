package com.example.sberify.presentation.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.sberify.MockTestUtils.Companion.mockAlbum
import com.example.sberify.MockTestUtils.Companion.mockTrack
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.ISpotifyRepository
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SharedViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var spotifyRepository: ISpotifyRepository
    private lateinit var geniusRepository: IGeniusRepository
    private lateinit var databaseRepository: IDatabaseRepository
    private lateinit var tokenData: TokenData

    @Before
    fun setUp() {
        spotifyRepository = mock()
        geniusRepository = mock()
        databaseRepository = mock()
        tokenData = mock()
        sharedViewModel = SharedViewModel(spotifyRepository, geniusRepository, databaseRepository, tokenData)
    }


    @Test
    fun getAlbumInfo() = runBlocking {
        val observer = mock<Observer<Result<Album>>>()
        val album = mockAlbum()
        sharedViewModel.album.observeForever(observer)
        sharedViewModel.getAlbumInfo(album)
        verify(spotifyRepository).getAlbumInfo(album.id)
        verifyNoMoreInteractions(spotifyRepository)
        return@runBlocking
    }

    @Test
    fun getNewReleases() = runBlocking {
        val observer = mock<Observer<Result<List<Album>>>>()
        sharedViewModel.newReleases.observeForever(observer)
        sharedViewModel.refresh()
        verify(spotifyRepository).getNewReleases()
        verifyNoMoreInteractions(spotifyRepository)
        return@runBlocking
    }

    @Test
    fun getArtist() = runBlocking {
        val observer = mock<Observer<Result<List<Artist>>>>()
        sharedViewModel.artistsSearchResult.observeForever(observer)
        sharedViewModel.isArtistChecked = true
        sharedViewModel.search("1")
        verify(spotifyRepository).searchArtist("1")
        verifyNoMoreInteractions(spotifyRepository)
        return@runBlocking
    }

    @Test
    fun getAlbums() = runBlocking {
        val observer = mock<Observer<Result<List<Album>>>>()
        sharedViewModel.albumsSearchResult.observeForever(observer)
        sharedViewModel.isAlbumChecked = true
        sharedViewModel.search("1")
        verify(spotifyRepository).searchAlbum("1")
        return@runBlocking
    }

    @Test
    fun getTracks() = runBlocking {
        val observer = mock<Observer<Result<List<Track>>>>()
        sharedViewModel.tracksSearchResult.observeForever(observer)
        sharedViewModel.isTrackChecked = true
        sharedViewModel.search("1")
        verify(spotifyRepository).searchTrack("1")
        return@runBlocking
    }

    @Test
    fun getLyrics() = runBlocking {
        val track = mockTrack()
        val observer = mock<Observer<Result<Track>>>()
        sharedViewModel.lyrics.observeForever(observer)

        whenever(geniusRepository.getLyrics(track))
            .thenReturn(MutableLiveData(Result.success(track)))

        sharedViewModel.getLyrics(track)
        verify(geniusRepository, only()).getLyrics(track)
        verify(observer).onChanged(Result.success(track))
        verifyNoMoreInteractions(geniusRepository)
        return@runBlocking
    }


    @Test
    fun search() {
        val observer1 = mock<Observer<Result<List<Track>>>>()
        sharedViewModel.tracksSearchResult.observeForever(observer1)

        val observer2 = mock<Observer<Result<List<Album>>>>()
        sharedViewModel.albumsSearchResult.observeForever(observer2)

        val observer3 = mock<Observer<Result<List<Artist>>>>()
        sharedViewModel.artistsSearchResult.observeForever(observer3)

        sharedViewModel.isTrackChecked = true
        sharedViewModel.isAlbumChecked = true
        sharedViewModel.isArtistChecked = true

        sharedViewModel.search("key")

        val inOrder = inOrder(spotifyRepository)
        inOrder.apply {
            verify(spotifyRepository).searchArtist("key")
            verify(spotifyRepository).searchAlbum("key")
            verify(spotifyRepository).searchTrack("key")
        }
    }

    @Test
    fun refresh() {
        val observer = mock<Observer<Result<List<Album>>>>()

        whenever(spotifyRepository.getNewReleases()).thenReturn(
            MutableLiveData(Result.success(listOf(mockAlbum())))
        )

        sharedViewModel.newReleases.observeForever(observer)
        sharedViewModel.refresh()

        verify(spotifyRepository).getNewReleases()
        verify(observer).onChanged(Result.success(listOf(mockAlbum())))
    }

    @Test
    fun insertSuggestion() = runBlocking {
        sharedViewModel.insertSuggestion("text")
        delay(1000)
        verify(databaseRepository, atLeastOnce()).insertSuggestion(Suggestion("text"))
        verifyNoMoreInteractions(databaseRepository)
    }


    @Test
    fun getAllSuggestions() = runBlocking {
        val observer = mock<Observer<List<Suggestion>>>()
        val suggestions = listOf<Suggestion>()

        whenever(databaseRepository.getAllSuggestions()).thenReturn(suggestions)

        sharedViewModel.suggestions.observeForever(observer)
        sharedViewModel.getAllSuggestions()
        delay(1000)
        verify(databaseRepository).getAllSuggestions()
        verify(observer).onChanged(suggestions)
        verifyNoMoreInteractions(databaseRepository)
        return@runBlocking
    }

    @Test
    fun refreshLyrics() {

        val result1 = Result.success(mockTrack())
        val result2 = Result.success(mockTrack().copy(id = "2"))

        val lyrics = mock<MutableLiveData<Result<Track>>>()

        whenever(lyrics.value)
            .thenReturn(result1)
            .thenReturn(result2)

        sharedViewModel = SharedViewModel(spotifyRepository, geniusRepository, databaseRepository, tokenData)

        val initialValue = lyrics.value
        sharedViewModel.refreshLyrics()
        val newValue = lyrics.value
        assertNotEquals(initialValue, newValue)
        assertEquals(initialValue, result1)
        assertEquals(result2, result2)
    }
}
