package com.example.sberify.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.PrefUtil
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SharedViewModel(private val spotifyRepository: ISpotifyRepository) : ViewModel() {
    private val _token = MutableLiveData<Token>()
    val token = _token

    private val _album = MutableLiveData<Album>()
    val album = _album

    private val _newReleases = MutableLiveData<List<Album>>()
    val newReleases = _newReleases

    fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                getToken()
                loadReleases()
                //search("Kanye West")
            }
        }
    }

    private suspend fun loadReleases() {
        _newReleases.postValue(spotifyRepository.getNewReleases())
    }

    private suspend fun getToken() {
        //delay(5000)
        val token = spotifyRepository.getToken()
        _token.postValue(token)
        PrefUtil.setString("oauthtoken", "Bearer ${token.access_token}")
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

    private suspend fun search(keyword: String) {
        println(spotifyRepository.search(keyword))
    }
}