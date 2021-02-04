package com.kvlg.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.kvlg.core.models.TokenData
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

/**
 * @author Konstantin Koval
 * @since 01.02.2021
 */
class LoginViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val tokenData: TokenData = mockk(relaxed = true)
    private val startMainActivityObserver: Observer<Boolean> = mockk(relaxed = true)

    private val viewModel = LoginViewModel(tokenData)

    @Test
    fun onTokenReceived() {
        viewModel.startMainActivityEvent.observeForever(startMainActivityObserver)
        viewModel.onTokenReceived("123")

        verify {
            tokenData.setSpotifyToken("123")
            tokenData.setGeniusToken("rBpO2QDlufzcQpxStgKY9lF1qtxUfVvJx3Hpv4rck6myBpA8TdPPDenhKJCKZF_S")
            startMainActivityObserver.onChanged(true)
        }
    }
}