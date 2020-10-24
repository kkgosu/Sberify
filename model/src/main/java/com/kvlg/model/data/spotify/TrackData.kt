package com.kvlg.model.data.spotify

data class TrackData(
    val id: String,
    val name: String,
    val album: AlbumData,
    val artists: List<ArtistData>,
    val disc_number: Int,
    val track_number: Int
) : BaseDataModel()