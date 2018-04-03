package com.example.user.bhak.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 4/8/2017.
 */
public class CartDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = CartDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "shoppingcart1.db";
    private static final int DATABASE_VERSION = 1;

    public CartDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the table
        String SQL_CREATE_CART_TABLE =  "CREATE TABLE " + ProductContract.CartEntry.TABLE_NAME + " ("
                + ProductContract.CartEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProductContract.CartEntry.COLUMN_CART_DESCRIPTION + " TEXT NOT NULL, "
                + ProductContract.CartEntry.COLUMN_CART_COLOR + " TEXT, "
                + ProductContract.CartEntry.COLUMN_CART_PRICE + " INTEGER NOT NULL, "
                + ProductContract.CartEntry.COLUMN_CART_STOCK +" INTEGER);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_CART_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}

