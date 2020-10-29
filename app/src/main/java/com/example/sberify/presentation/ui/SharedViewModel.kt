package com.example.sberify.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.sberify.presentation.ui.utils.SingleLiveEvent
import com.kvlg.model.common.Result
import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Track
import com.kvlg.network.TokenData
import com.kvlg.shared.domain.album.AlbumUseCasesProvider
import com.kvlg.shared.domain.artist.ArtistUseCasesProvider
import com.kvlg.shared.domain.resultData
import com.kvlg.shared.domain.track.TrackUseCasesProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SharedViewModel @ViewModelInject constructor(
    tokenData: TokenData,
    private val albumUseCases: AlbumUseCasesProvider,
    trackUseCases: TrackUseCasesProvider,
    artistUseCases: ArtistUseCasesProvider
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

    val newReleases: LiveData<Result<List<Album>>> = reloadTrigger.switchMap {
        resultData(
            databaseQuery = { albumUseCases.getAllAlbums(Unit) },
            networkCall = { albumUseCases.getNewReleases(Unit) },
            saveCallResult = {
                it.forEach { album ->
                    artistUseCases.saveArtistIntoDb(album.artist)
                    albumUseCases.saveAlbumIntoDb(album)
                }
            }
        )
    }

    val artistsSearchResult = searchArtistTrigger.switchMap {
        resultData(
            databaseQuery = { artistUseCases.getArtistFromDb(it) },
            networkCall = { artistUseCases.getArtistFromSpotify(it) },
            saveCallResult = { artist -> artist.forEach { artistUseCases.saveArtistIntoDb(it) } }
        )
    }
    val albumsSearchResult: LiveData<Result<List<Album>>> = Transformations.switchMap(searchAlbumTrigger) {
        resultData(
            databaseQuery = { albumUseCases.getAlbumsFromDb(it) },
            networkCall = { albumUseCases.getAlbumsFromSpotify(it) },
            saveCallResult = { list ->
                list.forEach { albumUseCases.insertAlbum(it) }
            }
        )
    }

    val tracksSearch = searchTrackTrigger.switchMap {
        resultData(
            databaseQuery = { trackUseCases.getTracksFromDb(it) },
            networkCall = { trackUseCases.getTrackFromSpotify(it) },
            saveCallResult = { tracks ->
                tracks?.forEach { trackUseCases.saveTrackIntoDb(it) }
            }
        )
    }

    val album: LiveData<Result<Album>> = albumInfoTrigger.switchMap {
        resultData(
            databaseQuery = { albumUseCases.getAlbumByIdDb(it.id) },
            networkCall = { albumUseCases.getAlbumByIdSpotify(it.id) },
            saveCallResult = { list ->
                list.forEach { album ->
                    albumUseCases.updateAlbumTracks(album)
                }
            }
        )
    }

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
            albumUseCases.updateAlbumInDb(album)
        }
    }

    private fun MutableLiveData<String>.applySearch(isChecked: Boolean, keyword: String) =
        takeIf { isChecked }?.apply { value = keyword }
}
