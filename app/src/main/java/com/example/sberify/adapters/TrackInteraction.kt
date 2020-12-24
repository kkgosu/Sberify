package com.example.sberify.adapters

import android.view.View
import com.example.sberify.models.domain.TrackDomainModel

interface TrackInteraction {
    fun onTrackSelected(item: TrackDomainModel, view: View)
}