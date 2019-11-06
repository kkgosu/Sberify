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

class MainViewModel(private val spotifyRepository: ISpotifyRepository) : ViewModel() {
    private val _token = MutableLiveData<Token>()
    val token = _token

    private val _newReleases = MutableLiveData<List<Album>>()
    val newReleases = _newReleases

    fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                getToken()
                getNewReleases()
                search("Kanye West")
            }
        }
    }

    private suspend fun getToken() {
        delay(5000)
        _token.postValue(spotifyRepository.getToken())
        PrefUtil.setString("oauthtoken",
                "Bearer ${_token.value!!.access_token}")
    }

    private suspend fun getNewReleases() {
        println(spotifyRepository.getNewReleases().items!![0].artists[0].name)
    }

    private suspend fun search(keyword: String) {
        println(spotifyRepository.search(keyword))
    }
}