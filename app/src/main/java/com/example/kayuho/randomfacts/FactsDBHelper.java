package com.example.kayuho.randomfacts;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.io.FileNotFoundException;
import java.util.Objects;

/**
 * Created by kayuho on 2016-02-08.
 */
public class FactsDBHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "facts.db";
    private static final int DATABASE_VERSION = 1;
    private String DROP_TABLE = "DROP TABLE IF EXISTS " + FactContract.FactsEntry.TABLE_NAME;
    SQLiteDatabase db;
    public FactsDBHelper(Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
       String FactsTable = "create table if not exists "
                + FactContract.FactsEntry.TABLE_NAME + " ( "
                + BaseColumns._ID + " integer primary key autoincrement, "
                + FactContract.FactsEntry.COLUMN_FACT + " text);";
        db.execSQL(FactsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean insert(String fact){

        ContentValues values = new ContentValues();
        values.put(FactContract.FactsEntry.COLUMN_FACT, fact);
        SQLiteDatabase db = this.getWritableDatabase();
        long successful = db.insert(FactContract.FactsEntry.TABLE_NAME, null, values);
        db.close();
        return (successful > 0);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        final String retrieveQuery="SELECT * FROM "+ FactContract.FactsEntry.TABLE_NAME;
        Cursor data = db.rawQuery(retrieveQuery, null);
        return data;
    }

    public boolean deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        long successful = db.delete(FactContract.FactsEntry.TABLE_NAME, null, null);
        return (successful > 0);
    }

    public int getDBVersion(){
        return DATABASE_VERSION;
    }
}
