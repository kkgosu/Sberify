package com.kvlg.network

import android.content.SharedPreferences

//TODO: make abstractions and split into api/impl libs
class TokenData(
    private val prefs: SharedPreferences
) {

    fun setSpotifyToken(token: String) {
        setString(SPOTIFY_OAUTHTOKEN, token)
    }

    fun setGeniusToken(token: String) {
        setString(GENIUS_OAUTHTOKEN, token)
    }

    fun setSpotifyCode(code: String) {
        setString(SPOTIFY_CODE, code)
    }

    fun setGeniusCode(code: String) {
        setString(GENIUS_CODE, code)
    }

    fun getSpotifyToken(): String = prefs.getString(SPOTIFY_OAUTHTOKEN, "")!!

    fun getGeniusToken(): String = prefs.getString(GENIUS_OAUTHTOKEN, "")!!

    private fun setString(pref: String, str: String) {
        prefs.edit()
            .putString(pref, str)
            .apply()
    }

    companion object {
        private const val SPOTIFY_OAUTHTOKEN = "SPOTIFY_OAUTHTOKEN"
        private const val SPOTIFY_CODE = "SPOTIFY_CODE"
        private const val GENIUS_OAUTHTOKEN = "GENIUS_OAUTHTOKEN"
        private const val GENIUS_CODE = "GENIUS_CODE"
    }
}