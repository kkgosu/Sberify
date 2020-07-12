package com.example.sberify.presentation.ui.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities.*
import android.net.NetworkInfo
import android.net.NetworkRequest
import android.os.Build
import androidx.core.content.getSystemService
import androidx.lifecycle.LiveData

/**
 * @author Konstantin Koval
 * @since 12.07.2020
 */
class ConnectionLiveData(private val context: Context) : LiveData<Boolean>() {

    private var connectivityManager = context.getSystemService<ConnectivityManager>()!!
    private var networkCallback: NetworkCallback

    init {
        networkCallback = NetworkCallback(this)
    }

    override fun onActive() {
        super.onActive()
        updateConnection()
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> connectivityManager.registerDefaultNetworkCallback(
                networkCallback
            )
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
                val builder = NetworkRequest.Builder()
                    .addCapability(NET_CAPABILITY_INTERNET)
                    .addTransportType(TRANSPORT_CELLULAR)
                    .addTransportType(TRANSPORT_WIFI)
                    .addTransportType(TRANSPORT_ETHERNET)
                    .addTransportType(TRANSPORT_VPN)
                connectivityManager.registerNetworkCallback(builder.build(), networkCallback)
            }
        }
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    private fun updateConnection() {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        postValue(activeNetwork?.isConnectedOrConnecting == true)
    }

    class NetworkCallback(private val liveData: ConnectionLiveData) :
        ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network?) {
            liveData.postValue(true)
        }

        override fun onLost(network: Network?) {
            liveData.postValue(false)
        }
    }

    companion object {
        private const val TAG = "ConnectionLiveData"
    }
}