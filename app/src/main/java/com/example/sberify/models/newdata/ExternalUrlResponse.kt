package com.example.sberify.models.newdata

import com.google.gson.annotations.SerializedName

data class ExternalUrlResponse(
    @SerializedName("spotify")
    val spotify: String
)