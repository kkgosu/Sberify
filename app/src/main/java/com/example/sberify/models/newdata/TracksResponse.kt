package com.example.sberify.models.newdata

import com.google.gson.annotations.SerializedName

data class TracksResponse(
    @SerializedName("href")
    val href: String?,
    @SerializedName("items")
    val items: List<TrackItemPreviewResponse>?,
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