package com.example.sberify.presentation.ui.newreleases

import android.view.View
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.sberify.R
import com.example.sberify.base.BaseAdapter
import com.example.sberify.base.BaseViewHolder
import com.example.sberify.models.domain.Album

class AlbumsAdapter(private val interaction: Interaction? = null) :
    BaseAdapter() {

    interface Interaction {
        fun onAlbumSelected(item: Album, view: View)
    }

    init {
        val diffCallback = object : DiffUtil.ItemCallback<Album>() {

            override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
                return oldItem == newItem
            }
        }

        differ = AsyncListDiffer(this, diffCallback) as AsyncListDiffer<Any>
    }

    override fun layout(position: Int): Int = R.layout.item_album

    override fun viewHolder(layout: Int, view: View): BaseViewHolder =
        AlbumsViewHolder(view, interaction)

    override fun submitList(list: List<Any>) {
        if (list[0] is Album) {
            differ.submitList(list)
        }
    }
}