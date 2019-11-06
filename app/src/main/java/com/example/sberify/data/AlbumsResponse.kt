package com.example.sberify.data

import com.google.gson.annotations.SerializedName

data class AlbumsResponse(@SerializedName("albums") val albums: Items) {
    data class Items(@SerializedName("items") val items: List<ItemResponse>? = null)

    data class ItemResponse(@SerializedName("id") val id: String,
            @SerializedName("artists")
            val artists: List<Artist>,
            @SerializedName("images")
            val images: List<Image>? = null,
            @SerializedName("name") val name: String,
            @SerializedName("release_date") val release_date: String)

    data class Artist(@SerializedName("id") val id: String,
            @SerializedName("name") val name: String,
            @SerializedName("images") val images: List<Image>? = null)

    data class Image(@SerializedName("url") val url: String,
            @SerializedName("height") val height: Int,
            @SerializedName("width") val width: Int)
}