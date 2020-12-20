package com.example.sberify.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/example/sberify/domain/IGeniusRepository;", "", "getLyrics", "Landroidx/lifecycle/LiveData;", "Lcom/example/sberify/data/Result;", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "track", "(Lcom/example/sberify/models/newdomain/TrackDomainModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface IGeniusRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLyrics(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdomain.TrackDomainModel track, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.lifecycle.LiveData<com.example.sberify.data.Result<com.example.sberify.models.newdomain.TrackDomainModel>>> p1);
}