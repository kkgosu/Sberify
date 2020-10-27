package com.example.sberify.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.presentation.ui.utils.SingleLiveEvent
import com.kvlg.model.common.Result
import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Artist
import com.kvlg.model.presentation.Suggestion
import com.kvlg.model.presentation.Track
import com.kvlg.network.TokenData
import com.kvlg.shared.domain.lyrics.SaveTrackIntoDbUseCase
import com.kvlg.shared.domain.resultData
import com.kvlg.shared.domain.track.GetTrackFromDbUseCase
import com.kvlg.shared.domain.track.GetTracksFromSpotifyUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SharedViewModel @ViewModelInject constructor(
    private val spotifyRepository: ISpotifyRepository,
    private val databaseRepository: IDatabaseRepository,
    tokenData: TokenData,
    getTrackFromDbUseCase: GetTrackFromDbUseCase,
    getTracksFromSpotifyUseCase: GetTracksFromSpotifyUseCase,
    saveTrackIntoDbUseCase: SaveTrackIntoDbUseCase
) : ViewModel() {

    init {
        val token = "rBpO2QDlufzcQpxStgKY9lF1qtxUfVvJx3Hpv4rck6myBpA8TdPPDenhKJCKZF_S"
        tokenData.setGeniusToken(token)
    }

    var isAlbumChecked = false
    var isArtistChecked = false
    var isTrackChecked = false

    private val _showFiltersFragment = SingleLiveEvent<Unit>()
    val showFiltersFragment = _showFiltersFragment

    private val _refreshContentVisibility = SingleLiveEvent<Unit>()
    val refreshContentVisibility = _refreshContentVisibility

    fun checkFiltersAndSearch(keyword: String) {
        if (!isAlbumChecked && !isArtistChecked && !isTrackChecked) {
            _showFiltersFragment.call()
        } else {
            search(keyword)
        }
    }

    private val albumInfoTrigger = MutableLiveData<Album>()
    private val reloadTrigger = MutableLiveData<Boolean>()
    private val searchArtistTrigger = MutableLiveData<String>()
    private val searchAlbumTrigger = MutableLiveData<String>()
    private val searchTrackTrigger = MutableLiveData<String>()
    private val lyricsTrigger = MutableLiveData<Track>()

    private val playTrigger = MutableLiveData<Track>()
    val play: LiveData<Track> = playTrigger

    fun onPlayClick(track: Track) {
        playTrigger.value = track
    }

    fun getAlbumInfo(album: Album) {
        albumInfoTrigger.value = album
    }

    val newReleases: LiveData<Result<List<Album>>> = Transformations.switchMap(reloadTrigger) {
        spotifyRepository.getNewReleases()
    }

    val artistsSearchResult: LiveData<Result<List<Artist>>> = Transformations.switchMap(searchArtistTrigger) {
        spotifyRepository.searchArtist(it)
    }
    val albumsSearchResult: LiveData<Result<List<Album>>> = Transformations.switchMap(searchAlbumTrigger) {
        spotifyRepository.searchAlbum(it)
    }

    val tracksSearch = searchTrackTrigger.switchMap {
        resultData(
            databaseQuery = { getTrackFromDbUseCase(it) },
            networkCall = { getTracksFromSpotifyUseCase(it) },
            saveCallResult = { tracks ->
                tracks?.forEach { saveTrackIntoDbUseCase(it) }
            }
        )
    }

    val album: LiveData<Result<Album>> = Transformations.switchMap(albumInfoTrigger) {
        spotifyRepository.getAlbumInfo(it.id)
    }

    private val _suggestions = MutableLiveData<List<Suggestion>>()
    val suggestions: LiveData<List<Suggestion>> = _suggestions

    fun search(keyword: String) {
        searchArtistTrigger.applySearch(isArtistChecked, keyword)
        searchAlbumTrigger.applySearch(isAlbumChecked, keyword)
        searchTrackTrigger.applySearch(isTrackChecked, keyword)
        refreshContentVisibility()
    }

    fun refreshContentVisibility() {
        refreshContentVisibility.call()
    }

    fun refresh() {
        reloadTrigger.value = true
    }

    fun getLyrics(track: Track) {
        lyricsTrigger.value = track
    }

    fun updateFavoriteAlbum(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(800)
            databaseRepository.updateAlbum(album)
        }
    }

    private fun MutableLiveData<String>.applySearch(isChecked: Boolean, keyword: String) =
        takeIf { isChecked }?.apply { value = keyword }
}
