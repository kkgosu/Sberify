package com.kvlg.spotify.models.data

import com.google.gson.annotations.SerializedName

data class ExternalUrlResponse(
    @SerializedName("spotify")
    val spotify: String
)