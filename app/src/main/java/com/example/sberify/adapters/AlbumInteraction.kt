package com.example.sberify.adapters

import android.view.View
import com.kvlg.spotify_models.presentation.AlbumModel

interface AlbumInteraction {
    fun onAlbumSelected(item: AlbumModel, view: View)
}