package com.example.sberify.data.db.album;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.sberify.data.db.ListToStringConverter;
import com.example.sberify.data.db.artists.ArtistEntity;
import com.example.sberify.data.db.track.TrackEntity;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AlbumDao_Impl implements AlbumDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AlbumEntity> __insertionAdapterOfAlbumEntity;

  private final EntityDeletionOrUpdateAdapter<AlbumEntity> __updateAdapterOfAlbumEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAlbum;

  public AlbumDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlbumEntity = new EntityInsertionAdapter<AlbumEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `albums` (`album_id`,`artist_ids`,`name`,`image_url`,`release_date`,`release_date_precision`,`is_favorite`,`genres`,`total_tracks`,`external_url`,`copyrights`,`markets`,`type`,`label`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AlbumEntity value) {
        if (value.getSpotifyId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSpotifyId());
        }
        final String _tmp;
        _tmp = ListToStringConverter.fromList(value.getArtistIds());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImageUrl());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getReleaseDate());
        }
        if (value.getReleaseDatePrecision() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReleaseDatePrecision());
        }
        final int _tmp_1;
        _tmp_1 = value.isFavorite() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        final String _tmp_2;
        _tmp_2 = ListToStringConverter.fromList(value.getGenres());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_2);
        }
        stmt.bindLong(9, value.getTotalTracks());
        if (value.getExternalUrl() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getExternalUrl());
        }
        final String _tmp_3;
        _tmp_3 = ListToStringConverter.fromList(value.getCopyrights());
        if (_tmp_3 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp_3);
        }
        final String _tmp_4;
        _tmp_4 = ListToStringConverter.fromList(value.getMarkets());
        if (_tmp_4 == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, _tmp_4);
        }
        if (value.getType() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getType());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getLabel());
        }
      }
    };
    this.__updateAdapterOfAlbumEntity = new EntityDeletionOrUpdateAdapter<AlbumEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `albums` SET `album_id` = ?,`artist_ids` = ?,`name` = ?,`image_url` = ?,`release_date` = ?,`release_date_precision` = ?,`is_favorite` = ?,`genres` = ?,`total_tracks` = ?,`external_url` = ?,`copyrights` = ?,`markets` = ?,`type` = ?,`label` = ? WHERE `album_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AlbumEntity value) {
        if (value.getSpotifyId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSpotifyId());
        }
        final String _tmp;
        _tmp = ListToStringConverter.fromList(value.getArtistIds());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImageUrl());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getReleaseDate());
        }
        if (value.getReleaseDatePrecision() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReleaseDatePrecision());
        }
        final int _tmp_1;
        _tmp_1 = value.isFavorite() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        final String _tmp_2;
        _tmp_2 = ListToStringConverter.fromList(value.getGenres());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_2);
        }
        stmt.bindLong(9, value.getTotalTracks());
        if (value.getExternalUrl() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getExternalUrl());
        }
        final String _tmp_3;
        _tmp_3 = ListToStringConverter.fromList(value.getCopyrights());
        if (_tmp_3 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp_3);
        }
        final String _tmp_4;
        _tmp_4 = ListToStringConverter.fromList(value.getMarkets());
        if (_tmp_4 == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, _tmp_4);
        }
        if (value.getType() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getType());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getLabel());
        }
        if (value.getSpotifyId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSpotifyId());
        }
      }
    };
    this.__preparedStmtOfUpdateAlbum = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE albums SET is_favorite = ? WHERE album_id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertAlbum(final AlbumEntity albumEntity, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAlbumEntity.insert(albumEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateAlbumTracks(final AlbumEntity albumEntity,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAlbumEntity.handle(albumEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateAlbum(final String id, final boolean isFavorite,
      final Continuation<? super Unit> p2) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAlbum.acquire();
        int _argIndex = 1;
        final int _tmp;
        _tmp = isFavorite ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdateAlbum.release(_stmt);
        }
      }
    }, p2);
  }

  @Override
  public LiveData<List<AlbumEntity>> getAlbums() {
    final String _sql = "SELECT * FROM albums ORDER BY release_date DESC LIMIT 50";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"albums"}, false, new Callable<List<AlbumEntity>>() {
      @Override
      public List<AlbumEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
          final int _cursorIndexOfArtistIds = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_ids");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfReleaseDatePrecision = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date_precision");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
          final int _cursorIndexOfTotalTracks = CursorUtil.getColumnIndexOrThrow(_cursor, "total_tracks");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final int _cursorIndexOfCopyrights = CursorUtil.getColumnIndexOrThrow(_cursor, "copyrights");
          final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final List<AlbumEntity> _result = new ArrayList<AlbumEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlbumEntity _item;
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final List<String> _tmpArtistIds;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistIds);
            _tmpArtistIds = ListToStringConverter.fromString(_tmp);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpReleaseDatePrecision;
            _tmpReleaseDatePrecision = _cursor.getString(_cursorIndexOfReleaseDatePrecision);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final List<String> _tmpGenres;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfGenres);
            _tmpGenres = ListToStringConverter.fromString(_tmp_2);
            final int _tmpTotalTracks;
            _tmpTotalTracks = _cursor.getInt(_cursorIndexOfTotalTracks);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            final List<String> _tmpCopyrights;
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfCopyrights);
            _tmpCopyrights = ListToStringConverter.fromString(_tmp_3);
            final List<String> _tmpMarkets;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpLabel;
            _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            _item = new AlbumEntity(_tmpSpotifyId,_tmpArtistIds,_tmpName,_tmpImageUrl,_tmpReleaseDate,_tmpReleaseDatePrecision,_tmpIsFavorite,_tmpGenres,_tmpTotalTracks,_tmpExternalUrl,_tmpCopyrights,_tmpMarkets,_tmpType,_tmpLabel);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<AlbumEntity>> getAlbumsByKeyword(final String key) {
    final String _sql = "SELECT * FROM albums WHERE name LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (key == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, key);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"albums"}, false, new Callable<List<AlbumEntity>>() {
      @Override
      public List<AlbumEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
          final int _cursorIndexOfArtistIds = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_ids");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfReleaseDatePrecision = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date_precision");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
          final int _cursorIndexOfTotalTracks = CursorUtil.getColumnIndexOrThrow(_cursor, "total_tracks");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final int _cursorIndexOfCopyrights = CursorUtil.getColumnIndexOrThrow(_cursor, "copyrights");
          final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final List<AlbumEntity> _result = new ArrayList<AlbumEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlbumEntity _item;
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final List<String> _tmpArtistIds;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistIds);
            _tmpArtistIds = ListToStringConverter.fromString(_tmp);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpReleaseDatePrecision;
            _tmpReleaseDatePrecision = _cursor.getString(_cursorIndexOfReleaseDatePrecision);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final List<String> _tmpGenres;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfGenres);
            _tmpGenres = ListToStringConverter.fromString(_tmp_2);
            final int _tmpTotalTracks;
            _tmpTotalTracks = _cursor.getInt(_cursorIndexOfTotalTracks);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            final List<String> _tmpCopyrights;
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfCopyrights);
            _tmpCopyrights = ListToStringConverter.fromString(_tmp_3);
            final List<String> _tmpMarkets;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpLabel;
            _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            _item = new AlbumEntity(_tmpSpotifyId,_tmpArtistIds,_tmpName,_tmpImageUrl,_tmpReleaseDate,_tmpReleaseDatePrecision,_tmpIsFavorite,_tmpGenres,_tmpTotalTracks,_tmpExternalUrl,_tmpCopyrights,_tmpMarkets,_tmpType,_tmpLabel);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<AlbumEntity> getAlbumById(final String id) {
    final String _sql = "SELECT * FROM albums WHERE album_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"albums"}, false, new Callable<AlbumEntity>() {
      @Override
      public AlbumEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
          final int _cursorIndexOfArtistIds = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_ids");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfReleaseDatePrecision = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date_precision");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
          final int _cursorIndexOfTotalTracks = CursorUtil.getColumnIndexOrThrow(_cursor, "total_tracks");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final int _cursorIndexOfCopyrights = CursorUtil.getColumnIndexOrThrow(_cursor, "copyrights");
          final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final AlbumEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final List<String> _tmpArtistIds;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistIds);
            _tmpArtistIds = ListToStringConverter.fromString(_tmp);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpReleaseDatePrecision;
            _tmpReleaseDatePrecision = _cursor.getString(_cursorIndexOfReleaseDatePrecision);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final List<String> _tmpGenres;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfGenres);
            _tmpGenres = ListToStringConverter.fromString(_tmp_2);
            final int _tmpTotalTracks;
            _tmpTotalTracks = _cursor.getInt(_cursorIndexOfTotalTracks);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            final List<String> _tmpCopyrights;
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfCopyrights);
            _tmpCopyrights = ListToStringConverter.fromString(_tmp_3);
            final List<String> _tmpMarkets;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpLabel;
            _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            _result = new AlbumEntity(_tmpSpotifyId,_tmpArtistIds,_tmpName,_tmpImageUrl,_tmpReleaseDate,_tmpReleaseDatePrecision,_tmpIsFavorite,_tmpGenres,_tmpTotalTracks,_tmpExternalUrl,_tmpCopyrights,_tmpMarkets,_tmpType,_tmpLabel);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<AlbumEntity>> loadFavoriteAlbums() {
    final String _sql = "SELECT * FROM albums WHERE is_favorite = 1 ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"albums"}, false, new Callable<List<AlbumEntity>>() {
      @Override
      public List<AlbumEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
          final int _cursorIndexOfArtistIds = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_ids");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfReleaseDatePrecision = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date_precision");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
          final int _cursorIndexOfTotalTracks = CursorUtil.getColumnIndexOrThrow(_cursor, "total_tracks");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final int _cursorIndexOfCopyrights = CursorUtil.getColumnIndexOrThrow(_cursor, "copyrights");
          final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final List<AlbumEntity> _result = new ArrayList<AlbumEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlbumEntity _item;
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final List<String> _tmpArtistIds;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistIds);
            _tmpArtistIds = ListToStringConverter.fromString(_tmp);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpReleaseDatePrecision;
            _tmpReleaseDatePrecision = _cursor.getString(_cursorIndexOfReleaseDatePrecision);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final List<String> _tmpGenres;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfGenres);
            _tmpGenres = ListToStringConverter.fromString(_tmp_2);
            final int _tmpTotalTracks;
            _tmpTotalTracks = _cursor.getInt(_cursorIndexOfTotalTracks);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            final List<String> _tmpCopyrights;
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfCopyrights);
            _tmpCopyrights = ListToStringConverter.fromString(_tmp_3);
            final List<String> _tmpMarkets;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpLabel;
            _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            _item = new AlbumEntity(_tmpSpotifyId,_tmpArtistIds,_tmpName,_tmpImageUrl,_tmpReleaseDate,_tmpReleaseDatePrecision,_tmpIsFavorite,_tmpGenres,_tmpTotalTracks,_tmpExternalUrl,_tmpCopyrights,_tmpMarkets,_tmpType,_tmpLabel);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<AlbumWithTracks> getAlbumTracks(final String id) {
    final String _sql = "SELECT * FROM albums WHERE album_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"tracks","albums"}, true, new Callable<AlbumWithTracks>() {
      @Override
      public AlbumWithTracks call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
            final int _cursorIndexOfArtistIds = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_ids");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
            final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
            final int _cursorIndexOfReleaseDatePrecision = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date_precision");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
            final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
            final int _cursorIndexOfTotalTracks = CursorUtil.getColumnIndexOrThrow(_cursor, "total_tracks");
            final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
            final int _cursorIndexOfCopyrights = CursorUtil.getColumnIndexOrThrow(_cursor, "copyrights");
            final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
            final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
            final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
            final ArrayMap<String, ArrayList<TrackEntity>> _collectionTracksEntities = new ArrayMap<String, ArrayList<TrackEntity>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfSpotifyId);
              ArrayList<TrackEntity> _tmpTracksEntitiesCollection = _collectionTracksEntities.get(_tmpKey);
              if (_tmpTracksEntitiesCollection == null) {
                _tmpTracksEntitiesCollection = new ArrayList<TrackEntity>();
                _collectionTracksEntities.put(_tmpKey, _tmpTracksEntitiesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiptracksAscomExampleSberifyDataDbTrackTrackEntity(_collectionTracksEntities);
            final AlbumWithTracks _result;
            if(_cursor.moveToFirst()) {
              final AlbumEntity _tmpAlbumEntity;
              if (! (_cursor.isNull(_cursorIndexOfSpotifyId) && _cursor.isNull(_cursorIndexOfArtistIds) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfImageUrl) && _cursor.isNull(_cursorIndexOfReleaseDate) && _cursor.isNull(_cursorIndexOfReleaseDatePrecision) && _cursor.isNull(_cursorIndexOfIsFavorite) && _cursor.isNull(_cursorIndexOfGenres) && _cursor.isNull(_cursorIndexOfTotalTracks) && _cursor.isNull(_cursorIndexOfExternalUrl) && _cursor.isNull(_cursorIndexOfCopyrights) && _cursor.isNull(_cursorIndexOfMarkets) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfLabel))) {
                final String _tmpSpotifyId;
                _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
                final List<String> _tmpArtistIds;
                final String _tmp;
                _tmp = _cursor.getString(_cursorIndexOfArtistIds);
                _tmpArtistIds = ListToStringConverter.fromString(_tmp);
                final String _tmpName;
                _tmpName = _cursor.getString(_cursorIndexOfName);
                final String _tmpImageUrl;
                _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
                final String _tmpReleaseDate;
                _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
                final String _tmpReleaseDatePrecision;
                _tmpReleaseDatePrecision = _cursor.getString(_cursorIndexOfReleaseDatePrecision);
                final boolean _tmpIsFavorite;
                final int _tmp_1;
                _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
                _tmpIsFavorite = _tmp_1 != 0;
                final List<String> _tmpGenres;
                final String _tmp_2;
                _tmp_2 = _cursor.getString(_cursorIndexOfGenres);
                _tmpGenres = ListToStringConverter.fromString(_tmp_2);
                final int _tmpTotalTracks;
                _tmpTotalTracks = _cursor.getInt(_cursorIndexOfTotalTracks);
                final String _tmpExternalUrl;
                _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
                final List<String> _tmpCopyrights;
                final String _tmp_3;
                _tmp_3 = _cursor.getString(_cursorIndexOfCopyrights);
                _tmpCopyrights = ListToStringConverter.fromString(_tmp_3);
                final List<String> _tmpMarkets;
                final String _tmp_4;
                _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
                _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
                final String _tmpType;
                _tmpType = _cursor.getString(_cursorIndexOfType);
                final String _tmpLabel;
                _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
                _tmpAlbumEntity = new AlbumEntity(_tmpSpotifyId,_tmpArtistIds,_tmpName,_tmpImageUrl,_tmpReleaseDate,_tmpReleaseDatePrecision,_tmpIsFavorite,_tmpGenres,_tmpTotalTracks,_tmpExternalUrl,_tmpCopyrights,_tmpMarkets,_tmpType,_tmpLabel);
              }  else  {
                _tmpAlbumEntity = null;
              }
              ArrayList<TrackEntity> _tmpTracksEntitiesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfSpotifyId);
              _tmpTracksEntitiesCollection_1 = _collectionTracksEntities.get(_tmpKey_1);
              if (_tmpTracksEntitiesCollection_1 == null) {
                _tmpTracksEntitiesCollection_1 = new ArrayList<TrackEntity>();
              }
              _result = new AlbumWithTracks(_tmpAlbumEntity,_tmpTracksEntitiesCollection_1);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<AlbumEntity>> getAllAlbums() {
    final String _sql = "SELECT * FROM albums ORDER BY release_date DESC LIMIT 50";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"albums"}, false, new Callable<List<AlbumEntity>>() {
      @Override
      public List<AlbumEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
          final int _cursorIndexOfArtistIds = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_ids");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfReleaseDatePrecision = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date_precision");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
          final int _cursorIndexOfTotalTracks = CursorUtil.getColumnIndexOrThrow(_cursor, "total_tracks");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final int _cursorIndexOfCopyrights = CursorUtil.getColumnIndexOrThrow(_cursor, "copyrights");
          final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final List<AlbumEntity> _result = new ArrayList<AlbumEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlbumEntity _item;
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final List<String> _tmpArtistIds;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistIds);
            _tmpArtistIds = ListToStringConverter.fromString(_tmp);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpReleaseDatePrecision;
            _tmpReleaseDatePrecision = _cursor.getString(_cursorIndexOfReleaseDatePrecision);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final List<String> _tmpGenres;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfGenres);
            _tmpGenres = ListToStringConverter.fromString(_tmp_2);
            final int _tmpTotalTracks;
            _tmpTotalTracks = _cursor.getInt(_cursorIndexOfTotalTracks);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            final List<String> _tmpCopyrights;
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfCopyrights);
            _tmpCopyrights = ListToStringConverter.fromString(_tmp_3);
            final List<String> _tmpMarkets;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpLabel;
            _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            _item = new AlbumEntity(_tmpSpotifyId,_tmpArtistIds,_tmpName,_tmpImageUrl,_tmpReleaseDate,_tmpReleaseDatePrecision,_tmpIsFavorite,_tmpGenres,_tmpTotalTracks,_tmpExternalUrl,_tmpCopyrights,_tmpMarkets,_tmpType,_tmpLabel);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<AlbumEntity>> getAlbumsByQuery(final String query) {
    final String _sql = "SELECT * FROM albums WHERE name LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"albums"}, false, new Callable<List<AlbumEntity>>() {
      @Override
      public List<AlbumEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
          final int _cursorIndexOfArtistIds = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_ids");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfReleaseDatePrecision = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date_precision");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
          final int _cursorIndexOfTotalTracks = CursorUtil.getColumnIndexOrThrow(_cursor, "total_tracks");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final int _cursorIndexOfCopyrights = CursorUtil.getColumnIndexOrThrow(_cursor, "copyrights");
          final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final List<AlbumEntity> _result = new ArrayList<AlbumEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlbumEntity _item;
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final List<String> _tmpArtistIds;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistIds);
            _tmpArtistIds = ListToStringConverter.fromString(_tmp);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpReleaseDatePrecision;
            _tmpReleaseDatePrecision = _cursor.getString(_cursorIndexOfReleaseDatePrecision);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final List<String> _tmpGenres;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfGenres);
            _tmpGenres = ListToStringConverter.fromString(_tmp_2);
            final int _tmpTotalTracks;
            _tmpTotalTracks = _cursor.getInt(_cursorIndexOfTotalTracks);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            final List<String> _tmpCopyrights;
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfCopyrights);
            _tmpCopyrights = ListToStringConverter.fromString(_tmp_3);
            final List<String> _tmpMarkets;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpLabel;
            _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            _item = new AlbumEntity(_tmpSpotifyId,_tmpArtistIds,_tmpName,_tmpImageUrl,_tmpReleaseDate,_tmpReleaseDatePrecision,_tmpIsFavorite,_tmpGenres,_tmpTotalTracks,_tmpExternalUrl,_tmpCopyrights,_tmpMarkets,_tmpType,_tmpLabel);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public AlbumWithArtists getArtistsByAlbumId(final String albumId) {
    final String _sql = "SELECT * FROM albums WHERE album_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (albumId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, albumId);
    }
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
        final int _cursorIndexOfArtistIds = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_ids");
        final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
        final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
        final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
        final int _cursorIndexOfReleaseDatePrecision = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date_precision");
        final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
        final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
        final int _cursorIndexOfTotalTracks = CursorUtil.getColumnIndexOrThrow(_cursor, "total_tracks");
        final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
        final int _cursorIndexOfCopyrights = CursorUtil.getColumnIndexOrThrow(_cursor, "copyrights");
        final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
        final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
        final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
        final ArrayMap<String, ArrayList<ArtistEntity>> _collectionArtistEntities = new ArrayMap<String, ArrayList<ArtistEntity>>();
        while (_cursor.moveToNext()) {
          final String _tmpKey = _cursor.getString(_cursorIndexOfSpotifyId);
          ArrayList<ArtistEntity> _tmpArtistEntitiesCollection = _collectionArtistEntities.get(_tmpKey);
          if (_tmpArtistEntitiesCollection == null) {
            _tmpArtistEntitiesCollection = new ArrayList<ArtistEntity>();
            _collectionArtistEntities.put(_tmpKey, _tmpArtistEntitiesCollection);
          }
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshipartistsAscomExampleSberifyDataDbArtistsArtistEntity(_collectionArtistEntities);
        final AlbumWithArtists _result;
        if(_cursor.moveToFirst()) {
          final AlbumEntity _tmpAlbumEntity;
          if (! (_cursor.isNull(_cursorIndexOfSpotifyId) && _cursor.isNull(_cursorIndexOfArtistIds) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfImageUrl) && _cursor.isNull(_cursorIndexOfReleaseDate) && _cursor.isNull(_cursorIndexOfReleaseDatePrecision) && _cursor.isNull(_cursorIndexOfIsFavorite) && _cursor.isNull(_cursorIndexOfGenres) && _cursor.isNull(_cursorIndexOfTotalTracks) && _cursor.isNull(_cursorIndexOfExternalUrl) && _cursor.isNull(_cursorIndexOfCopyrights) && _cursor.isNull(_cursorIndexOfMarkets) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfLabel))) {
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final List<String> _tmpArtistIds;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistIds);
            _tmpArtistIds = ListToStringConverter.fromString(_tmp);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpReleaseDatePrecision;
            _tmpReleaseDatePrecision = _cursor.getString(_cursorIndexOfReleaseDatePrecision);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final List<String> _tmpGenres;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfGenres);
            _tmpGenres = ListToStringConverter.fromString(_tmp_2);
            final int _tmpTotalTracks;
            _tmpTotalTracks = _cursor.getInt(_cursorIndexOfTotalTracks);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            final List<String> _tmpCopyrights;
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfCopyrights);
            _tmpCopyrights = ListToStringConverter.fromString(_tmp_3);
            final List<String> _tmpMarkets;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpLabel;
            _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            _tmpAlbumEntity = new AlbumEntity(_tmpSpotifyId,_tmpArtistIds,_tmpName,_tmpImageUrl,_tmpReleaseDate,_tmpReleaseDatePrecision,_tmpIsFavorite,_tmpGenres,_tmpTotalTracks,_tmpExternalUrl,_tmpCopyrights,_tmpMarkets,_tmpType,_tmpLabel);
          }  else  {
            _tmpAlbumEntity = null;
          }
          ArrayList<ArtistEntity> _tmpArtistEntitiesCollection_1 = null;
          final String _tmpKey_1 = _cursor.getString(_cursorIndexOfSpotifyId);
          _tmpArtistEntitiesCollection_1 = _collectionArtistEntities.get(_tmpKey_1);
          if (_tmpArtistEntitiesCollection_1 == null) {
            _tmpArtistEntitiesCollection_1 = new ArrayList<ArtistEntity>();
          }
          _result = new AlbumWithArtists(_tmpAlbumEntity,_tmpArtistEntitiesCollection_1);
        } else {
          _result = null;
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }

  private void __fetchRelationshiptracksAscomExampleSberifyDataDbTrackTrackEntity(
      final ArrayMap<String, ArrayList<TrackEntity>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      ArrayMap<String, ArrayList<TrackEntity>> _tmpInnerMap = new ArrayMap<String, ArrayList<TrackEntity>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshiptracksAscomExampleSberifyDataDbTrackTrackEntity(_tmpInnerMap);
          _tmpInnerMap = new ArrayMap<String, ArrayList<TrackEntity>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshiptracksAscomExampleSberifyDataDbTrackTrackEntity(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `track_id`,`name`,`album_id`,`lyrics`,`artists_id`,`is_favorite`,`image_url`,`external_url`,`is_explicit`,`is_local`,`markets` FROM `tracks` WHERE `track_id` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      if (_item == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "track_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndex(_cursor, "track_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndex(_cursor, "name");
      final int _cursorIndexOfAlbumId = CursorUtil.getColumnIndex(_cursor, "album_id");
      final int _cursorIndexOfLyrics = CursorUtil.getColumnIndex(_cursor, "lyrics");
      final int _cursorIndexOfArtistsId = CursorUtil.getColumnIndex(_cursor, "artists_id");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndex(_cursor, "is_favorite");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndex(_cursor, "image_url");
      final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndex(_cursor, "external_url");
      final int _cursorIndexOfIsExplicit = CursorUtil.getColumnIndex(_cursor, "is_explicit");
      final int _cursorIndexOfIsLocal = CursorUtil.getColumnIndex(_cursor, "is_local");
      final int _cursorIndexOfMarkets = CursorUtil.getColumnIndex(_cursor, "markets");
      while(_cursor.moveToNext()) {
        final String _tmpKey = _cursor.getString(_itemKeyIndex);
        ArrayList<TrackEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final TrackEntity _item_1;
          final String _tmpSpotifyId;
          if (_cursorIndexOfSpotifyId == -1) {
            _tmpSpotifyId = null;
          } else {
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
          }
          final String _tmpName;
          if (_cursorIndexOfName == -1) {
            _tmpName = null;
          } else {
            _tmpName = _cursor.getString(_cursorIndexOfName);
          }
          final String _tmpAlbumId;
          if (_cursorIndexOfAlbumId == -1) {
            _tmpAlbumId = null;
          } else {
            _tmpAlbumId = _cursor.getString(_cursorIndexOfAlbumId);
          }
          final String _tmpLyrics;
          if (_cursorIndexOfLyrics == -1) {
            _tmpLyrics = null;
          } else {
            _tmpLyrics = _cursor.getString(_cursorIndexOfLyrics);
          }
          final List<String> _tmpArtistsId;
          if (_cursorIndexOfArtistsId == -1) {
            _tmpArtistsId = null;
          } else {
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistsId);
            _tmpArtistsId = ListToStringConverter.fromString(_tmp);
          }
          final boolean _tmpIsFavorite;
          if (_cursorIndexOfIsFavorite == -1) {
            _tmpIsFavorite = false;
          } else {
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
          }
          final String _tmpImageUrl;
          if (_cursorIndexOfImageUrl == -1) {
            _tmpImageUrl = null;
          } else {
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
          }
          final String _tmpExternalUrl;
          if (_cursorIndexOfExternalUrl == -1) {
            _tmpExternalUrl = null;
          } else {
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
          }
          final boolean _tmpIsExplicit;
          if (_cursorIndexOfIsExplicit == -1) {
            _tmpIsExplicit = false;
          } else {
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsExplicit);
            _tmpIsExplicit = _tmp_2 != 0;
          }
          final boolean _tmpIsLocal;
          if (_cursorIndexOfIsLocal == -1) {
            _tmpIsLocal = false;
          } else {
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsLocal);
            _tmpIsLocal = _tmp_3 != 0;
          }
          final List<String> _tmpMarkets;
          if (_cursorIndexOfMarkets == -1) {
            _tmpMarkets = null;
          } else {
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
          }
          _item_1 = new TrackEntity(_tmpSpotifyId,_tmpName,_tmpAlbumId,_tmpLyrics,_tmpArtistsId,_tmpIsFavorite,_tmpImageUrl,_tmpExternalUrl,_tmpIsExplicit,_tmpIsLocal,_tmpMarkets);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private void __fetchRelationshipartistsAscomExampleSberifyDataDbArtistsArtistEntity(
      final ArrayMap<String, ArrayList<ArtistEntity>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      ArrayMap<String, ArrayList<ArtistEntity>> _tmpInnerMap = new ArrayMap<String, ArrayList<ArtistEntity>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipartistsAscomExampleSberifyDataDbArtistsArtistEntity(_tmpInnerMap);
          _tmpInnerMap = new ArrayMap<String, ArrayList<ArtistEntity>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipartistsAscomExampleSberifyDataDbArtistsArtistEntity(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `artist_id`,`name`,`image_url`,`external_url` FROM `artists` WHERE `artist_id` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      if (_item == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "artist_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndex(_cursor, "artist_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndex(_cursor, "name");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndex(_cursor, "image_url");
      final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndex(_cursor, "external_url");
      while(_cursor.moveToNext()) {
        final String _tmpKey = _cursor.getString(_itemKeyIndex);
        ArrayList<ArtistEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final ArtistEntity _item_1;
          final String _tmpSpotifyId;
          if (_cursorIndexOfSpotifyId == -1) {
            _tmpSpotifyId = null;
          } else {
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
          }
          final String _tmpName;
          if (_cursorIndexOfName == -1) {
            _tmpName = null;
          } else {
            _tmpName = _cursor.getString(_cursorIndexOfName);
          }
          final String _tmpImageUrl;
          if (_cursorIndexOfImageUrl == -1) {
            _tmpImageUrl = null;
          } else {
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
          }
          final String _tmpExternalUrl;
          if (_cursorIndexOfExternalUrl == -1) {
            _tmpExternalUrl = null;
          } else {
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
          }
          _item_1 = new ArtistEntity(_tmpSpotifyId,_tmpName,_tmpImageUrl,_tmpExternalUrl);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
