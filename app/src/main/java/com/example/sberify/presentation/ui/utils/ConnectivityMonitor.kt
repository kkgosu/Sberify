package com.example.sberify.presentation.ui.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log
import androidx.core.content.getSystemService
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author Konstantin Koval
 * @since 12.07.2020
 */
class ConnectivityMonitor(
    context: Context,
    lifecycleOwner: LifecycleOwner,
    private val callback: (Boolean) -> Unit
) : LifecycleObserver {

    private var connectivityManager = context.getSystemService<ConnectivityManager>()!!

    private val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_VPN)
        .build()

    init {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onResume() {
        toggleConnectionState(connectivityManager.isDefaultNetworkActive)
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onPause() {
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    private fun toggleConnectionState(isConnected: Boolean) = callback.invoke(isConnected)

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            super.onCapabilitiesChanged(network, networkCapabilities)
            lastInternetConnectionCheck()
        }

        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            lastInternetConnectionCheck()
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            lastInternetConnectionCheck()
        }

        private fun lastInternetConnectionCheck() =
            connectivityManager.allNetworks.forEach { network ->
                network?.let {
                    connectivityManager.getNetworkCapabilities(it)
                        ?.let { networkCapabilities ->
                            val netInternet =
                                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                            val transportCellular =
                                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                            val transportWifi =
                                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                            val transportEthernet =
                                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                            val transportVpn =
                                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)

                            val isConnected = netInternet ||
                                    transportWifi || transportCellular ||
                                    transportEthernet || transportVpn

                            Log.d(
                                TAG,
                                "Connections State $isConnected netInternet: $netInternet, WiFi: $transportWifi, " +
                                        "Cellular: $transportCellular, Ethernet: $transportEthernet, VPN: $transportVpn"
                            )
                            toggleConnectionState(isConnected)
                        }
                }
            }

    }

    companion object {
        private const val TAG = "ConnectivityMonitor"
    }
}