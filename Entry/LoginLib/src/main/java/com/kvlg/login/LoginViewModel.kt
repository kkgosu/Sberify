package com.kvlg.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kvlg.core.SingleLiveEvent
import com.kvlg.core.models.TokenData
import timber.log.Timber

/**
 * @author Konstantin Koval
 * @since 01.02.2021
 */
class LoginViewModel @ViewModelInject constructor(
    private val tokenData: TokenData
) : ViewModel() {

    private val _startMainActivityEvent = SingleLiveEvent<Boolean>()
    val startMainActivityEvent: LiveData<Boolean> = _startMainActivityEvent

    fun onTokenReceived(token: String) {
        Timber.d("onTokenReceived: $token")
        tokenData.setSpotifyToken(token)
        tokenData.setGeniusToken("rBpO2QDlufzcQpxStgKY9lF1qtxUfVvJx3Hpv4rck6myBpA8TdPPDenhKJCKZF_S")
        _startMainActivityEvent.value = true
    }
}