package com.kvlg.spotify.models.data

import com.google.gson.annotations.SerializedName

data class CopyrightResponse(
    @SerializedName("text")
    val text: String?,
    @SerializedName("type")
    val type: String?
)