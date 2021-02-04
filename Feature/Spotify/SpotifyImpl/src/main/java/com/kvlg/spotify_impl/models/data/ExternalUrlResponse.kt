package com.kvlg.spotify_impl.models.data

import com.google.gson.annotations.SerializedName

data class ExternalUrlResponse(
    @SerializedName("spotify")
    val spotify: String
)