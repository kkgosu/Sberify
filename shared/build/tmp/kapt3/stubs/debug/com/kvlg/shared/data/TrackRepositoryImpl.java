package com.kvlg.shared.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J!\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\f\u0010\u0015\u001a\u00020\u0016*\u00020\u000bH\u0002J\f\u0010\u0017\u001a\u00020\u000b*\u00020\u0016H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/kvlg/shared/data/TrackRepositoryImpl;", "Lcom/kvlg/shared/data/TrackRepository;", "database", "Lcom/kvlg/shared/data/db/AppDatabase;", "spotifyApi", "Lcom/kvlg/network/spotify/SpotifyApi;", "converter", "Lcom/kvlg/network/spotify/DataConverter;", "(Lcom/kvlg/shared/data/db/AppDatabase;Lcom/kvlg/network/spotify/SpotifyApi;Lcom/kvlg/network/spotify/DataConverter;)V", "getFavoriteTracks", "", "Lcom/kvlg/model/presentation/Track;", "getTracksFromDb", "keyword", "", "getTracksFromSpotify", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTrackIntoDb", "", "track", "updateTrackInDb", "toEntity", "Lcom/kvlg/shared/data/db/track/TrackEntity;", "toTrack", "shared_debug"})
public final class TrackRepositoryImpl implements com.kvlg.shared.data.TrackRepository {
    private final com.kvlg.shared.data.db.AppDatabase database = null;
    private final com.kvlg.network.spotify.SpotifyApi spotifyApi = null;
    private final com.kvlg.network.spotify.DataConverter converter = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.kvlg.model.presentation.Track> getFavoriteTracks() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getTracksFromSpotify(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kvlg.model.presentation.Track>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.kvlg.model.presentation.Track> getTracksFromDb(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
        return null;
    }
    
    @java.lang.Override()
    public void saveTrackIntoDb(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Track track) {
    }
    
    @java.lang.Override()
    public void updateTrackInDb(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Track track) {
    }
    
    private final com.kvlg.model.presentation.Track toTrack(com.kvlg.shared.data.db.track.TrackEntity $this$toTrack) {
        return null;
    }
    
    private final com.kvlg.shared.data.db.track.TrackEntity toEntity(com.kvlg.model.presentation.Track $this$toEntity) {
        return null;
    }
    
    public TrackRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.SpotifyApi spotifyApi, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.DataConverter converter) {
        super();
    }
}