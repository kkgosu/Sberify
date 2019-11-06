package com.example.sberify.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Token
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val spotifyRepository: ISpotifyRepository) : ViewModel() {
    private val _token = MutableLiveData<Token>()
    val token = _token

    private val _newReleases = MutableLiveData<List<Album>>()
    val newReleases = _newReleases

    fun getData() {
        viewModelScope.launch {
            async {
                getToken()
            }.await()
            async {
                getNewReleases(_token.value)
            }.await()
        }
    }

    private suspend fun getToken() {
        //delay(5000)
        _token.value = spotifyRepository.getToken()
    }

    private suspend fun getNewReleases(token: Token?) {
        println(spotifyRepository.getNewReleases("Bearer ${token?.access_token}").items!![0].artists[0].name)
    }
}