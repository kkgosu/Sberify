package com.kvlg.shared.domain.suggestions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/kvlg/shared/domain/suggestions/SuggestionUseCasesProviderImpl;", "Lcom/kvlg/shared/domain/suggestions/SuggestionUseCasesProvider;", "repository", "Lcom/kvlg/shared/data/SuggestionsRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/kvlg/shared/data/SuggestionsRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "loadSuggestion", "Lcom/kvlg/shared/domain/suggestions/LoadSuggestionUseCase;", "getLoadSuggestion", "()Lcom/kvlg/shared/domain/suggestions/LoadSuggestionUseCase;", "saveSuggestion", "Lcom/kvlg/shared/domain/suggestions/SaveSuggestionUseCase;", "getSaveSuggestion", "()Lcom/kvlg/shared/domain/suggestions/SaveSuggestionUseCase;", "shared_debug"})
public final class SuggestionUseCasesProviderImpl implements com.kvlg.shared.domain.suggestions.SuggestionUseCasesProvider {
    private final com.kvlg.shared.data.SuggestionsRepository repository = null;
    private final kotlinx.coroutines.CoroutineDispatcher dispatcher = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.suggestions.SaveSuggestionUseCase getSaveSuggestion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.suggestions.LoadSuggestionUseCase getLoadSuggestion() {
        return null;
    }
    
    public SuggestionUseCasesProviderImpl(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.SuggestionsRepository repository, @org.jetbrains.annotations.NotNull()
    @com.kvlg.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super();
    }
}