package com.kvlg.shared.data.db.album;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kvlg.model.presentation.Track;
import com.kvlg.shared.data.db.TrackIdConverter;
import com.kvlg.shared.data.db.artists.ArtistEntity;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
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

  private final SharedSQLiteStatement __preparedStmtOfUpdateAlbumTracks;

  public AlbumDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlbumEntity = new EntityInsertionAdapter<AlbumEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `albums` (`spotify_id`,`artist_id`,`name`,`track_ids`,`image_url`,`release_date`,`isFavorite`,`mspotify_id`,`mname`,`mimage_url`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AlbumEntity value) {
        if (value.getSpotifyId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSpotifyId());
        }
        if (value.getArtistId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getArtistId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        final String _tmp;
        _tmp = TrackIdConverter.fromList(value.getTrackIds());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImageUrl());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReleaseDate());
        }
        final int _tmp_1;
        _tmp_1 = value.isFavorite() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        final ArtistEntity _tmpArtist = value.getArtist();
        if(_tmpArtist != null) {
          if (_tmpArtist.getSpotifyId() == null) {
            stmt.bindNull(8);
          } else {
            stmt.bindString(8, _tmpArtist.getSpotifyId());
          }
          if (_tmpArtist.getName() == null) {
            stmt.bindNull(9);
          } else {
            stmt.bindString(9, _tmpArtist.getName());
          }
          if (_tmpArtist.getImageUrl() == null) {
            stmt.bindNull(10);
          } else {
            stmt.bindString(10, _tmpArtist.getImageUrl());
          }
        } else {
          stmt.bindNull(8);
          stmt.bindNull(9);
          stmt.bindNull(10);
        }
      }
    };
    this.__updateAdapterOfAlbumEntity = new EntityDeletionOrUpdateAdapter<AlbumEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `albums` SET `spotify_id` = ?,`artist_id` = ?,`name` = ?,`track_ids` = ?,`image_url` = ?,`release_date` = ?,`isFavorite` = ?,`mspotify_id` = ?,`mname` = ?,`mimage_url` = ? WHERE `spotify_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AlbumEntity value) {
        if (value.getSpotifyId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSpotifyId());
        }
        if (value.getArtistId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getArtistId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        final String _tmp;
        _tmp = TrackIdConverter.fromList(value.getTrackIds());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImageUrl());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReleaseDate());
        }
        final int _tmp_1;
        _tmp_1 = value.isFavorite() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        final ArtistEntity _tmpArtist = value.getArtist();
        if(_tmpArtist != null) {
          if (_tmpArtist.getSpotifyId() == null) {
            stmt.bindNull(8);
          } else {
            stmt.bindString(8, _tmpArtist.getSpotifyId());
          }
          if (_tmpArtist.getName() == null) {
            stmt.bindNull(9);
          } else {
            stmt.bindString(9, _tmpArtist.getName());
          }
          if (_tmpArtist.getImageUrl() == null) {
            stmt.bindNull(10);
          } else {
            stmt.bindString(10, _tmpArtist.getImageUrl());
          }
        } else {
          stmt.bindNull(8);
          stmt.bindNull(9);
          stmt.bindNull(10);
        }
        if (value.getSpotifyId() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getSpotifyId());
        }
      }
    };
    this.__preparedStmtOfUpdateAlbumTracks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE albums SET track_ids =? WHERE spotify_id =?";
        return _query;
      }
    };
  }

  @Override
  public void insertAlbum(final AlbumEntity albumEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAlbumEntity.insert(albumEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
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
  public void updateAlbum(final AlbumEntity albumEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAlbumEntity.handle(albumEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAlbumTracks(final String id, final List<Track> tracks) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAlbumTracks.acquire();
    int _argIndex = 1;
    final String _tmp;
    _tmp = TrackIdConverter.fromList(tracks);
    if (_tmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, _tmp);
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
      __preparedStmtOfUpdateAlbumTracks.release(_stmt);
    }
  }

  @Override
  public List<AlbumEntity> getAlbums() {
    final String _sql = "SELECT * FROM albums ORDER BY release_date DESC LIMIT 50";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "spotify_id");
      final int _cursorIndexOfArtistId = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfTrackIds = CursorUtil.getColumnIndexOrThrow(_cursor, "track_ids");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
      final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
      final int _cursorIndexOfSpotifyId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mspotify_id");
      final int _cursorIndexOfName_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mname");
      final int _cursorIndexOfImageUrl_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mimage_url");
      final List<AlbumEntity> _result = new ArrayList<AlbumEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AlbumEntity _item;
        final String _tmpSpotifyId;
        _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
        final String _tmpArtistId;
        _tmpArtistId = _cursor.getString(_cursorIndexOfArtistId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final List<Track> _tmpTrackIds;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfTrackIds);
        _tmpTrackIds = TrackIdConverter.fromString(_tmp);
        final String _tmpImageUrl;
        _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        final String _tmpReleaseDate;
        _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
        final boolean _tmpIsFavorite;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp_1 != 0;
        final ArtistEntity _tmpArtist;
        if (! (_cursor.isNull(_cursorIndexOfSpotifyId_1) && _cursor.isNull(_cursorIndexOfName_1) && _cursor.isNull(_cursorIndexOfImageUrl_1))) {
          final String _tmpSpotifyId_1;
          _tmpSpotifyId_1 = _cursor.getString(_cursorIndexOfSpotifyId_1);
          final String _tmpName_1;
          _tmpName_1 = _cursor.getString(_cursorIndexOfName_1);
          final String _tmpImageUrl_1;
          _tmpImageUrl_1 = _cursor.getString(_cursorIndexOfImageUrl_1);
          _tmpArtist = new ArtistEntity(_tmpSpotifyId_1,_tmpName_1,_tmpImageUrl_1);
        }  else  {
          _tmpArtist = null;
        }
        _item = new AlbumEntity(_tmpSpotifyId,_tmpArtistId,_tmpArtist,_tmpName,_tmpTrackIds,_tmpImageUrl,_tmpReleaseDate,_tmpIsFavorite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AlbumEntity> getAlbumsByKeyword(final String key) {
    final String _sql = "SELECT * FROM albums WHERE name LIKE '%' || ? || '%' OR mname LIKE '%' || ? || '%'";
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
      final int _cursorIndexOfArtistId = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfTrackIds = CursorUtil.getColumnIndexOrThrow(_cursor, "track_ids");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
      final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
      final int _cursorIndexOfSpotifyId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mspotify_id");
      final int _cursorIndexOfName_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mname");
      final int _cursorIndexOfImageUrl_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mimage_url");
      final List<AlbumEntity> _result = new ArrayList<AlbumEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AlbumEntity _item;
        final String _tmpSpotifyId;
        _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
        final String _tmpArtistId;
        _tmpArtistId = _cursor.getString(_cursorIndexOfArtistId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final List<Track> _tmpTrackIds;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfTrackIds);
        _tmpTrackIds = TrackIdConverter.fromString(_tmp);
        final String _tmpImageUrl;
        _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        final String _tmpReleaseDate;
        _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
        final boolean _tmpIsFavorite;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp_1 != 0;
        final ArtistEntity _tmpArtist;
        if (! (_cursor.isNull(_cursorIndexOfSpotifyId_1) && _cursor.isNull(_cursorIndexOfName_1) && _cursor.isNull(_cursorIndexOfImageUrl_1))) {
          final String _tmpSpotifyId_1;
          _tmpSpotifyId_1 = _cursor.getString(_cursorIndexOfSpotifyId_1);
          final String _tmpName_1;
          _tmpName_1 = _cursor.getString(_cursorIndexOfName_1);
          final String _tmpImageUrl_1;
          _tmpImageUrl_1 = _cursor.getString(_cursorIndexOfImageUrl_1);
          _tmpArtist = new ArtistEntity(_tmpSpotifyId_1,_tmpName_1,_tmpImageUrl_1);
        }  else  {
          _tmpArtist = null;
        }
        _item = new AlbumEntity(_tmpSpotifyId,_tmpArtistId,_tmpArtist,_tmpName,_tmpTrackIds,_tmpImageUrl,_tmpReleaseDate,_tmpIsFavorite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AlbumEntity getAlbumById(final String id) {
    final String _sql = "SELECT * FROM albums WHERE spotify_id = ?";
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
      final int _cursorIndexOfArtistId = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfTrackIds = CursorUtil.getColumnIndexOrThrow(_cursor, "track_ids");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
      final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
      final int _cursorIndexOfSpotifyId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mspotify_id");
      final int _cursorIndexOfName_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mname");
      final int _cursorIndexOfImageUrl_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mimage_url");
      final AlbumEntity _result;
      if(_cursor.moveToFirst()) {
        final String _tmpSpotifyId;
        _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
        final String _tmpArtistId;
        _tmpArtistId = _cursor.getString(_cursorIndexOfArtistId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final List<Track> _tmpTrackIds;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfTrackIds);
        _tmpTrackIds = TrackIdConverter.fromString(_tmp);
        final String _tmpImageUrl;
        _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        final String _tmpReleaseDate;
        _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
        final boolean _tmpIsFavorite;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp_1 != 0;
        final ArtistEntity _tmpArtist;
        if (! (_cursor.isNull(_cursorIndexOfSpotifyId_1) && _cursor.isNull(_cursorIndexOfName_1) && _cursor.isNull(_cursorIndexOfImageUrl_1))) {
          final String _tmpSpotifyId_1;
          _tmpSpotifyId_1 = _cursor.getString(_cursorIndexOfSpotifyId_1);
          final String _tmpName_1;
          _tmpName_1 = _cursor.getString(_cursorIndexOfName_1);
          final String _tmpImageUrl_1;
          _tmpImageUrl_1 = _cursor.getString(_cursorIndexOfImageUrl_1);
          _tmpArtist = new ArtistEntity(_tmpSpotifyId_1,_tmpName_1,_tmpImageUrl_1);
        }  else  {
          _tmpArtist = null;
        }
        _result = new AlbumEntity(_tmpSpotifyId,_tmpArtistId,_tmpArtist,_tmpName,_tmpTrackIds,_tmpImageUrl,_tmpReleaseDate,_tmpIsFavorite);
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
  public LiveData<List<AlbumEntity>> getAlbumsByArtistId(final String id) {
    final String _sql = "SELECT * FROM albums WHERE artist_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"albums"}, false, new Callable<List<AlbumEntity>>() {
      @Override
      public List<AlbumEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "spotify_id");
          final int _cursorIndexOfArtistId = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfTrackIds = CursorUtil.getColumnIndexOrThrow(_cursor, "track_ids");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfSpotifyId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mspotify_id");
          final int _cursorIndexOfName_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mname");
          final int _cursorIndexOfImageUrl_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mimage_url");
          final List<AlbumEntity> _result = new ArrayList<AlbumEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlbumEntity _item;
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final String _tmpArtistId;
            _tmpArtistId = _cursor.getString(_cursorIndexOfArtistId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final List<Track> _tmpTrackIds;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfTrackIds);
            _tmpTrackIds = TrackIdConverter.fromString(_tmp);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final ArtistEntity _tmpArtist;
            if (! (_cursor.isNull(_cursorIndexOfSpotifyId_1) && _cursor.isNull(_cursorIndexOfName_1) && _cursor.isNull(_cursorIndexOfImageUrl_1))) {
              final String _tmpSpotifyId_1;
              _tmpSpotifyId_1 = _cursor.getString(_cursorIndexOfSpotifyId_1);
              final String _tmpName_1;
              _tmpName_1 = _cursor.getString(_cursorIndexOfName_1);
              final String _tmpImageUrl_1;
              _tmpImageUrl_1 = _cursor.getString(_cursorIndexOfImageUrl_1);
              _tmpArtist = new ArtistEntity(_tmpSpotifyId_1,_tmpName_1,_tmpImageUrl_1);
            }  else  {
              _tmpArtist = null;
            }
            _item = new AlbumEntity(_tmpSpotifyId,_tmpArtistId,_tmpArtist,_tmpName,_tmpTrackIds,_tmpImageUrl,_tmpReleaseDate,_tmpIsFavorite);
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
  public List<AlbumEntity> loadFavoriteAlbums() {
    final String _sql = "SELECT * FROM albums WHERE isFavorite = 1 ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "spotify_id");
      final int _cursorIndexOfArtistId = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfTrackIds = CursorUtil.getColumnIndexOrThrow(_cursor, "track_ids");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
      final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
      final int _cursorIndexOfSpotifyId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mspotify_id");
      final int _cursorIndexOfName_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mname");
      final int _cursorIndexOfImageUrl_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "mimage_url");
      final List<AlbumEntity> _result = new ArrayList<AlbumEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AlbumEntity _item;
        final String _tmpSpotifyId;
        _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
        final String _tmpArtistId;
        _tmpArtistId = _cursor.getString(_cursorIndexOfArtistId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final List<Track> _tmpTrackIds;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfTrackIds);
        _tmpTrackIds = TrackIdConverter.fromString(_tmp);
        final String _tmpImageUrl;
        _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        final String _tmpReleaseDate;
        _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
        final boolean _tmpIsFavorite;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp_1 != 0;
        final ArtistEntity _tmpArtist;
        if (! (_cursor.isNull(_cursorIndexOfSpotifyId_1) && _cursor.isNull(_cursorIndexOfName_1) && _cursor.isNull(_cursorIndexOfImageUrl_1))) {
          final String _tmpSpotifyId_1;
          _tmpSpotifyId_1 = _cursor.getString(_cursorIndexOfSpotifyId_1);
          final String _tmpName_1;
          _tmpName_1 = _cursor.getString(_cursorIndexOfName_1);
          final String _tmpImageUrl_1;
          _tmpImageUrl_1 = _cursor.getString(_cursorIndexOfImageUrl_1);
          _tmpArtist = new ArtistEntity(_tmpSpotifyId_1,_tmpName_1,_tmpImageUrl_1);
        }  else  {
          _tmpArtist = null;
        }
        _item = new AlbumEntity(_tmpSpotifyId,_tmpArtistId,_tmpArtist,_tmpName,_tmpTrackIds,_tmpImageUrl,_tmpReleaseDate,_tmpIsFavorite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
