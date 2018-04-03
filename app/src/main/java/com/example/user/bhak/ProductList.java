package com.example.user.bhak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ProductList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
    }

    public void gotoproduct1(View view){
        Intent i=new Intent(this,Product1Catalog.class);
        startActivity(i);
    }

    public void gotoproduct2(View view){
        Intent i=new Intent(this,Product2Catalog.class);
        startActivity(i);
    }

    public void gotoproduct3(View view){
        Intent i=new Intent(this,Product3Catalog.class);
        startActivity(i);
    }

    public void gotoproduct4(View view){
        Intent i=new Intent(this,Product4Catalog.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_log_out:
                Intent i=new Intent(this,MainActivity.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
