package com.example.sberify.adapters

import android.view.View
import com.kvlg.model.presentation.Track

interface TrackInteraction {
    fun onTrackSelected(item: Track, view: View)
}