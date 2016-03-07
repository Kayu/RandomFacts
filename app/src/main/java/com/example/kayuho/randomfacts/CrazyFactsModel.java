package com.example.kayuho.randomfacts;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kayuho on 2016-02-08.
 */
public class CrazyFactsModel {

    private List<String> facts = new ArrayList<String>();
    private Cursor data;
    private String type;

    //getFact method accept 2 arguments: Context and String
    public String getFacts(Context context,String type){
        //Create a FactsDBHelper Object
        FactsDBHelper MyDB = new FactsDBHelper(context);
        //get a specific data from database
        data = MyDB.getSpecificFactsType(type);
        //calls the cursor to string method
        this.covertCursorToString();
        //return data
        return (new RandomFacts().getnewFacts(facts));
    }

    public void covertCursorToString(){
        // a for loop that covert all the cursors  to string
        for(data.moveToFirst(); !data.isAfterLast();data.moveToNext()){
            facts.add(data.getString(0));
        }
    }
}
