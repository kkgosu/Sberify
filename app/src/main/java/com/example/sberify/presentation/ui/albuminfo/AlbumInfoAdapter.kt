package com.example.sberify.presentation.ui.albuminfo

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.databinding.ItemTrackListedBinding
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.BaseAdapter
import com.example.sberify.presentation.ui.Interaction
import com.example.sberify.presentation.ui.utils.inflateLayout

class AlbumInfoAdapter<T : BaseModel>(private val interaction: Interaction? = null) :
        BaseAdapter<T>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = inflateLayout<ItemTrackListedBinding>(R.layout.item_track_listed,
                parent)
        return ViewHolder(binding, interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val track = differ.currentList[position] as Track
                holder.bind(track)
            }
        }
    }

    class ViewHolder
    constructor(private val binding: ItemTrackListedBinding,
            private val interaction: Interaction?) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Track) = with(itemView) {
            binding.apply {
                track = item
                executePendingBindings()
            }
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item, this)
            }
        }
    }
}
