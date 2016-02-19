package com.example.kayuho.randomfacts;

import android.provider.BaseColumns;

/**
 * Created by kayuho on 2016-02-08.
 */
public class FactContract {

    public static final class FactsEntry implements BaseColumns{
        public static final String TABLE_NAME = "facts";
        public static final String COLUMN_FACT = "fact";
        public static final String COLUMN_TYPE = "type";

    }
}
