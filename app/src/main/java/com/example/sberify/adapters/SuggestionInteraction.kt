package com.example.sberify.adapters

import com.kvlg.core.models.Suggestion


/**
 * @author Konstantin Koval
 * @since 04.07.2020
 */
interface SuggestionInteraction {
    fun onSuggestionSelected(position: Int, item: Suggestion)
}