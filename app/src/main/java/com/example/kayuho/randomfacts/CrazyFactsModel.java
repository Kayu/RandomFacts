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

    public String getFacts(Context context,String type){
        FactsDBHelper MyDB = new FactsDBHelper(context);
        data = MyDB.getSpecificFactsType(type);
        this.covertCursorToString();
        return (new RandomFacts().getnewFacts(facts));
    }

    public void covertCursorToString(){
        for(data.moveToFirst(); !data.isAfterLast();data.moveToNext()){
            facts.add(data.getString(0));
        }
    }
}
