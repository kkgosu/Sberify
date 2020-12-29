package com.example.sberify.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.data.Result
import com.example.sberify.domain.DatabaseRepository
import com.example.sberify.domain.GeniusRepository
import com.example.sberify.domain.SpotifyRepository
import com.example.sberify.domain.TokenData
import com.example.sberify.models.domain.AlbumDomainModel
import com.example.sberify.models.domain.ArtistDomainModel
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.TrackDomainModel
import com.example.sberify.presentation.ui.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class SharedViewModel @ViewModelInject constructor(
    private val spotifyRepository: SpotifyRepository,
    private val geniusRepository: GeniusRepository,
    private val databaseRepository: DatabaseRepository,
    tokenData: TokenData
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

    private val albumInfoTrigger = MutableLiveData<AlbumDomainModel>()
    private val reloadTrigger = MutableLiveData<Boolean>()
    private val searchArtistTrigger = MutableLiveData<String>()
    private val searchAlbumTrigger = MutableLiveData<String>()
    private val searchTrackTrigger = MutableLiveData<String>()
    private val lyricsTrigger = MutableLiveData<TrackDomainModel>()

    private val playTrigger = MutableLiveData<TrackDomainModel>()
    val play: LiveData<TrackDomainModel> = playTrigger

    fun onPlayClick(track: TrackDomainModel) {
        playTrigger.value = track
    }

    fun getAlbumInfo(album: AlbumDomainModel) {
        albumInfoTrigger.value = album
    }

    val newReleases: LiveData<Result<List<AlbumDomainModel>>> = Transformations.switchMap(reloadTrigger) {
        spotifyRepository.getNewReleases()
    }

    val artistsSearchResult: LiveData<Result<List<ArtistDomainModel>>> = Transformations.switchMap(searchArtistTrigger) {
        spotifyRepository.searchArtist(it)
    }
    val albumsSearchResult: LiveData<Result<List<AlbumDomainModel>>> = Transformations.switchMap(searchAlbumTrigger) {
        spotifyRepository.searchAlbum(it)
    }
    val tracksSearchResult: LiveData<Result<List<TrackDomainModel>>> = Transformations.switchMap(searchTrackTrigger) {
        spotifyRepository.searchTrack(it)
    }

    val album: LiveData<Result<AlbumDomainModel>> = Transformations.switchMap(albumInfoTrigger) {
        spotifyRepository.getAlbumInfo(it.id)
    }

    val lyrics: LiveData<Result<TrackDomainModel?>> = Transformations.switchMap(lyricsTrigger) {
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

    fun getLyrics(track: TrackDomainModel) {
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

    fun updateFavoriteAlbum(album: AlbumDomainModel) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(800)
            databaseRepository.setAlbumIsFavorite(album.id, !album.isFavorite)
        }
    }

    private fun MutableLiveData<String>.applySearch(isChecked: Boolean, keyword: String) =
        takeIf { isChecked }?.apply { value = keyword }
}
