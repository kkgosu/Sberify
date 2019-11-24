package com.example.sberify.presentation.ui.newreleases

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.sberify.R
import com.example.sberify.domain.model.Album
import com.example.sberify.presentation.ui.utils.loadImage
import kotlinx.android.synthetic.main.item_new_release.view.*

class NewReleasesAdapter(
        private val interaction: Interaction? = null) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Album>() {

        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_new_release, parent,
                        false), interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Album>) {
        differ.submitList(list)
    }

    class ViewHolder
    constructor(itemView: View, private val interaction: Interaction?) : RecyclerView.ViewHolder(
            itemView) {

        fun bind(item: Album) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(item, itemView)
            }
            release_cover.loadImage(item.imageUrl)
            release_name.text = item.name
            artist_name.text = item.artist.name

            release_cover.transitionName = item.id
            release_name.transitionName = item.name
            artist_name.transitionName = item.artist.name
        }
    }

    interface Interaction {
        fun onItemSelected(item: Album, view: View)
    }
}
