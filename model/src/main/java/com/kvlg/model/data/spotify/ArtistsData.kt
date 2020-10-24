package com.kvlg.model.data.spotify

data class ArtistsData(val artists: Items) {
    data class Items(val items: List<ArtistData>) : BaseDataModel()
}