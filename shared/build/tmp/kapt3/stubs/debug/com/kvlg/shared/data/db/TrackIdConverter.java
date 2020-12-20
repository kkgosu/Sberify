package com.kvlg.shared.data.db;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007J\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/kvlg/shared/data/db/TrackIdConverter;", "", "()V", "DELIMITER_COMMA", "", "DELIMITER_DASH", "fromList", "list", "", "Lcom/kvlg/model/presentation/Track;", "fromString", "string", "shared_debug"})
public final class TrackIdConverter {
    private static final java.lang.String DELIMITER_DASH = "<---->";
    private static final java.lang.String DELIMITER_COMMA = ":::::";
    @org.jetbrains.annotations.NotNull()
    public static final com.kvlg.shared.data.db.TrackIdConverter INSTANCE = null;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public static final java.lang.String fromList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.kvlg.model.presentation.Track> list) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public static final java.util.List<com.kvlg.model.presentation.Track> fromString(@org.jetbrains.annotations.Nullable()
    java.lang.String string) {
        return null;
    }
    
    private TrackIdConverter() {
        super();
    }
}