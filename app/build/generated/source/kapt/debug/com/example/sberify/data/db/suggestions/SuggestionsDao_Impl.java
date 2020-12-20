package com.example.sberify.data.db.suggestions;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SuggestionsDao_Impl implements SuggestionsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SuggestionsEntity> __insertionAdapterOfSuggestionsEntity;

  private final SharedSQLiteStatement __preparedStmtOfCheckLimitAndDelete;

  public SuggestionsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSuggestionsEntity = new EntityInsertionAdapter<SuggestionsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `suggestions` (`id`,`text`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SuggestionsEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getText() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getText());
        }
      }
    };
    this.__preparedStmtOfCheckLimitAndDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM suggestions WHERE id NOT IN (SELECT id FROM suggestions ORDER BY id DESC LIMIT 5)";
        return _query;
      }
    };
  }

  @Override
  public void insertSuggestion(final SuggestionsEntity suggestionsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSuggestionsEntity.insert(suggestionsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void checkLimitAndDelete() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfCheckLimitAndDelete.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfCheckLimitAndDelete.release(_stmt);
    }
  }

  @Override
  public List<SuggestionsEntity> getAllSuggestions() {
    final String _sql = "SELECT * FROM suggestions ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
      final List<SuggestionsEntity> _result = new ArrayList<SuggestionsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SuggestionsEntity _item;
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        final String _tmpText;
        _tmpText = _cursor.getString(_cursorIndexOfText);
        _item = new SuggestionsEntity(_tmpId,_tmpText);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
