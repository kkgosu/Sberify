package com.kvlg.shared

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.kvlg.core_db.DatabaseRepository
import com.kvlg.core_utils.Result
import com.kvlg.spotify_api.api.SpotifyApi
import com.kvlg.spotify_api.api.SpotifyInteractor
import com.kvlg.spotify_common.presentation.AlbumModel
import com.kvlg.spotify_common.presentation.ArtistModel
import com.kvlg.spotify_common.presentation.TrackModel
import com.kvlg.suggestion.Suggestion
import io.mockk.called
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * @author Konstantin Koval
 * @since 04.03.2021
 */
class SharedViewModelTest {

    @JvmField
    @Rule
    val rule = InstantTaskExecutorRule()

    @JvmField
    @Rule
    val coroutineRule = MainCoroutineRule()

    private val spotifyInteractor: SpotifyInteractor = mockk(relaxed = true)
    private val spotifyApi: SpotifyApi = mockk(relaxed = true) {
        every { interactor() } returns spotifyInteractor
    }
    private val databaseRepo: DatabaseRepository = mockk(relaxed = true)
    private val viewModel = SharedViewModel(spotifyApi, databaseRepo, coroutineRule.testDispatcher)

    private val refreshContentObserver: Observer<Unit> = mockk(relaxed = true)
    private val showFiltersFragmentObserver: Observer<Unit> = mockk(relaxed = true)
    private val searchArtistObserver: Observer<Result<List<ArtistModel>>> = mockk(relaxed = true)
    private val searchTrackObserver: Observer<Result<List<TrackModel>>> = mockk(relaxed = true)
    private val searchAlbumObserver: Observer<Result<List<AlbumModel>>> = mockk(relaxed = true)
    private val newReleasesObserver: Observer<Result<List<AlbumModel>>> = mockk(relaxed = true)
    private val playObserver: Observer<TrackModel> = mockk(relaxed = true)
    private val albumInfoObserver: Observer<Result<AlbumModel>> = mockk(relaxed = true)

    @Before
    fun setUp() {
        initObservers()
    }

    @Test
    fun checkFiltersAndSearch_filtersOff() {
        viewModel.checkFiltersAndSearch("word")

        verify { showFiltersFragmentObserver.onChanged(null) }
    }

    @Test
    fun checkFiltersAndSearch_filtersOn() {
        val albumMock: AlbumModel = mockk()
        val artistMock: ArtistModel = mockk()
        val trackMock: TrackModel = mockk()
        val expectedAlbum = Result.success(listOf(albumMock))
        val expectedArtist = Result.success(listOf(artistMock))
        val expectedTrack = Result.success(listOf(trackMock))

        every { spotifyInteractor.searchAlbum("word") } returns MutableLiveData(expectedAlbum)
        every { spotifyInteractor.searchArtist("word") } returns MutableLiveData(expectedArtist)
        every { spotifyInteractor.searchTrack("word") } returns MutableLiveData(expectedTrack)

        viewModel.isAlbumChecked = true
        viewModel.isTrackChecked = true
        viewModel.isArtistChecked = true
        viewModel.checkFiltersAndSearch("word")

        verify {
            showFiltersFragmentObserver wasNot called
            refreshContentObserver.onChanged(null)
            searchAlbumObserver.onChanged(expectedAlbum)
            searchArtistObserver.onChanged(expectedArtist)
            searchTrackObserver.onChanged(expectedTrack)
        }
    }

    @Test
    fun onPlayClick() {
        val trackMock: TrackModel = mockk()
        viewModel.onPlayClick(trackMock)

        verify { playObserver.onChanged(trackMock) }
    }

    @Test
    fun getAlbumInfo() {
        val albumMock: AlbumModel = mockk()
        val expectedAlbum = Result.success(albumMock)
        every { albumMock.id } returns "id"
        every { spotifyInteractor.getAlbumInfo("id") } returns MutableLiveData(expectedAlbum)

        viewModel.getAlbumInfo(albumMock)

        verify {
            albumInfoObserver.onChanged(expectedAlbum)
        }
    }

    @Test
    fun search() {
        val albumMock: AlbumModel = mockk()
        val artistMock: ArtistModel = mockk()
        val trackMock: TrackModel = mockk()
        val expectedAlbum = Result.success(listOf(albumMock))
        val expectedArtist = Result.success(listOf(artistMock))
        val expectedTrack = Result.success(listOf(trackMock))

        every { spotifyInteractor.searchAlbum("word") } returns MutableLiveData(expectedAlbum)
        every { spotifyInteractor.searchArtist("word") } returns MutableLiveData(expectedArtist)
        every { spotifyInteractor.searchTrack("word") } returns MutableLiveData(expectedTrack)

        viewModel.isAlbumChecked = true
        viewModel.isTrackChecked = true
        viewModel.isArtistChecked = true
        viewModel.search("word")

        verify {
            showFiltersFragmentObserver wasNot called
            refreshContentObserver.onChanged(null)
            searchAlbumObserver.onChanged(expectedAlbum)
            searchArtistObserver.onChanged(expectedArtist)
            searchTrackObserver.onChanged(expectedTrack)
        }
    }

    @Test
    fun refreshContentVisibility() {
        viewModel.refreshContentVisibility()

        verify { refreshContentObserver.onChanged(null) }
    }

    @Test
    fun refresh() {
        val albumMock: AlbumModel = mockk()
        val expectedAlbum = Result.success(listOf(albumMock))
        every { spotifyInteractor.getNewReleases() } returns MutableLiveData(expectedAlbum)

        viewModel.refresh()

        verify {
            spotifyInteractor.getNewReleases()
            newReleasesObserver.onChanged(expectedAlbum)
        }
    }

    @Test
    fun insertSuggestion() {
        coroutineRule.runBlockingTest {
            viewModel.insertSuggestion("text")
        }
        coVerify {
            databaseRepo.insertSuggestion(Suggestion("text"))
        }
    }

    @Test
    fun updateFavoriteAlbum() {
        val albumModel = AlbumModel(
            id = "albumId1",
            artistNames = "ArtistName1 ,ArtistName2",
            name = "Name",
            releaseDate = "01.01.1970",
            isFavorite = true,
            imageUrl = "imageUrl",
            totalTracks = 11,
            copyright = "",
            externalUrl = "externalUrl",
            tracks = emptyList()
        )

        coroutineRule.runBlockingTest {
            viewModel.updateFavoriteAlbum(albumModel)
        }
        coVerify {
            databaseRepo.setAlbumIsFavorite("albumId1", false)
        }
    }

    private fun initObservers() {
        viewModel.refreshContentVisibility.observeForever(refreshContentObserver)
        viewModel.showFiltersFragment.observeForever(showFiltersFragmentObserver)
        viewModel.albumsSearchResult.observeForever(searchAlbumObserver)
        viewModel.tracksSearchResult.observeForever(searchTrackObserver)
        viewModel.artistsSearchResult.observeForever(searchArtistObserver)
        viewModel.newReleases.observeForever(newReleasesObserver)
        viewModel.play.observeForever(playObserver)
        viewModel.album.observeForever(albumInfoObserver)
    }
}
