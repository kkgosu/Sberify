package com.example.sberify.adapters

import com.example.sberify.base.BaseAdapter1

class TrackListedAdapter(private val trackInteraction: TrackInteraction?) : BaseAdapter1() {

    init {
        delegatesManager.addDelegate(trackListedAdapterDelegate { track, view ->
            trackInteraction?.onTrackSelected(track, view)
        })
    }
}