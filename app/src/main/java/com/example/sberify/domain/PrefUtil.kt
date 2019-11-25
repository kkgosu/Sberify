package com.example.sberify.domain

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.example.sberify.SberifyApp

object PrefUtil {
    private const val TAG = "Pref"
    private lateinit var prefs: SharedPreferences

    private fun initializePrefs() {
        if (!PrefUtil::prefs.isInitialized) {
            if (SberifyApp.getContext() != null) {
                prefs = PreferenceManager
                        .getDefaultSharedPreferences(SberifyApp.getContext())
            }
        }
    }

    // strings
    fun getStringDefaultBlank(pref: String): String? {
        initializePrefs()
        return if (PrefUtil::prefs.isInitialized) {
            prefs.getString(pref, "")
        } else ""
    }

    fun getString(pref: String, def: String): String {
        initializePrefs()
        return if (PrefUtil::prefs.isInitialized) {
            prefs.getString(pref, def)!!
        } else ""
    }

    fun setString(pref: String, str: String): Boolean {
        initializePrefs()
        if (PrefUtil::prefs.isInitialized) {
            prefs.edit().putString(pref, str).apply()
            return true
        }
        return false
    }
}