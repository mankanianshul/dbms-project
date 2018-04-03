package com.example.user.bhak.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 4/9/2017.
 */
public class Product4DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "flipkart4.db";
    private static final int DATABASE_VERSION = 2;

    public Product4DbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE =  "CREATE TABLE " + ProductContract.Product4Entry.TABLE_NAME + " ("
                + ProductContract.Product4Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProductContract.Product4Entry.COLUMN_PRODUCT4_DESCRIPTION + " TEXT NOT NULL, "
                + ProductContract.Product4Entry.COLUMN_PRODUCT4_COLOR + " TEXT, "
                + ProductContract.Product4Entry.COLUMN_PRODUCT4_PRICE + " INTEGER NOT NULL, "
                + ProductContract.Product4Entry.COLUMN_PRODUCT4_STOCK + " INTEGER );";

        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}

