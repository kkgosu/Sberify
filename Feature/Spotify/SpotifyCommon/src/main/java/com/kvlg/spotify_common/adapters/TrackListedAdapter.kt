package com.kvlg.spotify_common.adapters

class TrackListedAdapter(private val trackInteraction: TrackInteraction) : BaseAdapter() {

    init {
        delegatesManager.addDelegate(trackListedAdapterDelegate { track, view ->
            trackInteraction.onTrackSelected(track, view)
        })
    }
}