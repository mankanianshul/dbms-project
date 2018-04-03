package com.example.user.bhak;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.bhak.data.Product3DbHelper;
import com.example.user.bhak.data.Product4DbHelper;
import com.example.user.bhak.data.ProductContract;

public class Product4Editor extends AppCompatActivity {

    private EditText mDescription, mColor, mPrice, mStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product4_editor);
        mDescription = (EditText) findViewById(R.id.edit_product_description);
        mColor = (EditText) findViewById(R.id.edit_product_color);
        mPrice = (EditText) findViewById(R.id.edit_product_price);
        mStock = (EditText) findViewById(R.id.edit_product_stock);
    }


    public void insertproduct() {
        String descriptionString = mDescription.getText().toString().trim();
        String colorString = mColor.getText().toString().trim();
        int priceInteger = Integer.parseInt(mPrice.getText().toString().trim());
        int stockInteger = Integer.parseInt(mStock.getText().toString().trim());

        Product4DbHelper mDbHelper = new Product4DbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ProductContract.Product4Entry.COLUMN_PRODUCT4_DESCRIPTION, descriptionString);
        values.put(ProductContract.Product4Entry.COLUMN_PRODUCT4_COLOR, colorString);
        values.put(ProductContract.Product4Entry.COLUMN_PRODUCT4_PRICE, priceInteger);
        values.put(ProductContract.Product4Entry.COLUMN_PRODUCT4_STOCK, stockInteger);

        long row = db.insert(ProductContract.Product4Entry.TABLE_NAME, null, values);

        if (row != -1)
            Toast.makeText(this, "Item added", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Item cannot be added", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                insertproduct();
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
