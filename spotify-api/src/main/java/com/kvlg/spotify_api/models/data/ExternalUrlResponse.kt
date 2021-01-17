package com.kvlg.spotify_api.models.data

import com.google.gson.annotations.SerializedName

data class ExternalUrlResponse(
    @SerializedName("spotify")
    val spotify: String
)