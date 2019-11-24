package com.example.sberify.data.model

data class TracksData(val tracks: Items) {
    data class Items(val items: List<TrackData>) : BaseDataModel()
}