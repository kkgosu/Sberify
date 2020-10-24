package com.kvlg.model.data.spotify

data class TracksData(val tracks: Items) {
    data class Items(val items: List<TrackData>) : BaseDataModel()
}