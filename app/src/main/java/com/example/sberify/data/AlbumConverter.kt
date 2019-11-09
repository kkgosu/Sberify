package com.example.sberify.data

import com.example.sberify.data.model.AlbumData
import com.example.sberify.domain.IConverter
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Track

class AlbumConverter : IConverter<AlbumData, Album> {

    override fun convert(from: AlbumData, someItems: List<Any>?): Album {
        val tracks = someItems as List<Track>
        return Album(from.id, from.artists[0], from.name, tracks,
                from.images!![0].url,
                from.release_date)
    }
}