package com.example.sberify

import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.example.sberify.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.kvlg.core_utils.NetworkObserver
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bnvAnimator: BnvAnimator

    private val sharedViewModel: com.kvlg.shared.SharedViewModel by viewModels()
    private val loginViewModel: LoginViewModel by viewModels()

    private var currentNavController: LiveData<NavController>? = null
    private var spotifyAppRemote: SpotifyAppRemote? = null

    private val resultTokenHandler = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val response = AuthorizationClient.getResponse(result.resultCode, result.data)
        response.accessToken?.let {
            loginViewModel.onTokenReceived(it)
            sharedViewModel.refresh()
        }
    }

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
    }

    override fun onStart() {
        super.onStart()

        SpotifyAppRemote.disconnect(spotifyAppRemote)
        lifecycleScope.launch {
            try {
                spotifyAppRemote = connectToAppRemote()
                Timber.d("Connected")
            } catch (error: Throwable) {
                Timber.d(error)
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

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    private suspend fun connectToAppRemote(): SpotifyAppRemote =
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

    private fun setupBottomNavBar() {
        bnvAnimator = BnvAnimator(binding.bnv.bottomNavView)
        val bnv = binding.bnv.bottomNavView

        val navGraphIds = listOf(
            R.navigation.new_releases,
            R.navigation.search,
            R.navigation.favorite,
        )

        val controller = bnv.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.main_content,
            intent = intent
        )

        currentNavController = controller
        controller.observe(this) {
            it.addOnDestinationChangedListener { _, destination, _ ->
                bnvAnimator.animateBar(destination.id)
            }
        }
    }

    private fun showSnackbar() {
        Snackbar.make(binding.bnv.bottomNavView, getString(R.string.internet_connection_message), Snackbar.LENGTH_SHORT)
            .setBackgroundTint(ContextCompat.getColor(this, R.color.colorAccent))
            .setAnchorView(binding.bnv.bottomNavView)
            .show()
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
        private const val REDIRECT_URL = "spotify-sdk://auth"
    }
}



