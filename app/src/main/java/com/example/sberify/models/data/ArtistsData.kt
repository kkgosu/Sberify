package com.example.sberify.models.data

data class ArtistsData(val artists: Items) {
    data class Items(val items: List<ArtistData>) : BaseDataModel()
}