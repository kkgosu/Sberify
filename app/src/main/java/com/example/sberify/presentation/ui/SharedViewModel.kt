package com.example.sberify.presentation.ui

import androidx.lifecycle.*
import com.example.sberify.data.Result
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.models.domain.*
import com.example.sberify.presentation.ui.search.SearchType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel @Inject constructor(private val spotifyRepository: ISpotifyRepository,
        private val geniusRepository: IGeniusRepository,
        private val databaseRepository: IDatabaseRepository) : ViewModel() {

    val token: LiveData<Token> = spotifyRepository.getToken()
    
    private val reloadTrigger = MutableLiveData<Boolean>()
    private val searchArtistTrigger = MutableLiveData<String>()
    private val searchAlbumTrigger = MutableLiveData<String>()
    private val searchTrackTrigger = MutableLiveData<String>()
    private val lyricsTrigger = MutableLiveData<Track>()

    fun getAlbumInfo(album: Album) {
        this.album = spotifyRepository.getAlbumInfo(album.id)
    }

    val newReleases: LiveData<Result<List<Album>>> = Transformations.switchMap(reloadTrigger) {
        spotifyRepository.getNewReleases()
    }

    val artist: LiveData<Result<List<Artist>>> = Transformations.switchMap(searchArtistTrigger) {
        spotifyRepository.searchArtist(it)
    }
    val albums: LiveData<Result<List<Album>>> = Transformations.switchMap(searchAlbumTrigger) {
        spotifyRepository.searchAlbum(it)
    }
    val tracks: LiveData<Result<List<Track>>> = Transformations.switchMap(searchTrackTrigger) {
        spotifyRepository.searchTrack(it)
    }

    private val _album = MutableLiveData<Result<Album>>()
    var album: LiveData<Result<Album>> = _album

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
        lyricsTrigger.value = lyrics.value?.data!!
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
}
