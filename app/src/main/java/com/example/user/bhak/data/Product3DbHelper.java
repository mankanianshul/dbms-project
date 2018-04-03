package com.example.user.bhak.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 4/9/2017.
 */

public class Product3DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "flipkart3.db";
    private static final int DATABASE_VERSION = 2;

    public Product3DbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE =  "CREATE TABLE " + ProductContract.Product3Entry.TABLE_NAME + " ("
                + ProductContract.Product3Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProductContract.Product3Entry.COLUMN_PRODUCT3_DESCRIPTION + " TEXT NOT NULL, "
                + ProductContract.Product3Entry.COLUMN_PRODUCT3_COLOR + " TEXT, "
                + ProductContract.Product3Entry.COLUMN_PRODUCT3_PRICE + " INTEGER NOT NULL, "
                + ProductContract.Product3Entry.COLUMN_PRODUCT3_STOCK + " INTEGER );";

        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
