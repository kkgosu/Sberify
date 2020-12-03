package com.example.sberify.models.data

data class AlbumsData(val albums: Items) {
    data class Items(val items: List<AlbumData>) : BaseDataModel()
}