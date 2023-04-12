package com.example.traningtimer.database;

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
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TrainingDao_Impl implements TrainingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TrainingEntity> __insertionAdapterOfTrainingEntity;

  private final TrainingTypeConverters __trainingTypeConverters = new TrainingTypeConverters();

  private final EntityInsertionAdapter<TrainingEntity> __insertionAdapterOfTrainingEntity_1;

  private final EntityDeletionOrUpdateAdapter<TrainingEntity> __deletionAdapterOfTrainingEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public TrainingDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrainingEntity = new EntityInsertionAdapter<TrainingEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `training_table` (`id`,`date`,`count`,`weight`,`type`,`isChecked`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TrainingEntity value) {
        final String _tmp = __trainingTypeConverters.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        final long _tmp_1 = __trainingTypeConverters.fromCalendar(value.getDate());
        stmt.bindLong(2, _tmp_1);
        if (value.getCount() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCount());
        }
        stmt.bindLong(4, value.getWeight());
        stmt.bindLong(5, value.getType());
        final int _tmp_2 = value.isChecked() ? 1 : 0;
        stmt.bindLong(6, _tmp_2);
      }
    };
    this.__insertionAdapterOfTrainingEntity_1 = new EntityInsertionAdapter<TrainingEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `training_table` (`id`,`date`,`count`,`weight`,`type`,`isChecked`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TrainingEntity value) {
        final String _tmp = __trainingTypeConverters.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        final long _tmp_1 = __trainingTypeConverters.fromCalendar(value.getDate());
        stmt.bindLong(2, _tmp_1);
        if (value.getCount() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCount());
        }
        stmt.bindLong(4, value.getWeight());
        stmt.bindLong(5, value.getType());
        final int _tmp_2 = value.isChecked() ? 1 : 0;
        stmt.bindLong(6, _tmp_2);
      }
    };
    this.__deletionAdapterOfTrainingEntity = new EntityDeletionOrUpdateAdapter<TrainingEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `training_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TrainingEntity value) {
        final String _tmp = __trainingTypeConverters.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
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
  public Object save(final TrainingEntity[] entities,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTrainingEntity.insert(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public void addTraining(final TrainingEntity trainingEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrainingEntity_1.insert(trainingEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object delete(final TrainingEntity[] entities,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTrainingEntity.handleMultiple(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
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
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
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
            final Calendar _tmpDate;
            final long _tmp_1;
            _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = __trainingTypeConverters.toCalendar(_tmp_1);
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
            final boolean _tmpIsChecked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsChecked);
            _tmpIsChecked = _tmp_2 != 0;
            _item = new TrainingEntity(_tmpId,_tmpDate,_tmpCount,_tmpWeight,_tmpType,_tmpIsChecked);
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
  public Flow<List<TrainingEntity>> getAllFlow() {
    final String _sql = "SELECT * FROM training_table ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"training_table"}, new Callable<List<TrainingEntity>>() {
      @Override
      public List<TrainingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
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
            final Calendar _tmpDate;
            final long _tmp_1;
            _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = __trainingTypeConverters.toCalendar(_tmp_1);
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
            final boolean _tmpIsChecked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsChecked);
            _tmpIsChecked = _tmp_2 != 0;
            _item = new TrainingEntity(_tmpId,_tmpDate,_tmpCount,_tmpWeight,_tmpType,_tmpIsChecked);
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
  public Flow<List<TrainingEntity>> filtered(final int type) {
    final String _sql = "SELECT * FROM training_table WHERE type = ? ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, type);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"training_table"}, new Callable<List<TrainingEntity>>() {
      @Override
      public List<TrainingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
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
            final Calendar _tmpDate;
            final long _tmp_1;
            _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = __trainingTypeConverters.toCalendar(_tmp_1);
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
            final boolean _tmpIsChecked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsChecked);
            _tmpIsChecked = _tmp_2 != 0;
            _item = new TrainingEntity(_tmpId,_tmpDate,_tmpCount,_tmpWeight,_tmpType,_tmpIsChecked);
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
  public Flow<List<TrainingEntity>> filtered12() {
    final String _sql = "SELECT * FROM training_table WHERE type=1 OR type=2 ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"training_table"}, new Callable<List<TrainingEntity>>() {
      @Override
      public List<TrainingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
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
            final Calendar _tmpDate;
            final long _tmp_1;
            _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = __trainingTypeConverters.toCalendar(_tmp_1);
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
            final boolean _tmpIsChecked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsChecked);
            _tmpIsChecked = _tmp_2 != 0;
            _item = new TrainingEntity(_tmpId,_tmpDate,_tmpCount,_tmpWeight,_tmpType,_tmpIsChecked);
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
  public Flow<TrainingEntity> findFlow(final UUID itemId) {
    final String _sql = "SELECT * FROM training_table WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __trainingTypeConverters.fromUUID(itemId);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"training_table"}, new Callable<TrainingEntity>() {
      @Override
      public TrainingEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
          final TrainingEntity _result;
          if(_cursor.moveToFirst()) {
            final UUID _tmpId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __trainingTypeConverters.toUUID(_tmp_1);
            final Calendar _tmpDate;
            final long _tmp_2;
            _tmp_2 = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = __trainingTypeConverters.toCalendar(_tmp_2);
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
            final boolean _tmpIsChecked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsChecked);
            _tmpIsChecked = _tmp_3 != 0;
            _result = new TrainingEntity(_tmpId,_tmpDate,_tmpCount,_tmpWeight,_tmpType,_tmpIsChecked);
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
  public LiveData<TrainingEntity> findLiveData(final UUID itemId) {
    final String _sql = "SELECT * FROM training_table WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __trainingTypeConverters.fromUUID(itemId);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"training_table"}, false, new Callable<TrainingEntity>() {
      @Override
      public TrainingEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
          final TrainingEntity _result;
          if(_cursor.moveToFirst()) {
            final UUID _tmpId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __trainingTypeConverters.toUUID(_tmp_1);
            final Calendar _tmpDate;
            final long _tmp_2;
            _tmp_2 = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = __trainingTypeConverters.toCalendar(_tmp_2);
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
            final boolean _tmpIsChecked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsChecked);
            _tmpIsChecked = _tmp_3 != 0;
            _result = new TrainingEntity(_tmpId,_tmpDate,_tmpCount,_tmpWeight,_tmpType,_tmpIsChecked);
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
  public LiveData<Calendar> findLastTraining() {
    final String _sql = "SELECT MAX(date) FROM training_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"training_table"}, false, new Callable<Calendar>() {
      @Override
      public Calendar call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Calendar _result;
          if(_cursor.moveToFirst()) {
            final long _tmp;
            _tmp = _cursor.getLong(0);
            _result = __trainingTypeConverters.toCalendar(_tmp);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
