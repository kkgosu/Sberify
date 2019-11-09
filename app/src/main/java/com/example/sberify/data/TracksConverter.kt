package com.example.sberify.data

import com.example.sberify.data.model.TrackData
import com.example.sberify.domain.IConverter
import com.example.sberify.domain.model.Track

class TracksConverter : IConverter<List<TrackData>, List<Track>> {
    override fun convert(from: List<TrackData>, someItems: List<Any>?): List<Track> {
        val tracksList = arrayListOf<Track>()
        from.forEach {
            tracksList.add(Track(it.id, it.name))
        }
        return tracksList
    }
}