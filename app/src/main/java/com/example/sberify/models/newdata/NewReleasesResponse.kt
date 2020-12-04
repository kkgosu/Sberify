package com.example.sberify.models.newdata

import com.google.gson.annotations.SerializedName

data class NewReleasesResponse(
    @SerializedName("albums")
    val albums: AlbumsResponse
)