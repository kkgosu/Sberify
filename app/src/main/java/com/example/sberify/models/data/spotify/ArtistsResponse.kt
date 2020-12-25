package com.example.sberify.models.data.spotify

import com.google.gson.annotations.SerializedName

/**
 * @author Konstantin Koval
 * @since 13.12.2020
 */
data class ArtistsResponse(
    @SerializedName("items")
    val items: List<ArtistResponse>,
)