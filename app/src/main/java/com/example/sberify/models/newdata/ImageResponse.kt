package com.example.sberify.models.newdata

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)