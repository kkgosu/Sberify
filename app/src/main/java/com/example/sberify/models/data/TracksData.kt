package com.example.sberify.models.data

data class TracksData(val tracks: Items) {
    data class Items(val items: List<TrackData>) : BaseDataModel()
}