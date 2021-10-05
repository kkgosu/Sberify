package com.example.sberify

import androidx.lifecycle.ViewModel
import com.kvlg.core_utils.models.TokenData
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Konstantin Koval
 * @since 01.02.2021
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val tokenData: TokenData
) : ViewModel() {

    fun onTokenReceived(token: String) {
        Timber.d("onTokenReceived: $token")
        tokenData.setSpotifyToken(token)
        tokenData.setGeniusToken("rBpO2QDlufzcQpxStgKY9lF1qtxUfVvJx3Hpv4rck6myBpA8TdPPDenhKJCKZF_S")
    }
}