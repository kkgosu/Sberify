package com.example.sberify.models.data.spotify

import com.google.gson.annotations.SerializedName

/**
 * @author Konstantin Koval
 * @since 11.01.2021
 */
data class TrackSearchResponse(
    @SerializedName("tracks")
    val tracks: TracksResponse
)
