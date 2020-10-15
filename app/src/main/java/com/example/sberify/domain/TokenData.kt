package com.example.sberify.domain

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.example.sberify.SberifyApp

object TokenData {
    private lateinit var prefs: SharedPreferences

    private fun initializePrefs() {
        if (!TokenData::prefs.isInitialized && SberifyApp.getContext() != null) {
            prefs = PreferenceManager
                .getDefaultSharedPreferences(SberifyApp.getContext())
        }
    }

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

    fun getSpotifyToken(): String = getString(SPOTIFY_OAUTHTOKEN)

    fun getGeniusToken(): String = getString(GENIUS_OAUTHTOKEN)

    private fun getString(pref: String, def: String = ""): String {
        initializePrefs()
        return if (TokenData::prefs.isInitialized) {
            prefs.getString(pref, def)!!
        } else ""
    }

    private fun setString(pref: String, str: String): Boolean {
        initializePrefs()
        if (TokenData::prefs.isInitialized) {
            prefs.edit()
                .putString(pref, str)
                .apply()
            return true
        }
        return false
    }

    private const val SPOTIFY_OAUTHTOKEN = "SPOTIFY_OAUTHTOKEN"
    private const val SPOTIFY_CODE = "SPOTIFY_CODE"
    private const val GENIUS_OAUTHTOKEN = "GENIUS_OAUTHTOKEN"
    private const val GENIUS_CODE = "GENIUS_CODE"
}