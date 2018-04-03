package com.example.user.bhak;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.bhak.data.CartDbHelper;
import com.example.user.bhak.data.ProductContract;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {

    ListView listView;
    CartDbHelper mDbHelper;
    ArrayList<Pass> arrayList=new ArrayList<Pass>();
    PassAdapter mAdapter;
    int price=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        mDbHelper=new CartDbHelper(this);
        listView=(ListView)findViewById(R.id.cart_list);
        displayInfo();
        TextView t1=(TextView)findViewById(R.id.final_price);
        String finalprice=Integer.toString(price);
        t1.setText(finalprice.toString());
    }

    public void placeorder(View view){
        SQLiteDatabase db=mDbHelper.getWritableDatabase();
        db.execSQL("delete from "+ ProductContract.CartEntry.TABLE_NAME);
        Toast.makeText(this,"Order placed",Toast.LENGTH_LONG).show();
        Intent i=new Intent(this,ProductList.class);
        startActivity(i);
    }


    public void displayInfo(){

        SQLiteDatabase db=mDbHelper.getReadableDatabase();

        String[] projection={
                ProductContract.CartEntry._ID,
                ProductContract.CartEntry.COLUMN_CART_DESCRIPTION,
                ProductContract.CartEntry.COLUMN_CART_COLOR,
                ProductContract.CartEntry.COLUMN_CART_PRICE,
                ProductContract.CartEntry.COLUMN_CART_STOCK
        };

        Cursor cursor=db.query(
                ProductContract.CartEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        try{

            int idColumnIndex=cursor.getColumnIndex(ProductContract.CartEntry._ID);
            int descriptionColumnIndex=cursor.getColumnIndex(ProductContract.CartEntry.COLUMN_CART_DESCRIPTION);
            int colorColumnIndex=cursor.getColumnIndex(ProductContract.CartEntry.COLUMN_CART_COLOR);
            int priceColumnIndex=cursor.getColumnIndex(ProductContract.CartEntry.COLUMN_CART_PRICE);
            int stockColumnIndex=cursor.getColumnIndex(ProductContract.CartEntry.COLUMN_CART_STOCK);

            price=0;
            while(cursor.moveToNext()){
                int id=cursor.getInt(idColumnIndex);
                String description=cursor.getString(descriptionColumnIndex);
                String color1=cursor.getString(colorColumnIndex);
                int pprice=cursor.getInt(priceColumnIndex);
                int stock=cursor.getInt(stockColumnIndex);

                arrayList.add(new Pass(Integer.toString(id),description,color1,Integer.toString(pprice),Integer.toString(stock)));
                mAdapter=new PassAdapter(this,arrayList);
                listView.setAdapter(mAdapter);

                price+=pprice;
            }
        }finally {
            cursor.close();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cart, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete_data:
                Intent i=new Intent(this,ShoppingCartDelete.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
