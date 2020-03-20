package com.example.sberify.presentation.ui.search

import androidx.recyclerview.widget.DiffUtil
import com.example.sberify.adapters.*
import com.example.sberify.models.domain.BaseModel
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class SearchAdapter1(
    private val trackInteraction: TrackInteraction?,
    private val albumInteraction: AlbumInteraction?
) : AsyncListDifferDelegationAdapter<BaseModel>(DIFF_CALLBACK) {

    init {
        delegatesManager
            .addDelegate(albumAdapterDelegate { album, view ->
                albumInteraction?.onAlbumSelected(album, view)
            })
            .addDelegate(trackCardViewAdapterDelegate { track, view ->
                trackInteraction?.onTrackSelected(track, view)
            })
            .addDelegate(artistAdapterDelegate())
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