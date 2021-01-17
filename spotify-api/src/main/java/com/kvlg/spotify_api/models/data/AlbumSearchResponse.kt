package com.kvlg.spotify_api.models.data

import com.google.gson.annotations.SerializedName

/**
 * @author Konstantin Koval
 * @since 11.01.2021
 */
data class AlbumSearchResponse(
    @SerializedName("albums")
    val albums: AlbumsResponse
)
