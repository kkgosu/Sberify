package com.kvlg.spotify_api.models.data

import com.google.gson.annotations.SerializedName

data class AlbumsResponse(
    @SerializedName("href")
    val href: String,
    @SerializedName("items")
    val items: List<AlbumInfoResponse>,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("total")
    val total: Int
)