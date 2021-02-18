package com.kvlg.spotify_common.adapters

class SearchAdapter(
    private val trackInteraction: TrackInteraction,
    private val albumInteraction: AlbumInteraction
) : BaseAdapter() {

    init {
        delegatesManager
            .addDelegate(albumAdapterDelegate { album, view ->
                albumInteraction.onAlbumSelected(album, view)
            })
            .addDelegate(trackCardViewAdapterDelegate { track, view ->
                trackInteraction.onTrackSelected(track, view)
            })
            .addDelegate(artistAdapterDelegate())
    }
}