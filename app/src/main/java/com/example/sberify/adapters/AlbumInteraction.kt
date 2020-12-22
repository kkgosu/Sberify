package com.example.sberify.adapters

import android.view.View
import com.example.sberify.models.newdomain.AlbumArtistsDomainModel

interface AlbumInteraction {
    fun onAlbumSelected(item: AlbumArtistsDomainModel, view: View)
}