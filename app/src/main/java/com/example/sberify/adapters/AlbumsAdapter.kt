package com.example.sberify.adapters

import com.example.sberify.base.BaseAdapter

class AlbumsAdapter(private val albumInteraction: AlbumInteraction) : BaseAdapter() {

    init {
        delegatesManager.addDelegate(albumAdapterDelegate { album, view ->
            albumInteraction.onAlbumSelected(album, view)
        })
    }
}