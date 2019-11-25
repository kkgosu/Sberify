package com.example.sberify.presentation.ui.albuminfo

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.domain.model.Track
import com.example.sberify.presentation.ui.utils.createDiffCallback
import com.example.sberify.presentation.ui.utils.inflateLayout
import kotlinx.android.synthetic.main.item_track.view.*

class AlbumInfoAdapter(private val interaction: Interaction? = null) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK = createDiffCallback<Track>()
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ViewHolder(inflateLayout(R.layout.item_track, parent), interaction)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Track>) {
        differ.submitList(list)
    }

    class ViewHolder
    constructor(itemView: View,
            private val interaction: Interaction?) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Track) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            track_name.text = item.name
            val builder = StringBuilder()
            item.artists.forEach {
                builder.append(it.name)
                        .append(", ")
            }
            artist_name.text = builder.dropLast(2)
                    .toString()
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Track)
    }
}
