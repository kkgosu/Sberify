package com.example.sberify.presentation.ui

import androidx.lifecycle.*
import com.example.sberify.data.Result
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.TokenData
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Artist
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.utils.SingleLiveEvent
import kotlinx.coroutines.*
import javax.inject.Inject

class SharedViewModel @Inject constructor(
    private val spotifyRepository: ISpotifyRepository,
    private val geniusRepository: IGeniusRepository,
    private val databaseRepository: IDatabaseRepository
) : ViewModel() {

    init {
        val token = "rBpO2QDlufzcQpxStgKY9lF1qtxUfVvJx3Hpv4rck6myBpA8TdPPDenhKJCKZF_S"
        TokenData.setGeniusToken(token)
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
    val tracksSearchResult: LiveData<Result<List<Track>>> = Transformations.switchMap(searchTrackTrigger) {
        spotifyRepository.searchTrack(it)
    }

    val album: LiveData<Result<Album>> = Transformations.switchMap(albumInfoTrigger) {
        spotifyRepository.getAlbumInfo(it.id)
    }

    val lyrics: LiveData<Result<Track>> = Transformations.switchMap(lyricsTrigger) {
        runBlocking(Dispatchers.IO) {
            try {
                withContext(Dispatchers.Default) { geniusRepository.getLyrics(it) }
            } catch (e: Exception) {
                MutableLiveData()
            }
        }
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

    fun refreshLyrics() {
        val track = lyrics.value
        track?.data.let {
            lyricsTrigger.value = it
        }
    }

    fun insertSuggestion(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            databaseRepository.insertSuggestion(Suggestion(text))
        }
    }

    fun getAllSuggestions() {
        viewModelScope.launch(Dispatchers.IO) {
            _suggestions.postValue(databaseRepository.getAllSuggestions())
        }
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
