package com.example.sberify.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.sberify.R
import com.example.sberify.databinding.ActivityMainBinding
import com.example.sberify.domain.TokenData
import com.example.sberify.presentation.ui.utils.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    private lateinit var sharedViewModel: SharedViewModel
    private var currentNavController: LiveData<NavController>? = null

    private lateinit var accessToken: String
    private lateinit var accessCode: String

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        requestToken()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main)
        binding.lifecycleOwner = this

        if (savedInstanceState == null) {
            setupBottomNavBar()
        }

        sharedViewModel = ViewModelProvider(this, viewModelFactory).get(
                SharedViewModel::class.java)
        sharedViewModel.refresh()
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
                TokenData.setCode(accessCode)
            }
        } else if (AUTH_TOKEN_REQUEST_CODE == requestCode) {
            response.accessToken?.let {
                accessToken = it
                println(accessToken)
                TokenData.setToken(accessToken)
                sharedViewModel.refresh()
            }
        }
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
        val bnv = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        val navGraphIds = listOf(R.navigation.new_releases, R.navigation.search,
                R.navigation.favorite)

        val controller = bnv.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = supportFragmentManager,
                containerId = R.id.main_content,
                intent = intent)

        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    companion object {
        private const val CLIENT_ID = "49e110cda5b64d6d89476f40687725c4"
        private const val AUTH_TOKEN_REQUEST_CODE = 0x10
        private const val AUTH_CODE_REQUEST_CODE = 0x11
    }
}



