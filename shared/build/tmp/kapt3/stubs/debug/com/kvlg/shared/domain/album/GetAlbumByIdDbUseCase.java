package com.kvlg.shared.domain.album;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/kvlg/shared/domain/album/GetAlbumByIdDbUseCase;", "Lcom/kvlg/shared/domain/UseCase;", "", "Lcom/kvlg/model/presentation/Album;", "repository", "Lcom/kvlg/shared/data/AlbumRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/kvlg/shared/data/AlbumRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", "parameters", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared_debug"})
public final class GetAlbumByIdDbUseCase extends com.kvlg.shared.domain.UseCase<java.lang.String, com.kvlg.model.presentation.Album> {
    private final com.kvlg.shared.data.AlbumRepository repository = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Object execute(@org.jetbrains.annotations.NotNull()
    java.lang.String parameters, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kvlg.model.presentation.Album> p1) {
        return null;
    }
    
    public GetAlbumByIdDbUseCase(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.AlbumRepository repository, @org.jetbrains.annotations.NotNull()
    @com.kvlg.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super(null);
    }
}