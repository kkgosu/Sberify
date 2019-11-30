package com.example.sberify.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.TokenData
import com.example.sberify.domain.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SharedViewModel(private val spotifyRepository: ISpotifyRepository,
        private val geniusRepository: IGeniusRepository,
        private val databaseRepository: IDatabaseRepository) : ViewModel() {

    private val _token = MutableLiveData<Token>()
    val token: LiveData<Token> = _token

    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album> = _album

    private val _newReleases = MutableLiveData<List<Album>>()
    val newReleases: LiveData<List<Album>> = _newReleases

    private val _lyrics = MutableLiveData<Track>()
    val lyrics: LiveData<Track> = _lyrics

    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums

    private val _artists = MutableLiveData<List<Artist>>()
    val artist: LiveData<List<Artist>> = _artists

    private val _tracks = MutableLiveData<List<Track>>()
    val track: LiveData<List<Track>> = _tracks

    private val _suggestions = MutableLiveData<List<Suggestion>>()
    val suggestions: LiveData<List<Suggestion>> = _suggestions

    fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getToken()
                loadReleases()
            }
        }
    }

    private suspend fun loadReleases() {
        val albums = spotifyRepository.getNewReleases()
        _newReleases.postValue(albums)
    }

    private suspend fun getToken() {
        spotifyRepository.getToken {
            _token.postValue(it)
            TokenData.setToken(it)
        }
    }

    fun getAlbumInfo(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            _album.postValue(album)
            val albums = spotifyRepository.getAlbumInfo(album.id)
            if (albums.isNotEmpty()) {
                _album.postValue(albums[0])
            }
        }
    }

    fun getLyrics(track: Track) {
        viewModelScope.launch(Dispatchers.IO) {
            _lyrics.postValue(track)
            track.lyrics = geniusRepository.getLyrics(track)
            _lyrics.postValue(track)
        }
    }

    fun searchArtist(keyword: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val artist = spotifyRepository.searchArtist(keyword)
            println(artist)
            _artists.postValue(artist)
        }
    }

    fun searchAlbum(keyword: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val album = spotifyRepository.searchAlbum(keyword)
            println(album)
            _albums.postValue(album)
        }
    }

    fun searchTrack(keyword: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val track = spotifyRepository.searchTrack(keyword)
            println(track)
            _tracks.postValue(track)
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
}

