package com.example.sberify.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.data.Result
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.models.domain.*
import com.example.sberify.presentation.ui.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel @Inject constructor(private val spotifyRepository: ISpotifyRepository,
        private val geniusRepository: IGeniusRepository,
        private val databaseRepository: IDatabaseRepository) : ViewModel() {

    val token: LiveData<Token> = spotifyRepository.getToken()
    val newReleases = spotifyRepository.getNewReleases()

    fun getAlbumInfo(album: Album) {
        this.album = spotifyRepository.getAlbumInfo(album.id)
    }

    var album: LiveData<Result<Album>> = MutableLiveData<Result<Album>>()
    var artist: LiveData<Result<List<Artist>>> = MutableLiveData<Result<List<Artist>>>()
    var albums: LiveData<Result<List<Album>>> = MutableLiveData<Result<List<Album>>>()
    var track: LiveData<Result<List<Track>>> = MutableLiveData<Result<List<Track>>>()

    private val _lyrics = MutableLiveData<Track>()
    val lyrics: LiveData<Track> = _lyrics

    private val _suggestions = MutableLiveData<List<Suggestion>>()
    val suggestions: LiveData<List<Suggestion>> = _suggestions

    private val _cancelLoadingAnim = SingleLiveEvent<Unit>()
    val cancelLoadingAnim = _cancelLoadingAnim

    private val _startLoadingAnim = SingleLiveEvent<Unit>()
    val startLoadingAnim = _startLoadingAnim


    fun getLyrics(track: Track) {
        _lyrics.postValue(track)
        _startLoadingAnim.call()
        viewModelScope.launch(Dispatchers.IO) {
            track.lyrics = geniusRepository.getLyrics(track)
            _lyrics.postValue(track)
            _cancelLoadingAnim.call()
        }
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
