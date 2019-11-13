package com.example.sberify.data.model

data class AlbumsData(val albums: Items) {
    data class Items(val items: List<AlbumData>? = null) : BaseDataModel()
}