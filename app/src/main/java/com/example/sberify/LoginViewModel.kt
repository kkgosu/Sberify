package com.example.sberify

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kvlg.core_utils.SingleLiveEvent
import com.kvlg.core_utils.models.TokenData
import com.kvlg.spotify_api.api.SpotifyApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Konstantin Koval
 * @since 01.02.2021
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val tokenData: TokenData,
    private val spofityApi: SpotifyApi
) : ViewModel() {

    private val _refresh = SingleLiveEvent<Unit>()
    val refreshLiveData: LiveData<Unit> = _refresh

    fun onTokenReceived(token: String) {
        Timber.d("onTokenReceived: $token")
        tokenData.setSpotifyToken(token)
        tokenData.setGeniusToken("rBpO2QDlufzcQpxStgKY9lF1qtxUfVvJx3Hpv4rck6myBpA8TdPPDenhKJCKZF_S")
    }

    fun requestToken() {
        viewModelScope.launch {
            val token = spofityApi.interactor().getToken()
            onTokenReceived(token)
            _refresh.call()
        }
    }
}