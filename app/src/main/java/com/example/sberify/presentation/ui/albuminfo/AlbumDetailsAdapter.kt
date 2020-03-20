package com.example.sberify.presentation.ui.albuminfo

import android.view.View
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.sberify.R
import com.example.sberify.base.BaseAdapter
import com.example.sberify.base.BaseViewHolder
import com.example.sberify.models.domain.Track

class AlbumDetailsAdapter(private val interaction: Interaction? = null) : BaseAdapter() {

    interface Interaction {
        fun onTrackSelected(item: Track, view: View)
    }

    init {
        val diffCallback = object : DiffUtil.ItemCallback<Track>() {

            override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
                return oldItem == newItem
            }
        }

        differ = AsyncListDiffer(this, diffCallback) as AsyncListDiffer<Any>
    }

    override fun layout(position: Int): Int = R.layout.item_track_line

    override fun viewHolder(layout: Int, view: View): BaseViewHolder =
        AlbumDetailsViewHolder(view, interaction)

    override fun submitList(list: List<Any>) {
        if (list[0] is Track) {
            differ.submitList(list)
        }
    }

}