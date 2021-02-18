package com.kvlg.spotify_common.adapters

class AlbumsAdapter(private val albumInteraction: AlbumInteraction) : BaseAdapter() {

    init {
        delegatesManager.addDelegate(albumAdapterDelegate { album, view ->
            albumInteraction.onAlbumSelected(album, view)
        })
    }
}