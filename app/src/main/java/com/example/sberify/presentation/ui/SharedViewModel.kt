package com.example.sberify.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.TokenData
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Token
import com.example.sberify.domain.model.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SharedViewModel(private val spotifyRepository: ISpotifyRepository,
        private val geniusRepository: IGeniusRepository) : ViewModel() {

    private val _token = MutableLiveData<Token>()
    val token: LiveData<Token> = _token

    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album> = _album

    private val _newReleases = MutableLiveData<List<Album>>()
    val newReleases: LiveData<List<Album>> = _newReleases

    private val _lyrics = MutableLiveData<String>()
    val lyrics: LiveData<String> = _lyrics

    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums

    private val _artist = MutableLiveData<List<Artist>>()
    val artist: LiveData<List<Artist>> = _artist

    private val _track = MutableLiveData<List<Track>>()
    val track: LiveData<List<Track>> = _track

    fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                getToken()
                loadReleases()
            }
        }
    }

    private suspend fun loadReleases() {
        _newReleases.postValue(spotifyRepository.getNewReleases())
    }

    private suspend fun getToken() {
        val token = spotifyRepository.getToken()
        _token.postValue(token)
        TokenData.setToken(token)
    }

    fun getAlbumInfo(album: Album) {
        viewModelScope.launch {
            _album.value = album
            val albumInfo = spotifyRepository.getAlbumInfo(album.id)
            if (albumInfo.isNotEmpty()) {
                _album.postValue(albumInfo[0])
            }
        }
    }

    fun getLyrics(track: Track) {
        viewModelScope.launch {
            _lyrics.value = ""
            _lyrics.postValue(geniusRepository.getLyrics(track))
        }
    }

    fun searchArtist(keyword: String) {
        viewModelScope.launch {
            val searchArtist = spotifyRepository.searchArtist(keyword)
            println(searchArtist)
            _artist.postValue(searchArtist)
        }
    }

    fun searchAlbum(keyword: String) {
        viewModelScope.launch {
            val searchAlbum = spotifyRepository.searchAlbum(keyword)
            println(searchAlbum)
            _albums.postValue(searchAlbum)
        }
    }

    fun searchTrack(keyword: String) {
        viewModelScope.launch {
            val searchTrack = spotifyRepository.searchTrack(keyword)
            println(searchTrack)
            _track.postValue(searchTrack)
        }
    }
}

