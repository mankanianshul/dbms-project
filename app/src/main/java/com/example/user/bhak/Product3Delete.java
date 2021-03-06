package com.example.user.bhak;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.bhak.data.Product2DbHelper;
import com.example.user.bhak.data.Product3DbHelper;
import com.example.user.bhak.data.ProductContract;

public class Product3Delete extends AppCompatActivity {

    EditText mDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product1_delete);

        mDelete=(EditText)findViewById(R.id.edit_product_delete);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    private void deletedata(){

        int idInt=Integer.parseInt(mDelete.getText().toString());
        // Create database helper
        Product3DbHelper mDbHelper = new Product3DbHelper(this);


        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        long row=db.delete(ProductContract.Product3Entry.TABLE_NAME, ProductContract.Product3Entry._ID+" = "+idInt,null);
        db.close();

        if (row == -1) {
            // If the row ID is -1, then there was an error with deletion.
            Toast.makeText(this, "Error with deleting item", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the deletion was successful and we can display a toast.
            Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            case R.id.action_save:
                deletedata();
                Intent i=new Intent(this,Product3Catalog.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
