package com.example.sberify.presentation.ui.albuminfo

import android.view.View
import androidx.core.view.ViewCompat
import com.example.sberify.adapters.TrackInteraction
import com.example.sberify.base.BaseViewHolder
import com.example.sberify.databinding.ItemTrackLineBinding
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.utils.bindings

class AlbumDetailsViewHolder(
    view: View,
    private val interaction: TrackInteraction?
) : BaseViewHolder(view) {

    private lateinit var data: Track
    private val binding: ItemTrackLineBinding by bindings(view)

    override fun bindData(data: Any) {
        if (data is Track) {
            this.data = data
            binding.apply {
                ViewCompat.setTransitionName(binding.itemContainer, data.id)
                track = data
                pos = adapterPosition + 1
                executePendingBindings()
            }
        }
    }

    override fun onClick(v: View?) {
        interaction?.onTrackSelected(data, binding.itemContainer)
    }

    override fun onLongClick(v: View?): Boolean = false
}