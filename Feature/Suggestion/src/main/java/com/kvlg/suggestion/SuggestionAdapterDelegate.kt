package com.kvlg.suggestion

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.kvlg.suggestion.databinding.ItemSuggestionBinding

/*
 * @author Konstantin Koval
 * @since 18.02.2021
*/

fun suggestionAdapterDelegate(itemClickListener: (Int, Suggestion) -> Unit) =
    adapterDelegateViewBinding<Suggestion, Suggestion, ItemSuggestionBinding>({ layoutInflater, parent ->
        ItemSuggestionBinding.inflate(layoutInflater, parent, false)
    }) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(adapterPosition, item)
        }
        bind {
            binding.suggestionText.text = item.text
        }
    }
