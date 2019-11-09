package com.example.sberify.data

import com.example.sberify.data.model.AlbumsData
import com.example.sberify.domain.IConverter
import com.example.sberify.domain.model.Album

class AlbumsConverter : IConverter<AlbumsData.Items, List<Album>> {

    override fun convert(from: AlbumsData.Items, someItems: List<Any>?): List<Album> {
        val albumsList = arrayListOf<Album>()
        from.items?.forEach {
            albumsList.add(
                    Album(it.id, it.artists[0], it.name, null, it.images!![0].url, it.release_date))
        }
        return albumsList
    }


}