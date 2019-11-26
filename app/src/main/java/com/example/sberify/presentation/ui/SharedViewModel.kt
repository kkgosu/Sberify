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
        spotifyRepository.getNewReleases {
            _newReleases.postValue(it)
        }
    }

    private suspend fun getToken() {
        spotifyRepository.getToken {
            _token.postValue(it)
            TokenData.setToken(it)
        }
    }

    fun getAlbumInfo(album: Album) {
        viewModelScope.launch {
            _album.value = album
            spotifyRepository.getAlbumInfo(album.id) {
                if (it.isNotEmpty()) {
                    _album.postValue(it[0])
                }
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
            spotifyRepository.searchArtist(keyword) {
                println(it)
                _artist.postValue(it)
            }
        }
    }

    fun searchAlbum(keyword: String) {
        viewModelScope.launch {
            spotifyRepository.searchAlbum(keyword) {
                println(it)
                _albums.postValue(it)
            }
        }
    }

    fun searchTrack(keyword: String) {
        viewModelScope.launch {
            spotifyRepository.searchTrack(keyword) {
                println(it)
                _track.postValue(it)
            }
        }
    }
}

