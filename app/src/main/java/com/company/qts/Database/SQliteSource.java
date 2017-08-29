package com.company.qts.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.company.qts.object.Contacts;

import java.util.ArrayList;

/**
 * Created by MyPC on 03/08/2017.
 */
public class SQLiteSource {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    private String[] allColumns = {SQLiteCT.COLUMN_ID, SQLiteCT.COLUMN_FISTNAME, SQLiteCT.COLUMN_LASTNAME, SQLiteCT.COLUMN_BIRTHDAY, SQLiteCT.COLUMN_PHONE};
    private Context context;

    public SQLiteSource(Context context) {
        this.context = context;
        sqLiteOpenHelper = new SQLiteCT(context);
    }

    public void open() throws SQLiteException
    {
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }
    public void close() throws SQLiteException
    {
        sqLiteOpenHelper.close();
    }
    // add new note to dairy
    public void add(String fistname, String lastname, String birthday, String phone)
    {

        ContentValues values = new ContentValues();
        values.put(SQLiteCT.COLUMN_FISTNAME, fistname);
        values.put(SQLiteCT.COLUMN_LASTNAME, lastname);
        values.put(SQLiteCT.COLUMN_PHONE,birthday);
        values.put(SQLiteCT.COLUMN_BIRTHDAY, phone);
        // insert
        sqLiteDatabase.insert(SQLiteCT.TABLE_NAME,null,values);
    }
    // delete note
    public void deleteNote(int id)
    {
        sqLiteDatabase.delete(SQLiteCT.TABLE_NAME, SQLiteCT.COLUMN_ID + "=" + id,null);
        Toast.makeText(this.context,"delete note success",Toast.LENGTH_LONG).show();
    }

//    public void updatephone(int id, String new_phone){
//        ContentValues values = new ContentValues();
//        values.put(SQLiteCT.COLUMN_PHONE, new_phone);
//        int ret =sqLiteDatabase.update(SQLiteCT.TABLE_NAME,values,SQLiteCT.COLUMN_ID + "=" + id, new String[]{phone});
//        if (ret==0){
//            Log.i("update data","update that bai");
//        }
//        else {
//            Log.i("update data","update thanh cong");
//        }
//    }

    public ArrayList<Contacts> getAllContacts()
    {
        ArrayList<Contacts> arr = new ArrayList<Contacts>();

        Cursor cursor = sqLiteDatabase.query("contacts",allColumns,null,null,null,null,null);

        if(cursor == null)
        {
            return null;
        }
        // having notes
        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            Contacts model = cursorToModel(cursor);
            arr.add(model);
            cursor.moveToNext();
        }
        return arr;
    }

    // get NoteModel from cursor
    private Contacts cursorToModel(Cursor cursor)
    {
        Contacts model = new Contacts();
        model.Id = cursor.getInt(0);
        model.fistname = cursor.getString(1);
        model.lastname = cursor.getString(2);
        model.birthday = cursor.getString(3);
        model.number = cursor.getString(4);

        return model;
    }
}
