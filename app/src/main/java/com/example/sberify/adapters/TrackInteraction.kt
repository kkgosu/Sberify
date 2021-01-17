package com.example.sberify.adapters

import android.view.View
import com.kvlg.spotify.models.presentation.TrackModel

interface TrackInteraction {
    fun onTrackSelected(item: TrackModel, view: View)
}