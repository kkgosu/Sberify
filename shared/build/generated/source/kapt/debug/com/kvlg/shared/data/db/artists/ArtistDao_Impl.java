package com.kvlg.shared.data.db.artists;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
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
public final class ArtistDao_Impl implements ArtistDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ArtistEntity> __insertionAdapterOfArtistEntity;

  public ArtistDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfArtistEntity = new EntityInsertionAdapter<ArtistEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `artists` (`spotify_id`,`name`,`image_url`) VALUES (?,?,?)";
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
    final String _sql = "SELECT * FROM artists WHERE spotify_id = ?";
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
          final int _cursorIndexOfSpotifyId = CursorUtil.getColumnIndexOrThrow(_cursor, "spotify_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final ArtistEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpSpotifyId;
            _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            _result = new ArtistEntity(_tmpSpotifyId,_tmpName,_tmpImageUrl);
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
  public List<ArtistEntity> getArtistByKeyword(final String key) {
    final String _sql = "SELECT * FROM artists WHERE name LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
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
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
      final List<ArtistEntity> _result = new ArrayList<ArtistEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ArtistEntity _item;
        final String _tmpSpotifyId;
        _tmpSpotifyId = _cursor.getString(_cursorIndexOfSpotifyId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpImageUrl;
        _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        _item = new ArtistEntity(_tmpSpotifyId,_tmpName,_tmpImageUrl);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
