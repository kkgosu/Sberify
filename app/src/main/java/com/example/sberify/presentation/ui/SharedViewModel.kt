package com.example.sberify.presentation.ui

import androidx.lifecycle.*
import com.example.sberify.data.Result
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.models.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel @Inject constructor(private val spotifyRepository: ISpotifyRepository,
        private val geniusRepository: IGeniusRepository,
        private val databaseRepository: IDatabaseRepository) : ViewModel() {

    val token: LiveData<Token> = spotifyRepository.getToken()

    private val reloadTrigger = MutableLiveData<Boolean>()

    fun refresh() {
        reloadTrigger.value = true
    }

    fun getAlbumInfo(album: Album) {
        this.album = spotifyRepository.getAlbumInfo(album.id)
    }

    var newReleases: LiveData<Result<List<Album>>> = Transformations.switchMap(reloadTrigger) {
        spotifyRepository.getNewReleases()
    }
    private val _album = MutableLiveData<Result<Album>>()
    var album: LiveData<Result<Album>> = _album
    var artist: LiveData<Result<List<Artist>>> = MutableLiveData<Result<List<Artist>>>()
    var albums: LiveData<Result<List<Album>>> = MutableLiveData<Result<List<Album>>>()
    var track: LiveData<Result<List<Track>>> = MutableLiveData<Result<List<Track>>>()
    var lyrics: LiveData<Result<Track>> = MutableLiveData<Result<Track>>()

    private val _suggestions = MutableLiveData<List<Suggestion>>()
    val suggestions: LiveData<List<Suggestion>> = _suggestions

    fun getLyrics(track: Track) {
        lyrics = geniusRepository.getLyrics(track)
    }

    fun searchArtist(keyword: String) {
        artist = spotifyRepository.searchArtist(keyword)
    }

    fun searchAlbum(keyword: String) {
        albums = spotifyRepository.searchAlbum(keyword)
    }

    fun searchTrack(keyword: String) {
        track = spotifyRepository.searchTrack(keyword)
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
