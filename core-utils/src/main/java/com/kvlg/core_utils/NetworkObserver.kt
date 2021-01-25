package com.kvlg.core_utils

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import androidx.core.content.getSystemService
import androidx.lifecycle.LiveData

/**
 * Network state observer
 *
 * @author Konstantin Koval
 * @since 13.07.2020
 */
class NetworkObserver(context: Context) : LiveData<Boolean>() {

    private var connectivityManager: ConnectivityManager = context.getSystemService()!!

    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("MissingPermission")
    override fun onActive() {
        when {
            (CURRENT_VERSION >= NOUGAT) -> connectivityManager.registerDefaultNetworkCallback(
                connectivityManagerCallback()
            )
            (CURRENT_VERSION >= LOLLIPOP) -> lollipopNetworkRequest()
        }
    }

    override fun onInactive() {
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    private fun lollipopNetworkRequest() {
        val requestBuilder = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        connectivityManager.registerNetworkCallback(
            requestBuilder.build(),
            connectivityManagerCallback()
        )
    }

    private fun connectivityManagerCallback(): ConnectivityManager.NetworkCallback {
        if (CURRENT_VERSION >= LOLLIPOP) {
            networkCallback = object : ConnectivityManager.NetworkCallback() {
                override fun onLost(network: Network) {
                    super.onLost(network)
                    postValue(false)
                }

                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    postValue(true)
                }
            }
            return networkCallback
        } else throw IllegalAccessError("Error")
    }

    companion object {
        private val CURRENT_VERSION = Build.VERSION.SDK_INT
        private const val LOLLIPOP = Build.VERSION_CODES.LOLLIPOP
        private const val NOUGAT = Build.VERSION_CODES.N
    }
}