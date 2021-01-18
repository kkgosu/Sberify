package com.example.sberify.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.DatabaseRepository
import com.example.sberify.domain.GeniusRepository
import com.example.sberify.domain.SpotifyRepository
import com.example.sberify.domain.TokenData
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.presentation.ui.converter.ViewModelConverter
import com.example.sberify.presentation.ui.utils.SingleLiveEvent
import com.kvlg.core_utils.Result
import com.kvlg.spotify_api.models.domain.RawTrackDomainModel
import com.kvlg.spotify_api.models.presentation.AlbumModel
import com.kvlg.spotify_api.models.presentation.ArtistModel
import com.kvlg.spotify_api.models.presentation.TrackModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class SharedViewModel @ViewModelInject constructor(
    private val spotifyRepository: SpotifyRepository,
    private val geniusRepository: GeniusRepository,
    private val databaseRepository: DatabaseRepository,
    private val modelConverter: ViewModelConverter,
    private val tokenData: TokenData
) : ViewModel() {

    private val _refreshContentVisibility = SingleLiveEvent<Unit>()

    private val _showFiltersFragment = SingleLiveEvent<Unit>()
    private val albumInfoTrigger = MutableLiveData<AlbumModel>()
    private val reloadTrigger = MutableLiveData<Boolean>()
    private val searchArtistTrigger = MutableLiveData<String>()
    private val searchAlbumTrigger = MutableLiveData<String>()
    private val searchTrackTrigger = MutableLiveData<String>()
    private val lyricsTrigger = MutableLiveData<RawTrackDomainModel>()
    private val _suggestions = MutableLiveData<List<Suggestion>>()
    private val playTrigger = MutableLiveData<TrackModel>()

    init {
        val token = "rBpO2QDlufzcQpxStgKY9lF1qtxUfVvJx3Hpv4rck6myBpA8TdPPDenhKJCKZF_S"
        tokenData.setGeniusToken(token)
    }

    var isAlbumChecked = false
    var isArtistChecked = false
    var isTrackChecked = false

    val showFiltersFragment: LiveData<Unit> = _showFiltersFragment

    val refreshContentVisibility: LiveData<Unit> = _refreshContentVisibility

    val play: LiveData<TrackModel> = playTrigger

    val newReleases: LiveData<Result<List<AlbumModel>>> = Transformations.switchMap(reloadTrigger) {
        spotifyRepository.getNewReleases().map(modelConverter::convertToAlbumViewModelList)
    }
    val artistsSearchResult: LiveData<Result<List<ArtistModel>>> = Transformations.switchMap(searchArtistTrigger) {
        spotifyRepository.searchArtist(it).map(modelConverter::convertToArtistViewModelList)
    }
    val albumsSearchResult: LiveData<Result<List<AlbumModel>>> = Transformations.switchMap(searchAlbumTrigger) {
        spotifyRepository.searchAlbum(it).map(modelConverter::convertToAlbumViewModelList)
    }

    val tracksSearchResult: LiveData<Result<List<TrackModel>>> = Transformations.switchMap(searchTrackTrigger) {
        spotifyRepository.searchTrack(it).map(modelConverter::convertToTrackViewModelList)
    }

    val album: LiveData<Result<AlbumModel>> = Transformations.switchMap(albumInfoTrigger) {
        spotifyRepository.getAlbumInfo(it.id).map(modelConverter::convertToAlbumViewModel)
    }

    val lyrics: LiveData<Result<TrackModel?>> = Transformations.switchMap(lyricsTrigger) {
        runBlocking(Dispatchers.IO) {
            try {
                withContext(Dispatchers.Default) {
                    geniusRepository.getLyrics(it).map(modelConverter::convertToTrackViewModel)
                }
            } catch (e: Exception) {
                MutableLiveData()
            }
        }
    }

    val suggestions: LiveData<List<Suggestion>> = _suggestions

    fun checkFiltersAndSearch(keyword: String) {
        if (!isAlbumChecked && !isArtistChecked && !isTrackChecked) {
            _showFiltersFragment.call()
        } else {
            search(keyword)
        }
    }

    fun onPlayClick(track: TrackModel) {
        playTrigger.value = track
    }

    fun getAlbumInfo(album: AlbumModel) {
        albumInfoTrigger.value = album
    }

    fun saveSpotifyToken(token: String) {
        tokenData.setSpotifyToken(token)
    }

    fun search(keyword: String) {
        searchArtistTrigger.applySearch(isArtistChecked, keyword)
        searchAlbumTrigger.applySearch(isAlbumChecked, keyword)
        searchTrackTrigger.applySearch(isTrackChecked, keyword)
        refreshContentVisibility()
    }

    fun refreshContentVisibility() {
        _refreshContentVisibility.call()
    }

    fun refresh() {
        reloadTrigger.value = true
    }

    fun getLyrics(track: TrackModel) {
        lyricsTrigger.value = RawTrackDomainModel(
            id = track.id,
            name = track.name,
            artistNames = track.artistNames
        )
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

    fun updateFavoriteAlbum(album: AlbumModel) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(800)
            databaseRepository.setAlbumIsFavorite(album.id, !album.isFavorite)
        }
    }

    private fun MutableLiveData<String>.applySearch(isChecked: Boolean, keyword: String) =
        takeIf { isChecked }?.apply { value = keyword }
}
