package com.example.sberify.presentation.ui.favorite

import androidx.recyclerview.widget.DiffUtil
import com.example.sberify.adapters.AlbumInteraction
import com.example.sberify.adapters.TrackInteraction
import com.example.sberify.adapters.albumAdapterDelegate
import com.example.sberify.adapters.trackAdapterDelegate
import com.example.sberify.models.domain.BaseModel
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter


class FavoriteAdapter(
    private val trackInteraction: TrackInteraction?,
    private val albumInteraction: AlbumInteraction
) : AsyncListDifferDelegationAdapter<BaseModel>(DIFF_CALLBACK) {

    init {
        delegatesManager
            .addDelegate(trackAdapterDelegate { track, view ->
                trackInteraction?.onTrackSelected(track, view)
            })
            .addDelegate(albumAdapterDelegate { album, view ->
                albumInteraction.onAlbumSelected(album, view)
            })
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<BaseModel> =
            object : DiffUtil.ItemCallback<BaseModel>() {
                override fun areItemsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean =
                    oldItem.baseId == newItem.baseId

                override fun areContentsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean =
                    oldItem == newItem
            }
    }
}