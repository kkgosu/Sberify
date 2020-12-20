package com.example.sberify.adapters;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 04.07.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/sberify/adapters/SuggestionInteraction;", "", "onSuggestionSelected", "", "position", "", "item", "Lcom/example/sberify/models/domain/Suggestion;", "app_debug"})
public abstract interface SuggestionInteraction {
    
    public abstract void onSuggestionSelected(int position, @org.jetbrains.annotations.NotNull()
    com.example.sberify.models.domain.Suggestion item);
}