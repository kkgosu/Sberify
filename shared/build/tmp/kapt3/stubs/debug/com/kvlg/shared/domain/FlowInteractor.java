package com.kvlg.shared.domain;

import java.lang.System;

/**
 * Executes business logic in its execute method and keep posting updates to the result as
 * [Result<R>].
 * Handling an exception (emit [Result.error] to the result) is the subclasses's responsibility.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0\b2\u0006\u0010\n\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0\b2\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/kvlg/shared/domain/FlowInteractor;", "P", "R", "", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", "Lkotlinx/coroutines/flow/Flow;", "Lcom/kvlg/model/common/Result;", "parameters", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "invoke", "shared_debug"})
public abstract class FlowInteractor<P extends java.lang.Object, R extends java.lang.Object> {
    private final kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.kvlg.model.common.Result<R>> invoke(P parameters) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract kotlinx.coroutines.flow.Flow<com.kvlg.model.common.Result<R>> execute(P parameters);
    
    public FlowInteractor(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher) {
        super();
    }
}