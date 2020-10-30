package com.example.sberify.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.example.sberify.R
import com.example.sberify.databinding.ActivityMainBinding
import com.example.sberify.ui.utils.NetworkObserver
import com.example.sberify.ui.utils.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.kvlg.network.TokenData
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LifecycleOwner {

    @Inject
    lateinit var tokenData: TokenData

    private val sharedViewModel: SharedViewModel by viewModels()
    private var currentNavController: LiveData<NavController>? = null

    private lateinit var binding: ActivityMainBinding
    private lateinit var accessToken: String
    private lateinit var accessCode: String

    private var spotifyAppRemote: SpotifyAppRemote? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.background1)

        var hasConnection = false
        val connectionLiveData = NetworkObserver(this)
        connectionLiveData.observe(this) {
            hasConnection = it
            if (it) {
                requestToken()
            } else {
                showSnackbar()
            }
        }

        sharedViewModel.play.observe(this) { track ->
            if (hasConnection) {
                spotifyAppRemote?.playerApi?.play("spotify:track:${track.id}")
                spotifyAppRemote
                    ?.playerApi
                    ?.subscribeToPlayerState()
                    ?.setEventCallback {
                        val stateTrack = it.track
                        println("Now playing ${stateTrack.name} by ${stateTrack.artist.name}. Song id: ${stateTrack.uri}")
                    }
            } else {
                showSnackbar()
            }
        }

        if (savedInstanceState == null) {
            setupBottomNavBar()
        }

        sharedViewModel.refresh()
    }

    override fun onStart() {
        super.onStart()

        SpotifyAppRemote.disconnect(spotifyAppRemote)
        lifecycleScope.launch {
            try {
                spotifyAppRemote = connectToAppRemote()
                println("Connected")
            } catch (error: Throwable) {
                println(error.message)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        SpotifyAppRemote.disconnect(spotifyAppRemote)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavBar()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val response = AuthorizationClient.getResponse(resultCode, data)

        if (AUTH_CODE_REQUEST_CODE == requestCode) {
            response.code?.let {
                accessCode = it
                println(accessCode)
                tokenData.setSpotifyCode(accessCode)
            }
        } else if (AUTH_TOKEN_REQUEST_CODE == requestCode) {
            response.accessToken?.let {
                accessToken = it
                println(accessToken)
                tokenData.setSpotifyToken(accessToken)
                sharedViewModel.refresh()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    private suspend fun connectToAppRemote(): SpotifyAppRemote? =
        suspendCoroutine { continuation: Continuation<SpotifyAppRemote> ->
            SpotifyAppRemote.connect(applicationContext,
                ConnectionParams.Builder(CLIENT_ID)
                    .setRedirectUri(REDIRECT_URL)
                    .setAuthMethod(ConnectionParams.AuthMethod.APP_ID)
                    .showAuthView(true)
                    .build(),
                object : Connector.ConnectionListener {
                    override fun onConnected(p0: SpotifyAppRemote) {
                        continuation.resume(p0)
                    }

                    override fun onFailure(p0: Throwable) {
                    }
                })
        }

    private fun onRequestCodeClicked() {
        val request = getAuthenticationRequest(AuthorizationResponse.Type.CODE)
        AuthorizationClient.openLoginActivity(this, AUTH_CODE_REQUEST_CODE, request)
    }

    private fun requestToken() {
        val request = getAuthenticationRequest(AuthorizationResponse.Type.TOKEN)
        AuthorizationClient.openLoginActivity(this, AUTH_TOKEN_REQUEST_CODE, request)
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

    private fun setupBottomNavBar() {
        val bnv = binding.bnv.bottomNavView

        val navGraphIds = listOf(
            R.navigation.new_releases,
            R.navigation.search,
            R.navigation.favorite
        )

        val controller = bnv.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.main_content,
            intent = intent
        )

        currentNavController = controller
    }

    private fun showSnackbar() {
        Snackbar.make(findViewById(R.id.bottom_nav_view), getString(R.string.internet_connection_message), Snackbar.LENGTH_SHORT)
            .setBackgroundTint(ContextCompat.getColor(this, R.color.colorAccent))
            .setAnchorView(R.id.bottom_nav_view)
            .show()
    }


    companion object {
        private const val CLIENT_ID = "49e110cda5b64d6d89476f40687725c4"
        private const val REDIRECT_URL = "spotify-sdk://auth"
        private const val AUTH_TOKEN_REQUEST_CODE = 0x10
        private const val AUTH_CODE_REQUEST_CODE = 0x11
    }
}



