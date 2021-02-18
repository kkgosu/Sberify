package com.example.sberify.adapters

import android.view.View
import com.kvlg.spotify_common.presentation.TrackModel

interface TrackInteraction {
    fun onTrackSelected(item: TrackModel, view: View)
}