package com.example.sqllitecrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "studentDB";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE students(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "age INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);
    }

    // INSERT DATA
    public boolean insertData(String name, String age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("age", age);

        long result = db.insert("students", null, cv);
        return result != -1;
    }

    // FETCH ALL DATA
    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM students", null);
    }

    // UPDATE DATA
    public boolean updateData(String id, String name, String age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("age", age);

        int result = db.update("students", cv, "id=?", new String[]{id});
        return result > 0;
    }

    // DELETE DATA
    public int deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("students", "id=?", new String[]{id});
    }
}
