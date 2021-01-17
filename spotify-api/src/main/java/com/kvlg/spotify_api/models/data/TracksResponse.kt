package com.kvlg.spotify_api.models.data

import com.google.gson.annotations.SerializedName

data class TracksResponse(
    @SerializedName("href")
    val href: String?,
    @SerializedName("items")
    val items: List<TrackItemResponse>,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("next")
    val next: Any?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("total")
    val total: Int?
)