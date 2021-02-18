package com.kvlg.suggestion


/**
 * @author Konstantin Koval
 * @since 04.07.2020
 */
interface SuggestionInteraction {
    fun onSuggestionSelected(position: Int, item: Suggestion)
}