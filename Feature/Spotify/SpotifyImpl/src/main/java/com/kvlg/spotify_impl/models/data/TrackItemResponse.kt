package com.kvlg.spotify_impl.models.data

import com.google.gson.annotations.SerializedName

data class TrackItemResponse(
    @SerializedName("artists")
    val artists: List<ArtistResponse>,
    @SerializedName("duration_ms")
    val durationMs: Int?,
    @SerializedName("explicit")
    val explicit: Boolean?,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("preview_url")
    val previewUrl: String?,
    @SerializedName("uri")
    val uri: String
)