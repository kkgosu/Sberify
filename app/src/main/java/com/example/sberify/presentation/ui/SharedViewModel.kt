package com.example.sberify.presentation.ui

import androidx.lifecycle.*
import com.example.sberify.data.Result
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Artist
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.search.SearchType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel @Inject constructor(
    private val spotifyRepository: ISpotifyRepository,
    private val geniusRepository: IGeniusRepository,
    private val databaseRepository: IDatabaseRepository
) : ViewModel() {

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

    val artists: LiveData<Result<List<Artist>>> = Transformations.switchMap(searchArtistTrigger) {
        spotifyRepository.searchArtist(it)
    }
    val albums: LiveData<Result<List<Album>>> = Transformations.switchMap(searchAlbumTrigger) {
        spotifyRepository.searchAlbum(it)
    }
    val tracks: LiveData<Result<List<Track>>> = Transformations.switchMap(searchTrackTrigger) {
        spotifyRepository.searchTrack(it)
    }

    val album: LiveData<Result<Album>> = Transformations.switchMap(albumInfoTrigger) {
        spotifyRepository.getAlbumInfo(it.id)
    }

    val lyrics: LiveData<Result<Track>> = Transformations.switchMap(lyricsTrigger) {
        geniusRepository.getLyrics(it)
    }

    private val _suggestions = MutableLiveData<List<Suggestion>>()
    val suggestions: LiveData<List<Suggestion>> = _suggestions

    fun search(keyword: String, searchType: SearchType) {
        when (searchType) {
            SearchType.ARTIST -> searchArtistTrigger.value = keyword
            SearchType.ALBUM -> searchAlbumTrigger.value = keyword
            SearchType.TRACK -> searchTrackTrigger.value = keyword
        }
    }

    fun refresh() {
        reloadTrigger.value = true
    }

    fun getLyrics(track: Track) {
        lyricsTrigger.value = track
    }

    fun refreshLyrics() {
        val track = lyrics.value
        track?.let {
            lyricsTrigger.value = it.data
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

}
