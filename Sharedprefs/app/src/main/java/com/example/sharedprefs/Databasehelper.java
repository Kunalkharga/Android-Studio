package com.example.sharedprefs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper{
    public Databasehelper(@androidx.annotation.Nullable Context context) {
        super(context, "studentdb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(id integer primary key autoincrement,"+
                "name varchar(20), address text, faculty text)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
