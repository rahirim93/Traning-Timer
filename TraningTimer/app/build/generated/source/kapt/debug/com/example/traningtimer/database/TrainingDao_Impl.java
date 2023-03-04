package com.example.traningtimer.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TrainingDao_Impl implements TrainingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TrainingEntity> __insertionAdapterOfTrainingEntity;

  private final TrainingTypeConverters __trainingTypeConverters = new TrainingTypeConverters();

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public TrainingDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrainingEntity = new EntityInsertionAdapter<TrainingEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `training_table` (`id`,`count`,`weight`,`type`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TrainingEntity value) {
        final String _tmp = __trainingTypeConverters.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        if (value.getCount() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCount());
        }
        stmt.bindLong(3, value.getWeight());
        stmt.bindLong(4, value.getType());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM training_table";
        return _query;
      }
    };
  }

  @Override
  public void addTraining(final TrainingEntity trainingEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrainingEntity.insert(trainingEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<TrainingEntity>> getAll() {
    final String _sql = "SELECT * FROM training_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"training_table"}, false, new Callable<List<TrainingEntity>>() {
      @Override
      public List<TrainingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final List<TrainingEntity> _result = new ArrayList<TrainingEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TrainingEntity _item;
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __trainingTypeConverters.toUUID(_tmp);
            final String _tmpCount;
            if (_cursor.isNull(_cursorIndexOfCount)) {
              _tmpCount = null;
            } else {
              _tmpCount = _cursor.getString(_cursorIndexOfCount);
            }
            final int _tmpWeight;
            _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
            final int _tmpType;
            _tmpType = _cursor.getInt(_cursorIndexOfType);
            _item = new TrainingEntity(_tmpId,_tmpCount,_tmpWeight,_tmpType);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
