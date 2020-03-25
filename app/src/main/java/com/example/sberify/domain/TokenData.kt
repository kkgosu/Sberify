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

    fun setToken(token: String) {
        setString("oauthtoken", token)
    }
    
    fun setCode(code: String) {
        setString("code", code)
    }

    fun getToken(): String = getString("oauthtoken", "")

    private fun getString(pref: String, def: String): String {
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
}