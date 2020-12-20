package com.kvlg.shared.data;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/kvlg/shared/data/ArtistRepository;", "", "getArtistFromDb", "", "Lcom/kvlg/model/presentation/Artist;", "keyword", "", "getArtistFromSpotify", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveArtistIntoDb", "", "artist", "shared_debug"})
public abstract interface ArtistRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getArtistFromSpotify(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kvlg.model.presentation.Artist>> p1);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.kvlg.model.presentation.Artist> getArtistFromDb(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword);
    
    public abstract void saveArtistIntoDb(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Artist artist);
}