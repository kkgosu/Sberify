package com.kvlg.analytics

import android.app.Activity

/**
 * @author Konstantin Koval
 * @since 13.05.2021
 */
interface AnalyticsInteractor {

    fun resumeSession(activity: Activity)

    fun pauseSession(activity: Activity)

    fun onNewReleasesOpen()

    fun onSearchOpen()

    fun onFavoriteOpen()

    fun addFavoriteTrack()

    fun addFavoriteAlbum()

}