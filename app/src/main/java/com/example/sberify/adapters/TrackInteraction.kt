package com.example.sberify.adapters

import android.view.View
import com.example.sberify.models.newdomain.TrackDomainModel

interface TrackInteraction {
    fun onTrackSelected(item: TrackDomainModel, view: View)
}