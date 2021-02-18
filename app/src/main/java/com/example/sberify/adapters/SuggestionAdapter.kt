package com.example.sberify.adapters

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.kvlg.suggestion.Suggestion


/**
 * @author Konstantin Koval
 * @since 04.07.2020
 */
class SuggestionAdapter(private val suggestionInteractor: SuggestionInteraction) : AsyncListDifferDelegationAdapter<Suggestion>(DIFF_CALLBACK) {

    init {
        delegatesManager.addDelegate(suggestionAdapterDelegate { i, suggestion ->
            suggestionInteractor.onSuggestionSelected(i, suggestion)
        })
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Suggestion>() {

            override fun areItemsTheSame(oldItem: Suggestion, newItem: Suggestion): Boolean {
                return oldItem.text == newItem.text
            }

            override fun areContentsTheSame(oldItem: Suggestion, newItem: Suggestion): Boolean {
                return oldItem == newItem
            }
        }
    }
}