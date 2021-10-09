package com.example.sberify

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.example.sberify.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.kvlg.analytics.AnalyticsInteractor
import com.kvlg.core_utils.NetworkObserver
import com.kvlg.design.fluidlayout.FluidContentResizer
import com.kvlg.shared.SharedViewModel
import com.kvlg.spotify_common.presentation.TrackModel
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.resume

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LifecycleOwner {

    @Inject
    lateinit var analyticsInteractor: AnalyticsInteractor

    private lateinit var binding: ActivityMainBinding
    private lateinit var bnvAnimator: BnvAnimator

    private val sharedViewModel: SharedViewModel by viewModels()
    private val loginViewModel: LoginViewModel by viewModels()

    private var currentNavController: LiveData<NavController>? = null
    private var spotifyAppRemote: SpotifyAppRemote? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analyticsInteractor.resumeSession(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.background1)

        FluidContentResizer.listen(this)

        if (savedInstanceState == null) {
            setupBottomNavBar()
        }

        subscribeToObservers()
    }

    private fun subscribeToObservers() {
        val connectionLiveData = NetworkObserver(this)
        connectionLiveData.observe(this) {
            if (it) {
                loginViewModel.requestToken()
            } else {
                showSnackbar()
            }
        }
        loginViewModel.refreshLiveData.observe(this) {
            sharedViewModel.refresh()
        }
        sharedViewModel.play.observe(this) { track ->
            if (connectionLiveData.value == true) {
                if (spotifyAppRemote == null) {
                    lifecycleScope.launch {
                        try {
                            spotifyAppRemote = connectToAppRemote()
                            startSpotifyPlayer(track)
                            Timber.d("Connected")
                        } catch (error: Throwable) {
                            Timber.d(error)
                        }
                    }
                } else {
                    startSpotifyPlayer(track)
                }
            } else {
                showSnackbar()
            }
        }
    }

    private fun startSpotifyPlayer(track: TrackModel) {
        spotifyAppRemote?.playerApi?.play(track.uri)
        spotifyAppRemote
            ?.playerApi
            ?.subscribeToPlayerState()
            ?.setEventCallback {
                val stateTrack = it.track
                println("Now playing ${stateTrack.name} by ${stateTrack.artist.name}. Song id: ${stateTrack.uri}")
            }
    }

    override fun onStop() {
        super.onStop()
        analyticsInteractor.pauseSession(this)
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
        suspendCancellableCoroutine { continuation ->
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
                        continuation.invokeOnCancellation {
                            Timber.d(it)
                            SpotifyAppRemote.disconnect(spotifyAppRemote)
                        }
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
                when (destination.id) {
                    R.id.newReleasesFragment -> analyticsInteractor.onNewReleasesOpen()
                    R.id.searchFragment -> analyticsInteractor.onSearchOpen()
                    R.id.favoriteFragment -> analyticsInteractor.onFavoriteOpen()
                }
            }
        }
    }

    private fun showSnackbar() {
        Snackbar.make(binding.bnv.bottomNavView, getString(R.string.internet_connection_message), Snackbar.LENGTH_SHORT)
            .setBackgroundTint(ContextCompat.getColor(this, R.color.colorAccent))
            .setAnchorView(binding.bnv.bottomNavView)
            .show()
    }

    companion object {
        private const val CLIENT_ID = "49e110cda5b64d6d89476f40687725c4"
        private const val REDIRECT_URL = "spotify-sdk://auth"
    }
}
