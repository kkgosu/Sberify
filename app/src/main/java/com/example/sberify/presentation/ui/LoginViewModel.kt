package com.example.sberify.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.kvlg.core_utils.models.TokenData
import timber.log.Timber

/**
 * @author Konstantin Koval
 * @since 01.02.2021
 */
class LoginViewModel @ViewModelInject constructor(
    private val tokenData: TokenData
) : ViewModel() {

    fun onTokenReceived(token: String) {
        Timber.d("onTokenReceived: $token")
        tokenData.setSpotifyToken(token)
        tokenData.setGeniusToken("rBpO2QDlufzcQpxStgKY9lF1qtxUfVvJx3Hpv4rck6myBpA8TdPPDenhKJCKZF_S")
    }
}