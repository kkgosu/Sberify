package com.example.sberify.base

import android.view.View
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.presentation.ui.utils.createDiffCallback

abstract class BaseAdapter<T : BaseModel> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK = createDiffCallback<T>()
    val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<T>) {
        differ.submitList(list)
    }
}

interface Interaction {
    fun onItemSelected(position: Int, item: BaseModel, view: View)
}
