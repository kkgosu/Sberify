package com.kvlg.shared.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/kvlg/shared/data/SuggestionRepositoryImpl;", "Lcom/kvlg/shared/data/SuggestionsRepository;", "database", "Lcom/kvlg/shared/data/db/AppDatabase;", "(Lcom/kvlg/shared/data/db/AppDatabase;)V", "getAllSuggestions", "", "Lcom/kvlg/model/presentation/Suggestion;", "insertSuggestion", "", "suggestion", "shared_debug"})
@javax.inject.Singleton()
public final class SuggestionRepositoryImpl implements com.kvlg.shared.data.SuggestionsRepository {
    private final com.kvlg.shared.data.db.AppDatabase database = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.kvlg.model.presentation.Suggestion> getAllSuggestions() {
        return null;
    }
    
    @java.lang.Override()
    public void insertSuggestion(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Suggestion suggestion) {
    }
    
    public SuggestionRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.AppDatabase database) {
        super();
    }
}