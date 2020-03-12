package com.example.sberify.presentation.ui.albuminfo

import android.view.View
import com.example.sberify.base.BaseViewHolder
import com.example.sberify.databinding.ItemTrackListedBinding
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.utils.bindings

class AlbumDetailsViewHolder(
    view: View,
    private val interaction: AlbumDetailsAdapter.Interaction?
) : BaseViewHolder(view) {

    private lateinit var data: Track
    private val binding: ItemTrackListedBinding by bindings(view)

    override fun bindData(data: Any) {
        if (data is Track) {
            this.data = data
            binding.apply {
                track = data
                pos = adapterPosition + 1
                executePendingBindings()
            }
        }
    }

    override fun onClick(v: View?) {
        interaction?.onItemSelected(data, v!!)
    }

    override fun onLongClick(v: View?): Boolean = false
}