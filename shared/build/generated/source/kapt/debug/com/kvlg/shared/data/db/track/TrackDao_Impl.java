package com.kvlg.shared.data.db.track;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kvlg.model.presentation.Artist;
import com.kvlg.shared.data.db.ArtistsConverter;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TrackDao_Impl implements TrackDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TrackEntity> __insertionAdapterOfTrackEntity;

  private final EntityDeletionOrUpdateAdapter<TrackEntity> __updateAdapterOfTrackEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTrackLyrics;

  public TrackDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrackEntity = new EntityInsertionAdapter<TrackEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `tracks` (`spotify_id`,`name`,`album_id`,`lyrics`,`artists`,`isFavorite`,`image_url`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TrackEntity value) {
        if (value.getSpotifyId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSpotifyId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAlbumId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlbumId());
        }
        if (value.getLyrics() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLyrics());
        }
        final String _tmp;
        _tmp = ArtistsConverter.fromList(value.getArtists());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp);
        }
        final int _tmp_1;
        _tmp_1 = value.isFavorite() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        if (value.getImage_url() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImage_url());
        }
      }
    };
    this.__updateAdapterOfTrackEntity = new EntityDeletionOrUpdateAdapter<TrackEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR IGNORE `tracks` SET `spotify_id` = ?,`name` = ?,`album_id` = ?,`lyrics` = ?,`artists` = ?,`isFavorite` = ?,`image_url` = ? WHERE `spotify_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TrackEntity value) {
        if (value.getSpotifyId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSpotifyId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAlbumId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlbumId());
        }
        if (value.getLyrics() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLyrics());
        }
        final String _tmp;
        _tmp = ArtistsConverter.fromList(value.getArtists());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp);
        }
        final int _tmp_1;
        _tmp_1 = value.isFavorite() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        if (value.getImage_url() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImage_url());
        }
        if (value.getSpotifyId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSpotifyId());
        }
      }
    };
    this.__preparedStmtOfUpdateTrackLyrics = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE tracks SET lyrics = ? WHERE spotify_id=?";
        return _query;
      }
    };
  }

  @Override
  public void insertTrack(final TrackEntity trackEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrackEntity.insert(trackEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTrack(final TrackEntity trackEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTrackEntity.handle(trackEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTrackLyrics(final String id, final String lyrics) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTrackLyrics.acquire();
    int _argIndex = 1;
    if (lyrics == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, lyrics);
    }
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
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateTrackLyrics.release(_stmt);
    }
  }

  @Override
  public TrackEntity getTrackById(final String id) {
    final String _sql = "SELECT * FROM tracks WHERE spotify_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "spotify_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAlbumId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
      final int _cursorIndexOfLyrics = CursorUtil.getColumnIndexOrThrow(_cursor, "lyrics");
      final int _cursorIndexOfArtists = CursorUtil.getColumnIndexOrThrow(_cursor, "artists");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
      final TrackEntity _result;
      if(_cursor.moveToFirst()) {
        final String _tmpSpotifyId;
        _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpAlbumId;
        _tmpAlbumId = _cursor.getString(_cursorIndexOfAlbumId);
        final String _tmpLyrics;
        _tmpLyrics = _cursor.getString(_cursorIndexOfLyrics);
        final List<Artist> _tmpArtists;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfArtists);
        _tmpArtists = ArtistsConverter.fromString(_tmp);
        final boolean _tmpIsFavorite;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp_1 != 0;
        final String _tmpImage_url;
        _tmpImage_url = _cursor.getString(_cursorIndexOfImageUrl);
        _result = new TrackEntity(_tmpSpotifyId,_tmpName,_tmpAlbumId,_tmpLyrics,_tmpArtists,_tmpIsFavorite,_tmpImage_url);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<TrackEntity>> getTracksByAlbumId(final String id) {
    final String _sql = "SELECT * FROM tracks WHERE album_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"tracks"}, false, new Callable<List<TrackEntity>>() {
      @Override
      public List<TrackEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "spotify_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAlbumId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
          final int _cursorIndexOfLyrics = CursorUtil.getColumnIndexOrThrow(_cursor, "lyrics");
          final int _cursorIndexOfArtists = CursorUtil.getColumnIndexOrThrow(_cursor, "artists");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final List<TrackEntity> _result = new ArrayList<TrackEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TrackEntity _item;
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpAlbumId;
            _tmpAlbumId = _cursor.getString(_cursorIndexOfAlbumId);
            final String _tmpLyrics;
            _tmpLyrics = _cursor.getString(_cursorIndexOfLyrics);
            final List<Artist> _tmpArtists;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtists);
            _tmpArtists = ArtistsConverter.fromString(_tmp);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final String _tmpImage_url;
            _tmpImage_url = _cursor.getString(_cursorIndexOfImageUrl);
            _item = new TrackEntity(_tmpSpotifyId,_tmpName,_tmpAlbumId,_tmpLyrics,_tmpArtists,_tmpIsFavorite,_tmpImage_url);
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
  public List<TrackEntity> getTracksByKeyword(final String key) {
    final String _sql = "SELECT * FROM tracks WHERE name LIKE '%' || ? || '%' OR artists LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (key == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, key);
    }
    _argIndex = 2;
    if (key == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, key);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "spotify_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAlbumId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
      final int _cursorIndexOfLyrics = CursorUtil.getColumnIndexOrThrow(_cursor, "lyrics");
      final int _cursorIndexOfArtists = CursorUtil.getColumnIndexOrThrow(_cursor, "artists");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
      final List<TrackEntity> _result = new ArrayList<TrackEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TrackEntity _item;
        final String _tmpSpotifyId;
        _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpAlbumId;
        _tmpAlbumId = _cursor.getString(_cursorIndexOfAlbumId);
        final String _tmpLyrics;
        _tmpLyrics = _cursor.getString(_cursorIndexOfLyrics);
        final List<Artist> _tmpArtists;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfArtists);
        _tmpArtists = ArtistsConverter.fromString(_tmp);
        final boolean _tmpIsFavorite;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp_1 != 0;
        final String _tmpImage_url;
        _tmpImage_url = _cursor.getString(_cursorIndexOfImageUrl);
        _item = new TrackEntity(_tmpSpotifyId,_tmpName,_tmpAlbumId,_tmpLyrics,_tmpArtists,_tmpIsFavorite,_tmpImage_url);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<TrackEntity> loadFavoriteTracks() {
    final String _sql = "SELECT * FROM tracks WHERE isFavorite = 1 ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "spotify_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAlbumId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
      final int _cursorIndexOfLyrics = CursorUtil.getColumnIndexOrThrow(_cursor, "lyrics");
      final int _cursorIndexOfArtists = CursorUtil.getColumnIndexOrThrow(_cursor, "artists");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
      final List<TrackEntity> _result = new ArrayList<TrackEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TrackEntity _item;
        final String _tmpSpotifyId;
        _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpAlbumId;
        _tmpAlbumId = _cursor.getString(_cursorIndexOfAlbumId);
        final String _tmpLyrics;
        _tmpLyrics = _cursor.getString(_cursorIndexOfLyrics);
        final List<Artist> _tmpArtists;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfArtists);
        _tmpArtists = ArtistsConverter.fromString(_tmp);
        final boolean _tmpIsFavorite;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp_1 != 0;
        final String _tmpImage_url;
        _tmpImage_url = _cursor.getString(_cursorIndexOfImageUrl);
        _item = new TrackEntity(_tmpSpotifyId,_tmpName,_tmpAlbumId,_tmpLyrics,_tmpArtists,_tmpIsFavorite,_tmpImage_url);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
