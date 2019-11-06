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

    fun registerListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        initializePrefs()
        prefs.registerOnSharedPreferenceChangeListener(listener)
    }

    fun unregisterListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        initializePrefs()
        prefs.unregisterOnSharedPreferenceChangeListener(listener)
    }

    fun getInstance(): SharedPreferences {
        initializePrefs()
        return prefs
    }

    fun putSetString(key: String, pref: HashSet<String>): Boolean {
        initializePrefs()
        if (PrefUtil::prefs.isInitialized) {
            prefs.edit().putStringSet(key, pref).apply()
            return true
        }
        return false
    }

    fun getSetString(key: String): MutableSet<String>? {
        initializePrefs()
        return prefs.getStringSet(key, emptySet())
    }

    fun getBooleanDefaultFalse(pref: String): Boolean {
        initializePrefs()
        return PrefUtil::prefs.isInitialized && prefs.getBoolean(pref, false)
    }

    fun getBoolean(pref: String, def: Boolean): Boolean {
        initializePrefs()
        return prefs.getBoolean(pref, def)
    }

    fun setBoolean(pref: String, lng: Boolean): Boolean {
        initializePrefs()
        if (PrefUtil::prefs.isInitialized) {
            prefs.edit().putBoolean(pref, lng).apply()
            return true
        }
        return false
    }

    fun toggleBoolean(pref: String) {
        initializePrefs()
        if (PrefUtil::prefs.isInitialized) prefs.edit().putBoolean(pref,
                !prefs.getBoolean(pref, false)).apply()
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


    // numbers
    fun getLong(pref: String, def: Long): Long {
        initializePrefs()
        return if (PrefUtil::prefs.isInitialized) {
            prefs.getLong(pref, def)
        } else def
    }

    fun setLong(pref: String, lng: Long): Boolean {
        initializePrefs()
        if (PrefUtil::prefs.isInitialized) {
            prefs.edit().putLong(pref, lng).apply()
            return true
        }
        return false
    }

    fun getInt(pref: String, def: Int): Int {
        initializePrefs()
        return if (PrefUtil::prefs.isInitialized) {
            prefs.getInt(pref, def)
        } else def
    }

    fun getStringToInt(pref: String, defaultValue: Int): Int {
        return try {
            Integer.parseInt(getString(pref, defaultValue.toString()))
        } catch (e: Exception) {
            defaultValue
        }
    }

    fun setInt(pref: String, num: Int): Boolean {
        initializePrefs()
        if (PrefUtil::prefs.isInitialized) {
            prefs.edit().putInt(pref, num).apply()
            return true
        }
        return false
    }


    // misc
    fun removeItem(pref: String): Boolean {
        initializePrefs()
        if (PrefUtil::prefs.isInitialized) {
            prefs.edit().remove(pref).apply()
            return true
        }
        return false
    }
}