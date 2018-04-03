package com.example.user.bhak.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 4/8/2017.
 */

public class Product1DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "flipkart.db";
    private static final int DATABASE_VERSION = 1;

    public Product1DbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the table
        String SQL_CREATE_TABLE =  "CREATE TABLE " + ProductContract.Product1Entry.TABLE_NAME + " ("
                + ProductContract.Product1Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProductContract.Product1Entry.COLUMN_PRODUCT1_DESCRIPTION + " TEXT NOT NULL, "
                + ProductContract.Product1Entry.COLUMN_PRODUCT1_COLOR + " TEXT, "
                + ProductContract.Product1Entry.COLUMN_PRODUCT1_PRICE + " INTEGER NOT NULL, "
                + ProductContract.Product1Entry.COLUMN_PRODUCT1_STOCK + " INTEGER );";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
