package com.company.qts.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MyPC on 03/08/2017.
 */
public class SQLite extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contacts.db";
    public static final String TABLE_NAME = "contacts";
    // columns
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FISTNAME = "fistname";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_BIRTHDAY = "birthday";
    // DB info
    public static final int DATABASE_VERSION = 1;
    private static final String CREATE_DATABASE = "CREATE TABLE "   + TABLE_NAME + "( "
            + COLUMN_ID + " INTEGER PRIMARY KEY  autoincrement,"
            + COLUMN_FISTNAME + " text not null,"
            + COLUMN_LASTNAME + " text not null, "
            + COLUMN_PHONE+" text not null,"
            + COLUMN_BIRTHDAY + " text);";
    public SQLite(Context context) {
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

    public void upd(int id,String namemoi){
        this.getWritableDatabase().execSQL("UPDATE contacts SET phone='"+namemoi+"'WHERE id='"+id+"'");
    }
}
