package com.kvlg.shared

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kvlg.core_db.DatabaseRepository
import com.kvlg.core_utils.Result
import com.kvlg.core_utils.SingleLiveEvent
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.spotify_api.api.SpotifyApi
import com.kvlg.spotify_common.presentation.AlbumModel
import com.kvlg.spotify_common.presentation.ArtistModel
import com.kvlg.spotify_common.presentation.TrackModel
import com.kvlg.suggestion.Suggestion
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SharedViewModel @ViewModelInject constructor(
    private val spofityApi: SpotifyApi,
    private val databaseRepository: DatabaseRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _refreshContentVisibility = SingleLiveEvent<Unit>()
    private val _showFiltersFragment = SingleLiveEvent<Unit>()
    private val albumInfoTrigger = MutableLiveData<AlbumModel>()
    private val reloadTrigger = MutableLiveData<Boolean>()
    private val searchArtistTrigger = MutableLiveData<String>()
    private val searchAlbumTrigger = MutableLiveData<String>()
    private val searchTrackTrigger = MutableLiveData<String>()
    private val playTrigger = MutableLiveData<TrackModel>()

    var isAlbumChecked = false
    var isArtistChecked = false
    var isTrackChecked = false

    val showFiltersFragment: LiveData<Unit> = _showFiltersFragment

    val refreshContentVisibility: LiveData<Unit> = _refreshContentVisibility

    val play: LiveData<TrackModel> = playTrigger

    val newReleases: LiveData<Result<List<AlbumModel>>> = Transformations.switchMap(reloadTrigger) {
        spofityApi.interactor().getNewReleases()
    }
    val artistsSearchResult: LiveData<Result<List<ArtistModel>>> = Transformations.switchMap(searchArtistTrigger) {
        spofityApi.interactor().searchArtist(it)
    }
    val albumsSearchResult: LiveData<Result<List<AlbumModel>>> = Transformations.switchMap(searchAlbumTrigger) {
        spofityApi.interactor().searchAlbum(it)
    }

    val tracksSearchResult: LiveData<Result<List<TrackModel>>> = Transformations.switchMap(searchTrackTrigger) {
        spofityApi.interactor().searchTrack(it)
    }

    val album: LiveData<Result<AlbumModel>> = Transformations.switchMap(albumInfoTrigger) {
        spofityApi.interactor().getAlbumInfo(it.id)
    }

    val suggestions: LiveData<List<Suggestion>> = databaseRepository.getAllSuggestions()

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

    fun insertSuggestion(text: String) {
        viewModelScope.launch(ioDispatcher) {
            databaseRepository.insertSuggestion(Suggestion(text))
        }
    }

    fun updateFavoriteAlbum(album: AlbumModel) {
        viewModelScope.launch(ioDispatcher) {
            delay(800)
            databaseRepository.setAlbumIsFavorite(album.id, !album.isFavorite)
        }
    }

    private fun MutableLiveData<String>.applySearch(isChecked: Boolean, keyword: String) =
        takeIf { isChecked }?.apply { value = keyword }
}
