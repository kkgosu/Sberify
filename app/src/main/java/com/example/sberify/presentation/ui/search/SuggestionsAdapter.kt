package com.example.sberify.presentation.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.models.domain.Suggestion
import kotlinx.android.synthetic.main.item_suggestion.view.*

class SuggestionsAdapter(
        private val interaction: Interaction? = null) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Suggestion>() {

        override fun areItemsTheSame(oldItem: Suggestion, newItem: Suggestion): Boolean {
            return oldItem.text == newItem.text
        }

        override fun areContentsTheSame(oldItem: Suggestion, newItem: Suggestion): Boolean {
            return oldItem == newItem
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

    fun submitList(list: List<Suggestion>) {
        differ.submitList(list)
    }

    class ViewHolder
    constructor(itemView: View, private val interaction: Interaction?) : RecyclerView.ViewHolder(
            itemView) {

        fun bind(item: Suggestion) = with(itemView) {
            setOnClickListener {
                interaction?.onSuggestionSelected(adapterPosition, item)
            }
            suggestion_text.text = item.text
        }
    }

    interface Interaction {
        fun onSuggestionSelected(position: Int, item: Suggestion)
    }
}
