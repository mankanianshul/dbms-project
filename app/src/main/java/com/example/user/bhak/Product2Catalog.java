package com.example.user.bhak;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.bhak.data.CartDbHelper;
import com.example.user.bhak.data.Product2DbHelper;
import com.example.user.bhak.data.ProductContract;

import java.util.ArrayList;

public class Product2Catalog extends AppCompatActivity {

    ListView listView;
    Product2DbHelper mDbHelper2;
    PassAdapter mAdapter;
    ArrayList<Pass> arrayList=new ArrayList<Pass>();
    CartDbHelper mCartDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product2_catalog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mDbHelper2 =new Product2DbHelper(this);
        mCartDb=new CartDbHelper(this);
        listView=(ListView)findViewById(R.id.list_product2);

        arrayList.add(new Pass("9","j","9","90","40"));
        mAdapter=new PassAdapter(this,arrayList);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pass current=mAdapter.getItem(position);
                if(Integer.parseInt(current.getStock())>0) {
                    SQLiteDatabase db = mCartDb.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(ProductContract.CartEntry.COLUMN_CART_DESCRIPTION, current.getDescription());
                    values.put(ProductContract.CartEntry.COLUMN_CART_COLOR, current.getColor());
                    values.put(ProductContract.CartEntry.COLUMN_CART_PRICE, Integer.parseInt(current.getPrice()));
                    values.put(ProductContract.CartEntry.COLUMN_CART_STOCK, Integer.parseInt(current.getStock()));

                    long row = db.insert(ProductContract.CartEntry.TABLE_NAME, null, values);

                    if (row != -1)
                        Toast.makeText(Product2Catalog.this, "Item added to cart", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Product2Catalog.this, "Item cannot be added to cart", Toast.LENGTH_LONG).show();

                    SQLiteDatabase db1 = mDbHelper2.getWritableDatabase();
                    String query = "update " + ProductContract.Product2Entry.TABLE_NAME
                            + " set stock=stock - 1 where " + ProductContract.Product2Entry._ID + " = " + current.getId();
                    db1.execSQL(query);
                }
                else {
                    Toast.makeText(Product2Catalog.this,"Out of stock",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        arrayList.clear();
        mAdapter.notifyDataSetChanged();
        displayInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    public void displayInfo(){

        SQLiteDatabase db= mDbHelper2.getReadableDatabase();

        String[] projection={
                ProductContract.Product2Entry._ID,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_DESCRIPTION,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_COLOR,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_PRICE,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_STOCK
        };

        Cursor cursor=db.query(
                ProductContract.Product2Entry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        try{

            int idColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry._ID);
            int descriptionColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_DESCRIPTION);
            int colorColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_COLOR);
            int priceColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_PRICE);
            int stockColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_STOCK);

            while(cursor.moveToNext()){
                int id=cursor.getInt(idColumnIndex);
                String description=cursor.getString(descriptionColumnIndex);
                String color1=cursor.getString(colorColumnIndex);
                int price=cursor.getInt(priceColumnIndex);
                int stock=cursor.getInt(stockColumnIndex);


                arrayList.add(new Pass(Integer.toString(id),description,color1,Integer.toString(price),Integer.toString(stock)));
                mAdapter=new PassAdapter(this,arrayList);
                listView.setAdapter(mAdapter);

            }
        }finally {
            cursor.close();
        }
    }

    public void priceHightoLow(){

        SQLiteDatabase db= mDbHelper2.getReadableDatabase();

        String[] projection={
                ProductContract.Product2Entry._ID,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_DESCRIPTION,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_COLOR,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_PRICE,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_STOCK
        };

        Cursor cursor=db.query(
                ProductContract.Product2Entry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_PRICE+" DESC"
        );

        try{

            int idColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry._ID);
            int descriptionColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_DESCRIPTION);
            int colorColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_COLOR);
            int priceColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_PRICE);
            int stockColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_STOCK);

            while(cursor.moveToNext()){
                int id=cursor.getInt(idColumnIndex);
                String description=cursor.getString(descriptionColumnIndex);
                String color1=cursor.getString(colorColumnIndex);
                int price=cursor.getInt(priceColumnIndex);
                int stock=cursor.getInt(stockColumnIndex);


                arrayList.add(new Pass(Integer.toString(id),description,color1,Integer.toString(price),Integer.toString(stock)));
                mAdapter=new PassAdapter(this,arrayList);
                listView.setAdapter(mAdapter);

            }
        }finally {
            cursor.close();
        }
    }



    public void priceLowToHigh(){

        SQLiteDatabase db= mDbHelper2.getReadableDatabase();

        String[] projection={
                ProductContract.Product2Entry._ID,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_DESCRIPTION,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_COLOR,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_PRICE,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_STOCK
        };

        Cursor cursor=db.query(
                ProductContract.Product2Entry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                ProductContract.Product2Entry.COLUMN_PRODUCT2_PRICE+" ASC"
        );

        try{

            int idColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry._ID);
            int descriptionColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_DESCRIPTION);
            int colorColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_COLOR);
            int priceColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_PRICE);
            int stockColumnIndex=cursor.getColumnIndex(ProductContract.Product2Entry.COLUMN_PRODUCT2_STOCK);

            while(cursor.moveToNext()){
                int id=cursor.getInt(idColumnIndex);
                String description=cursor.getString(descriptionColumnIndex);
                String color1=cursor.getString(colorColumnIndex);
                int price=cursor.getInt(priceColumnIndex);
                int stock=cursor.getInt(stockColumnIndex);


                arrayList.add(new Pass(Integer.toString(id),description,color1,Integer.toString(price),Integer.toString(stock)));
                mAdapter=new PassAdapter(this,arrayList);
                listView.setAdapter(mAdapter);

            }
        }finally {
            cursor.close();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_insert_data:
                Intent i7=new Intent(this,Product2Editor.class);
                startActivity(i7);
                return true;
            case R.id.action_go_to_cart:
                Intent i2=new Intent(this,ShoppingCart.class);
                startActivity(i2);
                return true;

            case R.id.action_delete_entries:
                Intent i1=new Intent(this,Product2Delete.class);
                startActivity(i1);
                return true;


            case R.id.action_high_to_low:
                arrayList.clear();
                mAdapter.notifyDataSetChanged();
                priceHightoLow();
                return true;

            case R.id.action_low_to_high:
                arrayList.clear();
                mAdapter.notifyDataSetChanged();
                priceLowToHigh();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
