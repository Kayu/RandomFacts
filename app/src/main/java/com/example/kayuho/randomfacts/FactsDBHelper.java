package com.example.kayuho.randomfacts;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.io.FileNotFoundException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Created by kayuho on 2016-02-08.
 */
public class FactsDBHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "facts.db";
    private static final int DATABASE_VERSION = 1;
    private String DROP_TABLE = "DROP TABLE IF EXISTS " + FactContract.FactsEntry.TABLE_NAME;
    private String FactsTable = "create table if not exists "
            + FactContract.FactsEntry.TABLE_NAME + " ( "
            + BaseColumns._ID + " integer primary key autoincrement, "
            + FactContract.FactsEntry.COLUMN_FACT + " text, "
            + FactContract.FactsEntry.COLUMN_TYPE + " text);";
    private SQLiteDatabase db;
    public FactsDBHelper(Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(FactsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean insert(String fact, String type){

        ContentValues values = new ContentValues(2);
        values.put(FactContract.FactsEntry.COLUMN_FACT, fact);
        values.put(FactContract.FactsEntry.COLUMN_TYPE,type);
        db = this.getWritableDatabase();
        long successful = db.insert(FactContract.FactsEntry.TABLE_NAME, null, values);
        db.close();
        return (successful > 0);
    }

    public Cursor getAllData(){
        db = this.getWritableDatabase();
        final String retrieveQuery="SELECT * FROM "+ FactContract.FactsEntry.TABLE_NAME;
        Cursor data = db.rawQuery(retrieveQuery, null);
        return data;
    }

    //TODO finish getting the specific fact type
    public Cursor getSpecificFactsType(String type){
        db = this.getWritableDatabase();
        final String retrieveQuery= "SELECT "+ FactContract.FactsEntry.COLUMN_FACT
                                  + " FROM "+ FactContract.FactsEntry.TABLE_NAME
                                  + " WHERE "+ FactContract.FactsEntry.COLUMN_TYPE
                                  + " = '" + type+"';";
        Cursor data = db.rawQuery(retrieveQuery,null);
        return data;
    }

    public void deleteAll(){
        db = this.getWritableDatabase();
        db.execSQL(DROP_TABLE);

        db.execSQL(FactsTable);
        db.close();

    }

    public int getDBVersion(){
        return DATABASE_VERSION;
    }
}
