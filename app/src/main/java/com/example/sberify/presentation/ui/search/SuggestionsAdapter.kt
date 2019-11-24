package com.example.sberify.presentation.ui.search

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.sberify.R
import kotlinx.android.synthetic.main.item_suggestion.view.*

class SuggestionsAdapter(
        private val interaction: Interaction? = null) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.contentEquals(newItem)
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_suggestion, parent,
                        false), interaction)
    }

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

    fun submitList(list: List<String>) {
        differ.submitList(list)
    }

    class ViewHolder
    constructor(itemView: View, private val interaction: Interaction?) : RecyclerView.ViewHolder(
            itemView) {

        fun bind(item: String) = with(itemView) {
            setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            suggestion_text.text = item
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: String)
    }
}
