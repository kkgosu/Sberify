package com.example.sberify.adapters

import android.view.View
import com.example.sberify.models.domain.Track

interface TrackInteraction {
    fun onTrackSelected(item: Track, view: View)
}