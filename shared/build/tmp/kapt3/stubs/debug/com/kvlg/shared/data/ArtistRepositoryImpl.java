package com.kvlg.shared.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/kvlg/shared/data/ArtistRepositoryImpl;", "Lcom/kvlg/shared/data/ArtistRepository;", "database", "Lcom/kvlg/shared/data/db/AppDatabase;", "spotifyApi", "Lcom/kvlg/network/spotify/SpotifyApi;", "converter", "Lcom/kvlg/network/spotify/DataConverter;", "(Lcom/kvlg/shared/data/db/AppDatabase;Lcom/kvlg/network/spotify/SpotifyApi;Lcom/kvlg/network/spotify/DataConverter;)V", "getArtistFromDb", "", "Lcom/kvlg/model/presentation/Artist;", "keyword", "", "getArtistFromSpotify", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveArtistIntoDb", "", "artist", "shared_debug"})
public final class ArtistRepositoryImpl implements com.kvlg.shared.data.ArtistRepository {
    private final com.kvlg.shared.data.db.AppDatabase database = null;
    private final com.kvlg.network.spotify.SpotifyApi spotifyApi = null;
    private final com.kvlg.network.spotify.DataConverter converter = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getArtistFromSpotify(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kvlg.model.presentation.Artist>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.kvlg.model.presentation.Artist> getArtistFromDb(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
        return null;
    }
    
    @java.lang.Override()
    public void saveArtistIntoDb(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Artist artist) {
    }
    
    public ArtistRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.SpotifyApi spotifyApi, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.DataConverter converter) {
        super();
    }
}