package com.example.sberify.data.db.artists;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.sberify.data.db.ListToStringConverter;
import com.example.sberify.data.db.album.AlbumEntity;
import com.example.sberify.data.db.track.TrackEntity;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ArtistDao_Impl implements ArtistDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ArtistEntity> __insertionAdapterOfArtistEntity;

  public ArtistDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfArtistEntity = new EntityInsertionAdapter<ArtistEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `artists` (`artist_id`,`name`,`image_url`,`external_url`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ArtistEntity value) {
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
        if (value.getImageUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImageUrl());
        }
        if (value.getExternalUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getExternalUrl());
        }
      }
    };
  }

  @Override
  public void insertArtist(final ArtistEntity artistEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfArtistEntity.insert(artistEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<ArtistEntity> getArtistById(final String id) {
    final String _sql = "SELECT * FROM artists WHERE artist_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"artists"}, false, new Callable<ArtistEntity>() {
      @Override
      public ArtistEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final ArtistEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            _result = new ArtistEntity(_tmpSpotifyId,_tmpName,_tmpImageUrl,_tmpExternalUrl);
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
  public LiveData<List<ArtistEntity>> getArtistByKeyword(final String key) {
    final String _sql = "SELECT * FROM artists WHERE name LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (key == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, key);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"artists"}, false, new Callable<List<ArtistEntity>>() {
      @Override
      public List<ArtistEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final List<ArtistEntity> _result = new ArrayList<ArtistEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ArtistEntity _item;
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            _item = new ArtistEntity(_tmpSpotifyId,_tmpName,_tmpImageUrl,_tmpExternalUrl);
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
  public LiveData<ArtistWithAlbums> getAlbums(final String artistId) {
    final String _sql = "SELECT * FROM artists WHERE artist_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (artistId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, artistId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"AlbumArtistCrossRef","albums","artists"}, true, new Callable<ArtistWithAlbums>() {
      @Override
      public ArtistWithAlbums call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
            final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
            final ArrayMap<String, ArrayList<AlbumEntity>> _collectionAlbumEntities = new ArrayMap<String, ArrayList<AlbumEntity>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfSpotifyId);
              ArrayList<AlbumEntity> _tmpAlbumEntitiesCollection = _collectionAlbumEntities.get(_tmpKey);
              if (_tmpAlbumEntitiesCollection == null) {
                _tmpAlbumEntitiesCollection = new ArrayList<AlbumEntity>();
                _collectionAlbumEntities.put(_tmpKey, _tmpAlbumEntitiesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipalbumsAscomExampleSberifyDataDbAlbumAlbumEntity(_collectionAlbumEntities);
            final ArtistWithAlbums _result;
            if(_cursor.moveToFirst()) {
              final ArtistEntity _tmpArtistEntity;
              if (! (_cursor.isNull(_cursorIndexOfSpotifyId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfImageUrl) && _cursor.isNull(_cursorIndexOfExternalUrl))) {
                final String _tmpSpotifyId;
                _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
                final String _tmpName;
                _tmpName = _cursor.getString(_cursorIndexOfName);
                final String _tmpImageUrl;
                _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
                final String _tmpExternalUrl;
                _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
                _tmpArtistEntity = new ArtistEntity(_tmpSpotifyId,_tmpName,_tmpImageUrl,_tmpExternalUrl);
              }  else  {
                _tmpArtistEntity = null;
              }
              ArrayList<AlbumEntity> _tmpAlbumEntitiesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfSpotifyId);
              _tmpAlbumEntitiesCollection_1 = _collectionAlbumEntities.get(_tmpKey_1);
              if (_tmpAlbumEntitiesCollection_1 == null) {
                _tmpAlbumEntitiesCollection_1 = new ArrayList<AlbumEntity>();
              }
              _result = new ArtistWithAlbums(_tmpArtistEntity,_tmpAlbumEntitiesCollection_1);
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
  public LiveData<List<ArtistEntity>> getArtistByQuery(final String query) {
    final String _sql = "SELECT * FROM artists WHERE name LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"artists"}, false, new Callable<List<ArtistEntity>>() {
      @Override
      public List<ArtistEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
          final List<ArtistEntity> _result = new ArrayList<ArtistEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ArtistEntity _item;
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            _item = new ArtistEntity(_tmpSpotifyId,_tmpName,_tmpImageUrl,_tmpExternalUrl);
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
  public ArtistWithTracks getArtistWithSongs(final String artistId) {
    final String _sql = "SELECT * FROM artists WHERE artist_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (artistId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, artistId);
    }
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "artist_id");
        final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
        final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
        final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "external_url");
        final ArrayMap<String, ArrayList<TrackEntity>> _collectionTracks = new ArrayMap<String, ArrayList<TrackEntity>>();
        while (_cursor.moveToNext()) {
          final String _tmpKey = _cursor.getString(_cursorIndexOfSpotifyId);
          ArrayList<TrackEntity> _tmpTracksCollection = _collectionTracks.get(_tmpKey);
          if (_tmpTracksCollection == null) {
            _tmpTracksCollection = new ArrayList<TrackEntity>();
            _collectionTracks.put(_tmpKey, _tmpTracksCollection);
          }
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshiptracksAscomExampleSberifyDataDbTrackTrackEntity(_collectionTracks);
        final ArtistWithTracks _result;
        if(_cursor.moveToFirst()) {
          final ArtistEntity _tmpArtist;
          if (! (_cursor.isNull(_cursorIndexOfSpotifyId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfImageUrl) && _cursor.isNull(_cursorIndexOfExternalUrl))) {
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpExternalUrl;
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
            _tmpArtist = new ArtistEntity(_tmpSpotifyId,_tmpName,_tmpImageUrl,_tmpExternalUrl);
          }  else  {
            _tmpArtist = null;
          }
          ArrayList<TrackEntity> _tmpTracksCollection_1 = null;
          final String _tmpKey_1 = _cursor.getString(_cursorIndexOfSpotifyId);
          _tmpTracksCollection_1 = _collectionTracks.get(_tmpKey_1);
          if (_tmpTracksCollection_1 == null) {
            _tmpTracksCollection_1 = new ArrayList<TrackEntity>();
          }
          _result = new ArtistWithTracks(_tmpArtist,_tmpTracksCollection_1);
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

  private void __fetchRelationshipalbumsAscomExampleSberifyDataDbAlbumAlbumEntity(
      final ArrayMap<String, ArrayList<AlbumEntity>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      ArrayMap<String, ArrayList<AlbumEntity>> _tmpInnerMap = new ArrayMap<String, ArrayList<AlbumEntity>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipalbumsAscomExampleSberifyDataDbAlbumAlbumEntity(_tmpInnerMap);
          _tmpInnerMap = new ArrayMap<String, ArrayList<AlbumEntity>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipalbumsAscomExampleSberifyDataDbAlbumAlbumEntity(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `albums`.`album_id` AS `album_id`,`albums`.`artist_ids` AS `artist_ids`,`albums`.`name` AS `name`,`albums`.`image_url` AS `image_url`,`albums`.`release_date` AS `release_date`,`albums`.`release_date_precision` AS `release_date_precision`,`albums`.`is_favorite` AS `is_favorite`,`albums`.`genres` AS `genres`,`albums`.`total_tracks` AS `total_tracks`,`albums`.`external_url` AS `external_url`,`albums`.`copyrights` AS `copyrights`,`albums`.`markets` AS `markets`,`albums`.`type` AS `type`,`albums`.`label` AS `label`,_junction.`artist_id` FROM `AlbumArtistCrossRef` AS _junction INNER JOIN `albums` ON (_junction.`album_id` = `albums`.`album_id`) WHERE _junction.`artist_id` IN (");
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
      final int _itemKeyIndex = 14; // _junction.artist_id;
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndex(_cursor, "album_id");
      final int _cursorIndexOfArtistIds = CursorUtil.getColumnIndex(_cursor, "artist_ids");
      final int _cursorIndexOfName = CursorUtil.getColumnIndex(_cursor, "name");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndex(_cursor, "image_url");
      final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndex(_cursor, "release_date");
      final int _cursorIndexOfReleaseDatePrecision = CursorUtil.getColumnIndex(_cursor, "release_date_precision");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndex(_cursor, "is_favorite");
      final int _cursorIndexOfGenres = CursorUtil.getColumnIndex(_cursor, "genres");
      final int _cursorIndexOfTotalTracks = CursorUtil.getColumnIndex(_cursor, "total_tracks");
      final int _cursorIndexOfExternalUrl = CursorUtil.getColumnIndex(_cursor, "external_url");
      final int _cursorIndexOfCopyrights = CursorUtil.getColumnIndex(_cursor, "copyrights");
      final int _cursorIndexOfMarkets = CursorUtil.getColumnIndex(_cursor, "markets");
      final int _cursorIndexOfType = CursorUtil.getColumnIndex(_cursor, "type");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndex(_cursor, "label");
      while(_cursor.moveToNext()) {
        final String _tmpKey = _cursor.getString(_itemKeyIndex);
        ArrayList<AlbumEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final AlbumEntity _item_1;
          final String _tmpSpotifyId;
          if (_cursorIndexOfSpotifyId == -1) {
            _tmpSpotifyId = null;
          } else {
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
          }
          final List<String> _tmpArtistIds;
          if (_cursorIndexOfArtistIds == -1) {
            _tmpArtistIds = null;
          } else {
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfArtistIds);
            _tmpArtistIds = ListToStringConverter.fromString(_tmp);
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
          final String _tmpReleaseDate;
          if (_cursorIndexOfReleaseDate == -1) {
            _tmpReleaseDate = null;
          } else {
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
          }
          final String _tmpReleaseDatePrecision;
          if (_cursorIndexOfReleaseDatePrecision == -1) {
            _tmpReleaseDatePrecision = null;
          } else {
            _tmpReleaseDatePrecision = _cursor.getString(_cursorIndexOfReleaseDatePrecision);
          }
          final boolean _tmpIsFavorite;
          if (_cursorIndexOfIsFavorite == -1) {
            _tmpIsFavorite = false;
          } else {
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_1 != 0;
          }
          final List<String> _tmpGenres;
          if (_cursorIndexOfGenres == -1) {
            _tmpGenres = null;
          } else {
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfGenres);
            _tmpGenres = ListToStringConverter.fromString(_tmp_2);
          }
          final int _tmpTotalTracks;
          if (_cursorIndexOfTotalTracks == -1) {
            _tmpTotalTracks = 0;
          } else {
            _tmpTotalTracks = _cursor.getInt(_cursorIndexOfTotalTracks);
          }
          final String _tmpExternalUrl;
          if (_cursorIndexOfExternalUrl == -1) {
            _tmpExternalUrl = null;
          } else {
            _tmpExternalUrl = _cursor.getString(_cursorIndexOfExternalUrl);
          }
          final List<String> _tmpCopyrights;
          if (_cursorIndexOfCopyrights == -1) {
            _tmpCopyrights = null;
          } else {
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfCopyrights);
            _tmpCopyrights = ListToStringConverter.fromString(_tmp_3);
          }
          final List<String> _tmpMarkets;
          if (_cursorIndexOfMarkets == -1) {
            _tmpMarkets = null;
          } else {
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfMarkets);
            _tmpMarkets = ListToStringConverter.fromString(_tmp_4);
          }
          final String _tmpType;
          if (_cursorIndexOfType == -1) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          final String _tmpLabel;
          if (_cursorIndexOfLabel == -1) {
            _tmpLabel = null;
          } else {
            _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
          }
          _item_1 = new AlbumEntity(_tmpSpotifyId,_tmpArtistIds,_tmpName,_tmpImageUrl,_tmpReleaseDate,_tmpReleaseDatePrecision,_tmpIsFavorite,_tmpGenres,_tmpTotalTracks,_tmpExternalUrl,_tmpCopyrights,_tmpMarkets,_tmpType,_tmpLabel);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
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
    _stringBuilder.append("SELECT `tracks`.`track_id` AS `track_id`,`tracks`.`name` AS `name`,`tracks`.`album_id` AS `album_id`,`tracks`.`lyrics` AS `lyrics`,`tracks`.`artists_id` AS `artists_id`,`tracks`.`is_favorite` AS `is_favorite`,`tracks`.`image_url` AS `image_url`,`tracks`.`external_url` AS `external_url`,`tracks`.`is_explicit` AS `is_explicit`,`tracks`.`is_local` AS `is_local`,`tracks`.`markets` AS `markets`,_junction.`artist_id` FROM `TrackArtistCrossRef` AS _junction INNER JOIN `tracks` ON (_junction.`track_id` = `tracks`.`track_id`) WHERE _junction.`artist_id` IN (");
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
      final int _itemKeyIndex = 11; // _junction.artist_id;
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
}
