package com.kvlg.shared.domain;

import java.lang.System;

/**
 * Executes business logic synchronously or asynchronously using Coroutines.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H\u00a4@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\u0006\u0010\b\u001a\u00028\u0000H\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/kvlg/shared/domain/UseCase;", "P", "R", "", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", "parameters", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "Lcom/kvlg/model/common/Result;", "shared_debug"})
public abstract class UseCase<P extends java.lang.Object, R extends java.lang.Object> {
    private final kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher = null;
    
    /**
     * Executes the use case asynchronously and returns a [Result].
     *
     * @return a [Result].
     *
     * @param parameters the input parameters to run the use case with
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(P parameters, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kvlg.model.common.Result<? extends R>> p1) {
        return null;
    }
    
    /**
     * Override this to set the code to be executed.
     */
    @org.jetbrains.annotations.Nullable()
    protected abstract java.lang.Object execute(P parameters, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super R> p1);
    
    public UseCase(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher) {
        super();
    }
}