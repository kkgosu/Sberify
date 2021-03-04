package com.example.sberify

import com.kvlg.core_utils.models.TokenData
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

/**
 * @author Konstantin Koval
 * @since 04.03.2021
 */
class LoginViewModelTest {

    private val tokenData: TokenData = mockk(relaxed = true)

    private val viewModel = LoginViewModel(tokenData)

    @Test
    fun onTokenReceived() {
        viewModel.onTokenReceived("token")

        verify {
            tokenData.setSpotifyToken("token")
            tokenData.setGeniusToken("rBpO2QDlufzcQpxStgKY9lF1qtxUfVvJx3Hpv4rck6myBpA8TdPPDenhKJCKZF_S")
        }
    }
}