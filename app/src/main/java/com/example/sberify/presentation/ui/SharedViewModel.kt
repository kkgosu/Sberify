package com.example.sberify.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kvlg.core_db.DatabaseRepository
import com.kvlg.core_utils.Result
import com.kvlg.core_utils.SingleLiveEvent
import com.kvlg.core_utils.models.RawTrackModel
import com.kvlg.core_utils.models.Suggestion
import com.kvlg.core_utils.models.TokenData
import com.kvlg.genius_api.GeniusApi
import com.kvlg.spotify_api.api.SpotifyApi
import com.kvlg.spotify_models.presentation.AlbumModel
import com.kvlg.spotify_models.presentation.ArtistModel
import com.kvlg.spotify_models.presentation.TrackModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class SharedViewModel @ViewModelInject constructor(
    private val spofityApi: SpotifyApi,
    private val geniusApi: GeniusApi,
    private val databaseRepository: DatabaseRepository,
    private val tokenData: TokenData
) : ViewModel() {

    private val _refreshContentVisibility = SingleLiveEvent<Unit>()

    private val _showFiltersFragment = SingleLiveEvent<Unit>()
    private val albumInfoTrigger = MutableLiveData<AlbumModel>()
    private val reloadTrigger = MutableLiveData<Boolean>()
    private val searchArtistTrigger = MutableLiveData<String>()
    private val searchAlbumTrigger = MutableLiveData<String>()
    private val searchTrackTrigger = MutableLiveData<String>()
    private val lyricsTrigger = MutableLiveData<RawTrackModel>()
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
        spofityApi.getNewReleases()
    }
    val artistsSearchResult: LiveData<Result<List<ArtistModel>>> = Transformations.switchMap(searchArtistTrigger) {
        spofityApi.searchArtist(it)
    }
    val albumsSearchResult: LiveData<Result<List<AlbumModel>>> = Transformations.switchMap(searchAlbumTrigger) {
        spofityApi.searchAlbum(it)
    }

    val tracksSearchResult: LiveData<Result<List<TrackModel>>> = Transformations.switchMap(searchTrackTrigger) {
        spofityApi.searchTrack(it)
    }

    val album: LiveData<Result<AlbumModel>> = Transformations.switchMap(albumInfoTrigger) {
        spofityApi.getAlbumInfo(it.id)
    }

    val lyrics: LiveData<Result<TrackModel?>> = Transformations.switchMap(lyricsTrigger) {
        runBlocking(Dispatchers.IO) {
            try {
                withContext(Dispatchers.Default) {
                    geniusApi.interactor().getLyrics(it)
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
        lyricsTrigger.value = RawTrackModel(
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
