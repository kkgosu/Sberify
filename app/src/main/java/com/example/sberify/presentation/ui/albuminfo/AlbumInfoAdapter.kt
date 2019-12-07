package com.example.sberify.presentation.ui.albuminfo

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.databinding.ItemTrackListedBinding
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.BaseAdapter
import com.example.sberify.presentation.ui.Interaction1
import com.example.sberify.presentation.ui.utils.inflateBindingLayout
import kotlinx.android.synthetic.main.item_track_listed.view.*

class AlbumInfoAdapter<T : BaseModel>(private val interaction: Interaction1? = null) :
        BaseAdapter<T>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = inflateBindingLayout<ItemTrackListedBinding>(R.layout.item_track_listed,
                parent)
        return ViewHolder(binding, interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val track = differ.currentList[position] as Track
                holder.binding.track = track 
                holder.bind(track)
            }
        }
    }

    class ViewHolder
    constructor(val binding: ItemTrackListedBinding,
            private val interaction: Interaction1?) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Track) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item, this)
            }
            val builder = StringBuilder()
            item.artists.forEach {
                builder.append(it.name)
                        .append(", ")
            }
            itemView.artist_name.text = builder.dropLast(2)
                    .toString()
        }
    }
}
