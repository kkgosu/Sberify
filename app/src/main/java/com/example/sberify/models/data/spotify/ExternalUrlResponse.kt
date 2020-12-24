package com.example.sberify.models.data.spotify

import com.google.gson.annotations.SerializedName

data class ExternalUrlResponse(
    @SerializedName("spotify")
    val spotify: String
)