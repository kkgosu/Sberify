package com.example.sberify.data.model

data class ArtistData(val id: String,
        val images: List<ImageData>? = null,
        val name: String,
        val popularity: Int? = null)