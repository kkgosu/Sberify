package com.kvlg.shared.data.db;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/kvlg/shared/data/db/ArtistsConverter;", "", "()V", "DELIMITER_COMMA", "", "DELIMITER_DASH", "fromList", "from", "", "Lcom/kvlg/model/presentation/Artist;", "fromString", "string", "shared_debug"})
public final class ArtistsConverter {
    private static final java.lang.String DELIMITER_DASH = "<-->";
    private static final java.lang.String DELIMITER_COMMA = ":::";
    @org.jetbrains.annotations.NotNull()
    public static final com.kvlg.shared.data.db.ArtistsConverter INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public static final java.lang.String fromList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.kvlg.model.presentation.Artist> from) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public static final java.util.List<com.kvlg.model.presentation.Artist> fromString(@org.jetbrains.annotations.NotNull()
    java.lang.String string) {
        return null;
    }
    
    private ArtistsConverter() {
        super();
    }
}