package com.kvlg.shared.data.db;

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
import com.kvlg.shared.data.db.album.AlbumDao;
import com.kvlg.shared.data.db.album.AlbumDao_Impl;
import com.kvlg.shared.data.db.artists.ArtistDao;
import com.kvlg.shared.data.db.artists.ArtistDao_Impl;
import com.kvlg.shared.data.db.suggestions.SuggestionsDao;
import com.kvlg.shared.data.db.suggestions.SuggestionsDao_Impl;
import com.kvlg.shared.data.db.track.TrackDao;
import com.kvlg.shared.data.db.track.TrackDao_Impl;
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
        _db.execSQL("CREATE TABLE IF NOT EXISTS `artists` (`spotify_id` TEXT NOT NULL, `name` TEXT NOT NULL, `image_url` TEXT, PRIMARY KEY(`spotify_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `albums` (`spotify_id` TEXT NOT NULL, `artist_id` TEXT NOT NULL, `name` TEXT NOT NULL, `track_ids` TEXT, `image_url` TEXT NOT NULL, `release_date` TEXT NOT NULL, `isFavorite` INTEGER NOT NULL, `mspotify_id` TEXT NOT NULL, `mname` TEXT NOT NULL, `mimage_url` TEXT, PRIMARY KEY(`spotify_id`))");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_albums_spotify_id` ON `albums` (`spotify_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_albums_artist_id` ON `albums` (`artist_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tracks` (`spotify_id` TEXT NOT NULL, `name` TEXT NOT NULL, `album_id` TEXT NOT NULL, `lyrics` TEXT, `artists` TEXT NOT NULL, `isFavorite` INTEGER NOT NULL, `image_url` TEXT, PRIMARY KEY(`spotify_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `suggestions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `text` TEXT NOT NULL)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_suggestions_text` ON `suggestions` (`text`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e32961f5983880526036b4f762f751d0')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `artists`");
        _db.execSQL("DROP TABLE IF EXISTS `albums`");
        _db.execSQL("DROP TABLE IF EXISTS `tracks`");
        _db.execSQL("DROP TABLE IF EXISTS `suggestions`");
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
        final HashMap<String, TableInfo.Column> _columnsArtists = new HashMap<String, TableInfo.Column>(3);
        _columnsArtists.put("spotify_id", new TableInfo.Column("spotify_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsArtists.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsArtists.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysArtists = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesArtists = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoArtists = new TableInfo("artists", _columnsArtists, _foreignKeysArtists, _indicesArtists);
        final TableInfo _existingArtists = TableInfo.read(_db, "artists");
        if (! _infoArtists.equals(_existingArtists)) {
          return new RoomOpenHelper.ValidationResult(false, "artists(com.kvlg.shared.data.db.artists.ArtistEntity).\n"
                  + " Expected:\n" + _infoArtists + "\n"
                  + " Found:\n" + _existingArtists);
        }
        final HashMap<String, TableInfo.Column> _columnsAlbums = new HashMap<String, TableInfo.Column>(10);
        _columnsAlbums.put("spotify_id", new TableInfo.Column("spotify_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("artist_id", new TableInfo.Column("artist_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("track_ids", new TableInfo.Column("track_ids", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("image_url", new TableInfo.Column("image_url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("release_date", new TableInfo.Column("release_date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("isFavorite", new TableInfo.Column("isFavorite", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("mspotify_id", new TableInfo.Column("mspotify_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("mname", new TableInfo.Column("mname", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbums.put("mimage_url", new TableInfo.Column("mimage_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlbums = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlbums = new HashSet<TableInfo.Index>(2);
        _indicesAlbums.add(new TableInfo.Index("index_albums_spotify_id", false, Arrays.asList("spotify_id")));
        _indicesAlbums.add(new TableInfo.Index("index_albums_artist_id", false, Arrays.asList("artist_id")));
        final TableInfo _infoAlbums = new TableInfo("albums", _columnsAlbums, _foreignKeysAlbums, _indicesAlbums);
        final TableInfo _existingAlbums = TableInfo.read(_db, "albums");
        if (! _infoAlbums.equals(_existingAlbums)) {
          return new RoomOpenHelper.ValidationResult(false, "albums(com.kvlg.shared.data.db.album.AlbumEntity).\n"
                  + " Expected:\n" + _infoAlbums + "\n"
                  + " Found:\n" + _existingAlbums);
        }
        final HashMap<String, TableInfo.Column> _columnsTracks = new HashMap<String, TableInfo.Column>(7);
        _columnsTracks.put("spotify_id", new TableInfo.Column("spotify_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("album_id", new TableInfo.Column("album_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("lyrics", new TableInfo.Column("lyrics", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("artists", new TableInfo.Column("artists", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("isFavorite", new TableInfo.Column("isFavorite", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTracks = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTracks = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTracks = new TableInfo("tracks", _columnsTracks, _foreignKeysTracks, _indicesTracks);
        final TableInfo _existingTracks = TableInfo.read(_db, "tracks");
        if (! _infoTracks.equals(_existingTracks)) {
          return new RoomOpenHelper.ValidationResult(false, "tracks(com.kvlg.shared.data.db.track.TrackEntity).\n"
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
          return new RoomOpenHelper.ValidationResult(false, "suggestions(com.kvlg.shared.data.db.suggestions.SuggestionsEntity).\n"
                  + " Expected:\n" + _infoSuggestions + "\n"
                  + " Found:\n" + _existingSuggestions);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "e32961f5983880526036b4f762f751d0", "5ded1c45a0b82101e48ec42cfa98077c");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "artists","albums","tracks","suggestions");
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
