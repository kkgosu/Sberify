package com.example.sberify.data.model

data class AlbumsResponse(val albums: Items) {
    data class Items(val items: List<ItemResponse>? = null)

    data class ItemResponse(val id: String,
            val artists: List<Artist>,
            val images: List<Image>? = null,
            val name: String,
            val release_date: String)

    data class Artist(val id: String,
            val name: String,
            val images: List<Image>? = null)

    data class Image(val url: String,
            val height: Int,
            val width: Int)
}