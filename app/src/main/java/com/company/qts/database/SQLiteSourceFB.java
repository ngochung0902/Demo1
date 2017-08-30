package com.company.qts.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.company.qts.object.Football;

import java.util.ArrayList;

/**
 * Created by MyPC on 29/08/2017.
 */
public class SQLiteSourceFB {

        private SQLiteOpenHelper sqLiteOpenHelperfb;
        private SQLiteDatabase sqLiteDatabasefb;
        private String[] allColumns = {SQLiteFB.COLUMN_ID,SQLiteFB.COLUMN_IMAGE,SQLiteFB.COLUMN_NAME,SQLiteFB.COLUMN_CLUB,SQLiteFB.COLUMN_AGE};
        private Context context;

        public SQLiteSourceFB(Context context) {
            this.context = context;
            sqLiteOpenHelperfb = new SQLiteFB(context);
        }

        public void open() throws SQLiteException
        {
            sqLiteDatabasefb = sqLiteOpenHelperfb.getWritableDatabase();
        }
        public void close() throws SQLiteException
        {
            sqLiteOpenHelperfb.close();
        }
        // add new note to dairy
        public void add(String image, String name, String club, String age)
        {

            ContentValues values = new ContentValues();
            values.put(SQLiteFB.COLUMN_IMAGE, image);
            values.put(SQLiteFB.COLUMN_NAME, name);
            values.put(SQLiteFB.COLUMN_CLUB,club);
            values.put(SQLiteFB.COLUMN_AGE, age);
            // insert
            sqLiteDatabasefb.insert(SQLiteFB.TABLE_NAME,null,values);
        }
        // delete note
        public void deleteNote(int id)
        {
            sqLiteDatabasefb.delete(SQLiteFB.TABLE_NAME, SQLiteFB.COLUMN_ID + "=" + id,null);
            Toast.makeText(this.context,"delete note success",Toast.LENGTH_LONG).show();
        }

        public int count()
        {
            String selectQuery = "SELECT COUNT (*) FROM " + SQLiteFB.TABLE_NAME;

            return a;
        }


//        public void show ()
//        {
//            String selectQuery = "SELECT  * FROM " + SQLiteFB.TABLE_NAME + "limit '2' offset '3'" ;
//            sqLiteDatabasefb.query("football",allColumns,null,null);
//
//        }

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

    int a =8;
    int b =0;

    public ArrayList<Football> getloadmore(int a,int b)
    {
        ArrayList<Football> arr = new ArrayList<Football>();
        String selectQuery = "SELECT ID,image,name,club,age FROM " + SQLiteFB.TABLE_NAME + " limit "+a+ " offset "+b;
        Cursor cursor = sqLiteDatabasefb.rawQuery(selectQuery,null);//"football",allColumns,null,null,null,null,null);

        if(cursor == null)
        {
            return null;
        }
        // having notes
        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            Football model = cursorToModel(cursor);
            arr.add(model);
            cursor.moveToNext();
        }
        return arr;
    }
        public ArrayList<Football> getAllContacts()
        {
            ArrayList<Football> arr = new ArrayList<Football>();

            Cursor cursor = sqLiteDatabasefb.query("football",allColumns,null,null,null,null,null);

            if(cursor == null)
            {
                return null;
            }
            // having notes
            cursor.moveToFirst();

            while(!cursor.isAfterLast())
            {
                Football model = cursorToModel(cursor);
                arr.add(model);
                cursor.moveToNext();
            }
            return arr;
        }

        // get NoteModel from cursor
        private Football cursorToModel(Cursor cursor)
        {
            Football model = new Football();
            model.ID = cursor.getInt(0);
            model.image = cursor.getString(1);
            model.name = cursor.getString(2);
            model.club = cursor.getString(3);
            model.age = cursor.getString(4);

            return model;
        }
}
