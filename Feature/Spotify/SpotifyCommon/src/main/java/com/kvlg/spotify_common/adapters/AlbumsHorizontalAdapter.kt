package com.kvlg.spotify_common.adapters

/**
 * @author Konstantin Koval
 * @since 04.07.2020
 */
class AlbumsHorizontalAdapter(private val albumInteraction: AlbumInteraction) : BaseAdapter() {

    init {
        delegatesManager.addDelegate(albumHorizontalAdapterDelegate { album, view ->
            albumInteraction.onAlbumSelected(album, view)
        })
    }
}