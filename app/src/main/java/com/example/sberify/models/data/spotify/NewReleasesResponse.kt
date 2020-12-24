package com.example.sberify.models.data.spotify

import com.google.gson.annotations.SerializedName

data class NewReleasesResponse(
    @SerializedName("albums")
    val albums: AlbumsResponse
)