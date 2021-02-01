package com.kvlg.login

import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kvlg.core_utils.NetworkObserver
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    private val resultTokenHandler = registerForActivityResult(StartActivityForResult()) { result ->
        val response = AuthorizationClient.getResponse(result.resultCode, result.data)
        response.accessToken?.let {
            loginViewModel.onTokenReceived(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        subscribeToObservers()

        val connectionLiveData = NetworkObserver(this)
        connectionLiveData.observe(this) {
            if (it) {
                requestToken()
            } else {
                TODO("Start main activity with error message")
            }
        }
    }

    private fun subscribeToObservers() {
        loginViewModel.startMainActivityEvent.observe(this, this::startMainActivity)
    }

    private fun startMainActivity(isSuccess: Boolean) {
        //Start main activity with flag [isSuccess]
    }

    private fun requestToken() {
        val request = getAuthenticationRequest(AuthorizationResponse.Type.TOKEN)
        resultTokenHandler.launch(AuthorizationClient.createLoginActivityIntent(this, request))
    }

    private fun getAuthenticationRequest(type: AuthorizationResponse.Type) =
        AuthorizationRequest.Builder(CLIENT_ID, type, getRedirectUri().toString())
            .setShowDialog(false)
            .setScopes(arrayOf("user-read-email"))
            .setCampaign("sberify-token")
            .build()

    private fun getRedirectUri() =
        Uri.Builder()
            .scheme(getString(R.string.com_spotify_sdk_redirect_scheme))
            .authority(getString(R.string.com_spotify_sdk_redirect_host))
            .build()

    companion object {
        private const val CLIENT_ID = "49e110cda5b64d6d89476f40687725c4"
    }
}