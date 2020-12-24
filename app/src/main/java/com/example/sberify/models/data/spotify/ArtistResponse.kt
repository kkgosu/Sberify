package com.example.sberify.models.data.spotify

import com.google.gson.annotations.SerializedName

data class ArtistResponse(
    @SerializedName("external_urls")
    val externalUrls: ExternalUrlResponse,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("uri")
    val uri: String,
    @SerializedName("images")
    val images: List<ImageResponse>?
)