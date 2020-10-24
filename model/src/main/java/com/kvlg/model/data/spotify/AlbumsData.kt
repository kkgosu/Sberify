package com.kvlg.model.data.spotify

data class AlbumsData(val albums: Items) {
    data class Items(val items: List<AlbumData>? = null) : BaseDataModel()
}