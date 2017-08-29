package com.company.qts.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MyPC on 29/08/2017.
 */
public class SQLiteFB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "football.db";
    public static final String TABLE_NAME = "football";
    // columns
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CLUB = "club";
    public static final String COLUMN_AGE = "age";
    // DB info
    public static final int DATABASE_VERSION = 1;
    private static final String CREATE_DATABASE = "CREATE TABLE "   + TABLE_NAME + "( "
            + COLUMN_ID + " INTEGER PRIMARY KEY  autoincrement,"
            + COLUMN_NAME + " text not null,"
            + COLUMN_CLUB +" text not null,"
            + COLUMN_AGE +" text not null,"
            + COLUMN_IMAGE + " text);";
    public SQLiteFB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        onCreate(db);
    }
}
