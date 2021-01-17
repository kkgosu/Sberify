package com.kvlg.spotify.models.data

import com.google.gson.annotations.SerializedName

data class NewReleasesResponse(
    @SerializedName("albums")
    val albums: AlbumsResponse
)