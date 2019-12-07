package com.example.sberify.presentation.ui.albuminfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.databinding.ItemTrackBinding
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.utils.createDiffCallback
import kotlinx.android.synthetic.main.item_track.view.*

class AlbumInfoAdapter(private val interaction: Interaction? = null) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK = createDiffCallback<Track>()
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemTrackBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_track, parent, false)
        return ViewHolder(binding, interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val track = differ.currentList[position]
                holder.binding.track = track
                holder.bind(track)
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
    constructor(val binding: ItemTrackBinding,
            private val interaction: Interaction?) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Track) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item, this)
            }

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
        fun onItemSelected(position: Int, item: Track, view: View)
    }
}
