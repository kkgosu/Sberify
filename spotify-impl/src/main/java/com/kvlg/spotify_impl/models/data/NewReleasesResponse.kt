package com.kvlg.spotify_impl.models.data

import com.google.gson.annotations.SerializedName

data class NewReleasesResponse(
    @SerializedName("albums")
    val albums: AlbumsResponse
)