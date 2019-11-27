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
            _lyrics.value = ""
            _lyrics.postValue(geniusRepository.getLyrics(track))
        }
    }

    fun searchArtist(keyword: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val artist = spotifyRepository.searchArtist(keyword)
            println(artist)
            _artist.postValue(artist)
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
            _track.postValue(track)
        }
    }
}

