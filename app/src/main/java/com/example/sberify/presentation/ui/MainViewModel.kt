package com.example.sberify.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.model.Token
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val spotifyRepository: ISpotifyRepository) : ViewModel() {
    private val _token = MutableLiveData<Token>()
    val token = _token

    private val job = Job()
    private val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    fun getToken() {
        scope.launch {
            _token.postValue(spotifyRepository.getToken())
        }
    }
}