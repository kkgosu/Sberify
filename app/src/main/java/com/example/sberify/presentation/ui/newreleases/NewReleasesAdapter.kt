package com.example.sberify.presentation.ui.newreleases

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.databinding.ItemAlbumBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.presentation.ui.BaseAdapter
import com.example.sberify.presentation.ui.Interaction1
import com.example.sberify.presentation.ui.utils.inflateBindingLayout

class NewReleasesAdapter<T : BaseModel>(
        private val interaction: Interaction1? = null) : BaseAdapter<T>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = inflateBindingLayout<ItemAlbumBinding>(R.layout.item_album, parent)
        return ViewHolder(binding, interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val album = differ.currentList[position] as Album
                holder.bindingItem.album = album
                holder.bind(album)
            }
        }
    }

    class ViewHolder
    constructor(val bindingItem: ItemAlbumBinding,
            private val interaction: Interaction1?) : RecyclerView.ViewHolder(
            bindingItem.root) {

        fun bind(item: Album) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item, this)
            }
        }
    }
}
