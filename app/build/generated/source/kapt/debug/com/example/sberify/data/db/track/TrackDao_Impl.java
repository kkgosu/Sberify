package com.example.sberify.data.db.track;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
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
public final class TrackDao_Impl implements TrackDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TrackEntity> __insertionAdapterOfTrackEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTrackLyrics;

  private final SharedSQLiteStatement __preparedStmtOfSetTrackIsFavorite;

  public TrackDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrackEntity = new EntityInsertionAdapter<TrackEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `tracks` (`track_id`,`name`,`album_id`,`lyrics`,`artists_id`,`is_favorite`,`image_url`,`external_url`,`is_explicit`,`is_local`,`markets`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
        _tmp = ListToStringConverter.fromList(value.getArtistsId());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp);
        }
        final int _tmp_1;
        _tmp_1 = value.isFavorite() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        if (value.getImageUrl() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImageUrl());
        }
        if (value.getExternalUrl() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getExternalUrl());
        }
        final int _tmp_2;
        _tmp_2 = value.isExplicit() ? 1 : 0;
        stmt.bindLong(9, _tmp_2);
        final int _tmp_3;
        _tmp_3 = value.isLocal() ? 1 : 0;
        stmt.bindLong(10, _tmp_3);
        final String _tmp_4;
        _tmp_4 = ListToStringConverter.fromList(value.getMarkets());
        if (_tmp_4 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp_4);
        }
      }
    };
    this.__preparedStmtOfUpdateTrackLyrics = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE tracks SET lyrics = ? WHERE track_id=?";
        return _query;
      }
    };
    this.__preparedStmtOfSetTrackIsFavorite = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE tracks SET is_favorite = ? WHERE track_id = ?";
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
  public Object setTrackIsFavorite(final String id, final boolean isFavorite,
      final Continuation<? super Unit> p2) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfSetTrackIsFavorite.acquire();
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
          __preparedStmtOfSetTrackIsFavorite.release(_stmt);
        }
      }
    }, p2);
  }

  @Override
  public LiveData<TrackEntity> getTrackById(final String id) {
    final String _sql = "SELECT * FROM tracks WHERE track_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"tracks"}, false, new Callable<TrackEntity>() {
      @Override
      public TrackEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "track_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAlbumId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
          final int _cursorIndexOfLyrics = CursorUtil.getColumnIndexOrThrow(_cursor, "lyrics");
          final int _cursorIndexOfArtistsId = CursorUtil.getColumnIndexOrThrow(_cursor, "artists_id");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final int _cursorIndexOfIsExplicit = CursorUtil.getColumnIndexOrThrow(_cursor, "is_explicit");
          final int _cursorIndexOfIsLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "is_local");
          final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
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
            final List<String> _tmpArtistsId;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistsId);
            _tmpArtistsId = ListToStringConverter.fromString(_tmp);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            final boolean _tmpIsExplicit;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsExplicit);
            _tmpIsExplicit = _tmp_2 != 0;
            final boolean _tmpIsLocal;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsLocal);
            _tmpIsLocal = _tmp_3 != 0;
            final List<String> _tmpMarkets;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
            _result = new TrackEntity(_tmpSpotifyId,_tmpName,_tmpAlbumId,_tmpLyrics,_tmpArtistsId,_tmpIsFavorite,_tmpImageUrl,_tmpExternalUrl,_tmpIsExplicit,_tmpIsLocal,_tmpMarkets);
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
  public LiveData<List<TrackEntity>> getTracksByQuery(final String query) {
    final String _sql = "SELECT * FROM tracks WHERE name LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"tracks"}, false, new Callable<List<TrackEntity>>() {
      @Override
      public List<TrackEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "track_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAlbumId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
          final int _cursorIndexOfLyrics = CursorUtil.getColumnIndexOrThrow(_cursor, "lyrics");
          final int _cursorIndexOfArtistsId = CursorUtil.getColumnIndexOrThrow(_cursor, "artists_id");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final int _cursorIndexOfIsExplicit = CursorUtil.getColumnIndexOrThrow(_cursor, "is_explicit");
          final int _cursorIndexOfIsLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "is_local");
          final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
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
            final List<String> _tmpArtistsId;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistsId);
            _tmpArtistsId = ListToStringConverter.fromString(_tmp);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            final boolean _tmpIsExplicit;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsExplicit);
            _tmpIsExplicit = _tmp_2 != 0;
            final boolean _tmpIsLocal;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsLocal);
            _tmpIsLocal = _tmp_3 != 0;
            final List<String> _tmpMarkets;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
            _item = new TrackEntity(_tmpSpotifyId,_tmpName,_tmpAlbumId,_tmpLyrics,_tmpArtistsId,_tmpIsFavorite,_tmpImageUrl,_tmpExternalUrl,_tmpIsExplicit,_tmpIsLocal,_tmpMarkets);
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
  public LiveData<List<TrackEntity>> loadFavoriteTracks() {
    final String _sql = "SELECT * FROM tracks WHERE is_favorite = 1 ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tracks"}, false, new Callable<List<TrackEntity>>() {
      @Override
      public List<TrackEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "track_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAlbumId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
          final int _cursorIndexOfLyrics = CursorUtil.getColumnIndexOrThrow(_cursor, "lyrics");
          final int _cursorIndexOfArtistsId = CursorUtil.getColumnIndexOrThrow(_cursor, "artists_id");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final int _cursorIndexOfIsExplicit = CursorUtil.getColumnIndexOrThrow(_cursor, "is_explicit");
          final int _cursorIndexOfIsLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "is_local");
          final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
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
            final List<String> _tmpArtistsId;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistsId);
            _tmpArtistsId = ListToStringConverter.fromString(_tmp);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            final boolean _tmpIsExplicit;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsExplicit);
            _tmpIsExplicit = _tmp_2 != 0;
            final boolean _tmpIsLocal;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsLocal);
            _tmpIsLocal = _tmp_3 != 0;
            final List<String> _tmpMarkets;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
            _item = new TrackEntity(_tmpSpotifyId,_tmpName,_tmpAlbumId,_tmpLyrics,_tmpArtistsId,_tmpIsFavorite,_tmpImageUrl,_tmpExternalUrl,_tmpIsExplicit,_tmpIsLocal,_tmpMarkets);
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
  public TrackWithArtists getTrackWithArtists(final String id) {
    final String _sql = "SELECT * FROM tracks WHERE track_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "track_id");
        final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
        final int _cursorIndexOfAlbumId = CursorUtil.getColumnIndexOrThrow(_cursor, "album_id");
        final int _cursorIndexOfLyrics = CursorUtil.getColumnIndexOrThrow(_cursor, "lyrics");
        final int _cursorIndexOfArtistsId = CursorUtil.getColumnIndexOrThrow(_cursor, "artists_id");
        final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
        final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
        final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
        final int _cursorIndexOfIsExplicit = CursorUtil.getColumnIndexOrThrow(_cursor, "is_explicit");
        final int _cursorIndexOfIsLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "is_local");
        final int _cursorIndexOfMarkets = CursorUtil.getColumnIndexOrThrow(_cursor, "markets");
        final ArrayMap<String, ArrayList<ArtistEntity>> _collectionArtists = new ArrayMap<String, ArrayList<ArtistEntity>>();
        while (_cursor.moveToNext()) {
          final String _tmpKey = _cursor.getString(_cursorIndexOfSpotifyId);
          ArrayList<ArtistEntity> _tmpArtistsCollection = _collectionArtists.get(_tmpKey);
          if (_tmpArtistsCollection == null) {
            _tmpArtistsCollection = new ArrayList<ArtistEntity>();
            _collectionArtists.put(_tmpKey, _tmpArtistsCollection);
          }
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshipartistsAscomExampleSberifyDataDbArtistsArtistEntity(_collectionArtists);
        final TrackWithArtists _result;
        if(_cursor.moveToFirst()) {
          final TrackEntity _tmpTrack;
          if (! (_cursor.isNull(_cursorIndexOfSpotifyId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfAlbumId) && _cursor.isNull(_cursorIndexOfLyrics) && _cursor.isNull(_cursorIndexOfArtistsId) && _cursor.isNull(_cursorIndexOfIsFavorite) && _cursor.isNull(_cursorIndexOfImageUrl) && _cursor.isNull(_cursorIndexOfExternalUrl) && _cursor.isNull(_cursorIndexOfIsExplicit) && _cursor.isNull(_cursorIndexOfIsLocal) && _cursor.isNull(_cursorIndexOfMarkets))) {
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpAlbumId;
            _tmpAlbumId = _cursor.getString(_cursorIndexOfAlbumId);
            final String _tmpLyrics;
            _tmpLyrics = _cursor.getString(_cursorIndexOfLyrics);
            final List<String> _tmpArtistsId;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistsId);
            _tmpArtistsId = ListToStringConverter.fromString(_tmp);
            final boolean _tmpIsFavorite;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            final boolean _tmpIsExplicit;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsExplicit);
            _tmpIsExplicit = _tmp_2 != 0;
            final boolean _tmpIsLocal;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsLocal);
            _tmpIsLocal = _tmp_3 != 0;
            final List<String> _tmpMarkets;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
            _tmpTrack = new TrackEntity(_tmpSpotifyId,_tmpName,_tmpAlbumId,_tmpLyrics,_tmpArtistsId,_tmpIsFavorite,_tmpImageUrl,_tmpExternalUrl,_tmpIsExplicit,_tmpIsLocal,_tmpMarkets);
          }  else  {
            _tmpTrack = null;
          }
          ArrayList<ArtistEntity> _tmpArtistsCollection_1 = null;
          final String _tmpKey_1 = _cursor.getString(_cursorIndexOfSpotifyId);
          _tmpArtistsCollection_1 = _collectionArtists.get(_tmpKey_1);
          if (_tmpArtistsCollection_1 == null) {
            _tmpArtistsCollection_1 = new ArrayList<ArtistEntity>();
          }
          _result = new TrackWithArtists(_tmpTrack,_tmpArtistsCollection_1);
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
    _stringBuilder.append("SELECT `artists`.`artist_id` AS `artist_id`,`artists`.`name` AS `name`,`artists`.`image_url` AS `image_url`,`artists`.`external_url` AS `external_url`,_junction.`track_id` FROM `TrackArtistCrossRef` AS _junction INNER JOIN `artists` ON (_junction.`artist_id` = `artists`.`artist_id`) WHERE _junction.`track_id` IN (");
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
      final int _itemKeyIndex = 4; // _junction.track_id;
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
