package com.example.sberify.data.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.sberify.data.db.album.AlbumDao;
import com.example.sberify.data.db.album.AlbumDao_Impl;
import com.example.sberify.data.db.artists.ArtistDao;
import com.example.sberify.data.db.artists.ArtistDao_Impl;
import com.example.sberify.data.db.suggestions.SuggestionsDao;
import com.example.sberify.data.db.suggestions.SuggestionsDao_Impl;
import com.example.sberify.data.db.track.TrackDao;
import com.example.sberify.data.db.track.TrackDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ArtistDao _artistDao;

  private volatile AlbumDao _albumDao;

  private volatile TrackDao _trackDao;

  private volatile SuggestionsDao _suggestionsDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `artists` (`artist_id` TEXT NOT NULL, `name` TEXT NOT NULL, `image_url` TEXT, `external_url` TEXT NOT NULL, PRIMARY KEY(`artist_id`))");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_artists_artist_id` ON `artists` (`artist_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `albums` (`album_id` TEXT NOT NULL, `artist_ids` TEXT NOT NULL, `name` TEXT NOT NULL, `image_url` TEXT NOT NULL, `release_date` TEXT NOT NULL, `release_date_precision` TEXT NOT NULL, `is_favorite` INTEGER NOT NULL, `genres` TEXT NOT NULL, `total_tracks` INTEGER NOT NULL, `external_url` TEXT NOT NULL, `copyrights` TEXT NOT NULL, `markets` TEXT NOT NULL, `type` TEXT NOT NULL, `label` TEXT NOT NULL, PRIMARY KEY(`album_id`))");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_albums_album_id` ON `albums` (`album_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_albums_artist_ids` ON `albums` (`artist_ids`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tracks` (`track_id` TEXT NOT NULL, `name` TEXT NOT NULL, `album_id` TEXT, `lyrics` TEXT, `artists_id` TEXT NOT NULL, `is_favorite` INTEGER NOT NULL, `image_url` TEXT, `external_url` TEXT NOT NULL, `is_explicit` INTEGER NOT NULL, `is_local` INTEGER NOT NULL, `markets` TEXT NOT NULL, PRIMARY KEY(`track_id`))");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_tracks_track_id` ON `tracks` (`track_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_tracks_artists_id` ON `tracks` (`artists_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `suggestions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `text` TEXT NOT NULL)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_suggestions_text` ON `suggestions` (`text`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AlbumArtistCrossRef` (`artist_id` INTEGER NOT NULL, `album_id` INTEGER NOT NULL, PRIMARY KEY(`artist_id`, `album_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TrackArtistCrossRef` (`artist_id` INTEGER NOT NULL, `track_id` INTEGER NOT NULL, PRIMARY KEY(`artist_id`, `track_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd0adbbc5014c55838680b7f73a733384')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `artists`");
        _db.execSQL("DROP TABLE IF EXISTS `albums`");
        _db.execSQL("DROP TABLE IF EXISTS `tracks`");
        _db.execSQL("DROP TABLE IF EXISTS `suggestions`");
        _db.execSQL("DROP TABLE IF EXISTS `AlbumArtistCrossRef`");
        _db.execSQL("DROP TABLE IF EXISTS `TrackArtistCrossRef`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsArtists = new HashMap<String, TableInfo.Column>(4);
        _columnsArtists.put("artist_id", new TableInfo.Column("artist_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsArtists.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsArtists.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsArtists.put("external_url", new TableInfo.Column("external_url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysArtists = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesArtists = new HashSet<TableInfo.Index>(1);
        _indicesArtists.add(new TableInfo.Index("index_artists_artist_id", false, Arrays.asList("artist_id")));
        final TableInfo _infoArtists = new TableInfo("artists", _columnsArtists, _foreignKeysArtists, _indicesArtists);
        final TableInfo _existingArtists = TableInfo.read(_db, "artists");
        if (! _infoArtists.equals(_existingArtists)) {
          return new RoomOpenHelper.ValidationResult(false, "artists(com.example.sberify.data.db.artists.ArtistEntity).\n"
                  + " Expected:\n" + _infoArtists + "\n"
                  + " Found:\n" + _existingArtists);
        }
        final HashMap<String, TableInfo.Column> _columnsAlbums = new HashMap<String, TableInfo.Column>(14);
        _columnsAlbums.put("album_id", new TableInfo.Column("album_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("artist_ids", new TableInfo.Column("artist_ids", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("image_url", new TableInfo.Column("image_url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("release_date", new TableInfo.Column("release_date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("release_date_precision", new TableInfo.Column("release_date_precision", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("is_favorite", new TableInfo.Column("is_favorite", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("genres", new TableInfo.Column("genres", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("total_tracks", new TableInfo.Column("total_tracks", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("external_url", new TableInfo.Column("external_url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("copyrights", new TableInfo.Column("copyrights", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("markets", new TableInfo.Column("markets", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("label", new TableInfo.Column("label", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlbums = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlbums = new HashSet<TableInfo.Index>(2);
        _indicesAlbums.add(new TableInfo.Index("index_albums_album_id", false, Arrays.asList("album_id")));
        _indicesAlbums.add(new TableInfo.Index("index_albums_artist_ids", false, Arrays.asList("artist_ids")));
        final TableInfo _infoAlbums = new TableInfo("albums", _columnsAlbums, _foreignKeysAlbums, _indicesAlbums);
        final TableInfo _existingAlbums = TableInfo.read(_db, "albums");
        if (! _infoAlbums.equals(_existingAlbums)) {
          return new RoomOpenHelper.ValidationResult(false, "albums(com.example.sberify.data.db.album.AlbumEntity).\n"
                  + " Expected:\n" + _infoAlbums + "\n"
                  + " Found:\n" + _existingAlbums);
        }
        final HashMap<String, TableInfo.Column> _columnsTracks = new HashMap<String, TableInfo.Column>(11);
        _columnsTracks.put("track_id", new TableInfo.Column("track_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("album_id", new TableInfo.Column("album_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("lyrics", new TableInfo.Column("lyrics", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("artists_id", new TableInfo.Column("artists_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("is_favorite", new TableInfo.Column("is_favorite", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("external_url", new TableInfo.Column("external_url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("is_explicit", new TableInfo.Column("is_explicit", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("is_local", new TableInfo.Column("is_local", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("markets", new TableInfo.Column("markets", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTracks = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTracks = new HashSet<TableInfo.Index>(2);
        _indicesTracks.add(new TableInfo.Index("index_tracks_track_id", false, Arrays.asList("track_id")));
        _indicesTracks.add(new TableInfo.Index("index_tracks_artists_id", false, Arrays.asList("artists_id")));
        final TableInfo _infoTracks = new TableInfo("tracks", _columnsTracks, _foreignKeysTracks, _indicesTracks);
        final TableInfo _existingTracks = TableInfo.read(_db, "tracks");
        if (! _infoTracks.equals(_existingTracks)) {
          return new RoomOpenHelper.ValidationResult(false, "tracks(com.example.sberify.data.db.track.TrackEntity).\n"
                  + " Expected:\n" + _infoTracks + "\n"
                  + " Found:\n" + _existingTracks);
        }
        final HashMap<String, TableInfo.Column> _columnsSuggestions = new HashMap<String, TableInfo.Column>(2);
        _columnsSuggestions.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuggestions.put("text", new TableInfo.Column("text", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSuggestions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSuggestions = new HashSet<TableInfo.Index>(1);
        _indicesSuggestions.add(new TableInfo.Index("index_suggestions_text", true, Arrays.asList("text")));
        final TableInfo _infoSuggestions = new TableInfo("suggestions", _columnsSuggestions, _foreignKeysSuggestions, _indicesSuggestions);
        final TableInfo _existingSuggestions = TableInfo.read(_db, "suggestions");
        if (! _infoSuggestions.equals(_existingSuggestions)) {
          return new RoomOpenHelper.ValidationResult(false, "suggestions(com.example.sberify.data.db.suggestions.SuggestionsEntity).\n"
                  + " Expected:\n" + _infoSuggestions + "\n"
                  + " Found:\n" + _existingSuggestions);
        }
        final HashMap<String, TableInfo.Column> _columnsAlbumArtistCrossRef = new HashMap<String, TableInfo.Column>(2);
        _columnsAlbumArtistCrossRef.put("artist_id", new TableInfo.Column("artist_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbumArtistCrossRef.put("album_id", new TableInfo.Column("album_id", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlbumArtistCrossRef = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlbumArtistCrossRef = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAlbumArtistCrossRef = new TableInfo("AlbumArtistCrossRef", _columnsAlbumArtistCrossRef, _foreignKeysAlbumArtistCrossRef, _indicesAlbumArtistCrossRef);
        final TableInfo _existingAlbumArtistCrossRef = TableInfo.read(_db, "AlbumArtistCrossRef");
        if (! _infoAlbumArtistCrossRef.equals(_existingAlbumArtistCrossRef)) {
          return new RoomOpenHelper.ValidationResult(false, "AlbumArtistCrossRef(com.example.sberify.data.db.album.AlbumArtistCrossRef).\n"
                  + " Expected:\n" + _infoAlbumArtistCrossRef + "\n"
                  + " Found:\n" + _existingAlbumArtistCrossRef);
        }
        final HashMap<String, TableInfo.Column> _columnsTrackArtistCrossRef = new HashMap<String, TableInfo.Column>(2);
        _columnsTrackArtistCrossRef.put("artist_id", new TableInfo.Column("artist_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrackArtistCrossRef.put("track_id", new TableInfo.Column("track_id", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTrackArtistCrossRef = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTrackArtistCrossRef = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTrackArtistCrossRef = new TableInfo("TrackArtistCrossRef", _columnsTrackArtistCrossRef, _foreignKeysTrackArtistCrossRef, _indicesTrackArtistCrossRef);
        final TableInfo _existingTrackArtistCrossRef = TableInfo.read(_db, "TrackArtistCrossRef");
        if (! _infoTrackArtistCrossRef.equals(_existingTrackArtistCrossRef)) {
          return new RoomOpenHelper.ValidationResult(false, "TrackArtistCrossRef(com.example.sberify.data.db.track.TrackArtistCrossRef).\n"
                  + " Expected:\n" + _infoTrackArtistCrossRef + "\n"
                  + " Found:\n" + _existingTrackArtistCrossRef);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "d0adbbc5014c55838680b7f73a733384", "0f009180a5ec0022c9917e62d228b274");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "artists","albums","tracks","suggestions","AlbumArtistCrossRef","TrackArtistCrossRef");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `artists`");
      _db.execSQL("DELETE FROM `albums`");
      _db.execSQL("DELETE FROM `tracks`");
      _db.execSQL("DELETE FROM `suggestions`");
      _db.execSQL("DELETE FROM `AlbumArtistCrossRef`");
      _db.execSQL("DELETE FROM `TrackArtistCrossRef`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ArtistDao getArtistDao() {
    if (_artistDao != null) {
      return _artistDao;
    } else {
      synchronized(this) {
        if(_artistDao == null) {
          _artistDao = new ArtistDao_Impl(this);
        }
        return _artistDao;
      }
    }
  }

  @Override
  public AlbumDao getAlbumDao() {
    if (_albumDao != null) {
      return _albumDao;
    } else {
      synchronized(this) {
        if(_albumDao == null) {
          _albumDao = new AlbumDao_Impl(this);
        }
        return _albumDao;
      }
    }
  }

  @Override
  public TrackDao getTrackDao() {
    if (_trackDao != null) {
      return _trackDao;
    } else {
      synchronized(this) {
        if(_trackDao == null) {
          _trackDao = new TrackDao_Impl(this);
        }
        return _trackDao;
      }
    }
  }

  @Override
  public SuggestionsDao getSuggestionsDao() {
    if (_suggestionsDao != null) {
      return _suggestionsDao;
    } else {
      synchronized(this) {
        if(_suggestionsDao == null) {
          _suggestionsDao = new SuggestionsDao_Impl(this);
        }
        return _suggestionsDao;
      }
    }
  }
}
