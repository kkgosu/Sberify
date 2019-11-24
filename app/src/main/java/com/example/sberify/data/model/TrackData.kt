package com.example.sberify.data.model

data class TrackData(val id: String,
        val name: String,
        val album: AlbumData,
        val artists: List<ArtistData>,
        val disc_number: Int,
        val track_number: Int) : BaseDataModel() {
}