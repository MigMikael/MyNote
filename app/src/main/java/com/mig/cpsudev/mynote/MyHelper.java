package com.mig.cpsudev.mynote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Mig on 06-Dec-15.
 */
public class MyHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "note.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Note";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "title";
    public static final String COL_DETAIL = "detail";
    public static final String COL_PRIORITY = "priority";

    public MyHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTypeTable = "CREATE TABLE %s (" +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT," +
                "%s TEXT," +
                "%s TEXT)";
        sqlCreateTypeTable = String.format(sqlCreateTypeTable, TABLE_NAME, COL_ID, COL_TITLE, COL_DETAIL, COL_PRIORITY);
        db.execSQL(sqlCreateTypeTable);

        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, "Test");
        cv.put(COL_DETAIL, "Final Exam App");
        cv.put(COL_PRIORITY, "*");
        db.insert(TABLE_NAME, null, cv);
    }

    public void addToDB(Note newNote, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, newNote.getTitle());
        cv.put(COL_DETAIL, newNote.getDetail());
        cv.put(COL_PRIORITY, newNote.getPriority());
        db.insert(TABLE_NAME, null, cv);
    }

    public Note getData(int position, SQLiteDatabase db) {
        Note newNote = null;
        String sql = "SELECT * FROM %s WHERE %s = ?";
        sql = String.format(sql, TABLE_NAME, COL_ID);
        Cursor c = db.rawQuery(sql, new String[]{String.valueOf(position + 1)});

        if (c.moveToFirst()) {
            do {
                String title = c.getString(c.getColumnIndex(MyHelper.COL_TITLE));
                String detail = c.getString(c.getColumnIndex(MyHelper.COL_DETAIL));
                String priority = c.getString(c.getColumnIndex(MyHelper.COL_PRIORITY));
                newNote = new Note(title, detail, priority);
            } while (c.moveToNext());
        }
        return newNote;
    }

    public void deleteData(int position, SQLiteDatabase db) {
        String whereClause = MyHelper.COL_ID + " = ?";
        String[] whereArgs = new String[]{String.valueOf(position + 1)};
        db.delete(MyHelper.TABLE_NAME, whereClause, whereArgs);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
