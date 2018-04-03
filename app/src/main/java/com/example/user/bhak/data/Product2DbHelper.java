package com.example.user.bhak.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 4/8/2017.
 */

public class Product2DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "flipkart2.db";
    private static final int DATABASE_VERSION = 1;

    public Product2DbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE =  "CREATE TABLE " + ProductContract.Product2Entry.TABLE_NAME + " ("
                + ProductContract.Product2Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProductContract.Product2Entry.COLUMN_PRODUCT2_DESCRIPTION + " TEXT NOT NULL, "
                + ProductContract.Product2Entry.COLUMN_PRODUCT2_COLOR + " TEXT, "
                + ProductContract.Product2Entry.COLUMN_PRODUCT2_PRICE + " INTEGER NOT NULL, "
                + ProductContract.Product2Entry.COLUMN_PRODUCT2_STOCK + " INTEGER );";

        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
