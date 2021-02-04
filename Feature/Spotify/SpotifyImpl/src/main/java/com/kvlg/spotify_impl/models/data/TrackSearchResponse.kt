package com.kvlg.spotify_impl.models.data

import com.google.gson.annotations.SerializedName

/**
 * @author Konstantin Koval
 * @since 11.01.2021
 */
data class TrackSearchResponse(
    @SerializedName("tracks")
    val tracks: TracksResponse
)
