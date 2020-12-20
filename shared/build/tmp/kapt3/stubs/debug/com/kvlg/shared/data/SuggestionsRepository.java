package com.kvlg.shared.data;

import java.lang.System;

/**
 * Single point of access to suggestions data for the presentation layer
 *
 * @author Konstantin Koval
 * @since 23.10.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/kvlg/shared/data/SuggestionsRepository;", "", "getAllSuggestions", "", "Lcom/kvlg/model/presentation/Suggestion;", "insertSuggestion", "", "suggestion", "shared_debug"})
public abstract interface SuggestionsRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.kvlg.model.presentation.Suggestion> getAllSuggestions();
    
    public abstract void insertSuggestion(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Suggestion suggestion);
}