package com.kvlg.shared.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0086\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\"\u0010\b\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\t0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u001a\u0082\u0001\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u000f2\"\u0010\b\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\t0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"resultData", "Landroidx/lifecycle/LiveData;", "T", "A", "databaseQuery", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "networkCall", "Lcom/kvlg/model/common/Result;", "saveCallResult", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Landroidx/lifecycle/LiveData;", "resultLiveData", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Landroidx/lifecycle/LiveData;", "shared_debug"})
public final class SingleSourceOfTruthStrategyKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, A extends java.lang.Object>androidx.lifecycle.LiveData<com.kvlg.model.common.Result<T>> resultLiveData(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends androidx.lifecycle.LiveData<T>> databaseQuery, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.kvlg.model.common.Result<? extends A>>, ? extends java.lang.Object> networkCall, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super A, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> saveCallResult) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, A extends java.lang.Object>androidx.lifecycle.LiveData<T> resultData(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> databaseQuery, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.kvlg.model.common.Result<? extends A>>, ? extends java.lang.Object> networkCall, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super A, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> saveCallResult) {
        return null;
    }
}