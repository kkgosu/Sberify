package com.example.sberify.data.model

data class ArtistsData(val artists: Items) {
    data class Items(val items: List<ArtistData>) : BaseDataModel()
}