package com.example.sberify.adapters

import com.example.sberify.base.BaseAdapter1

class AlbumsAdapter(private val albumInteraction: AlbumInteraction?) : BaseAdapter1() {

    init {
        delegatesManager.addDelegate(albumAdapterDelegate { album, view ->
            albumInteraction?.onAlbumSelected(album, view)
        })
    }
}