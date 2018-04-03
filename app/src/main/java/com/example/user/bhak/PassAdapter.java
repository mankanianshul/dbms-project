package com.example.user.bhak;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 4/6/2017.
 */

public class PassAdapter extends ArrayAdapter<Pass> {

    public PassAdapter(Activity context, ArrayList<Pass> e){
        super(context,0,e);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if (listView == null)
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        Pass current = getItem(position);

        TextView t1=(TextView)listView.findViewById(R.id.description);
        t1.setText(current.getDescription());

        TextView t2=(TextView)listView.findViewById(R.id.color);
        t2.setText(current.getColor());

        TextView t3=(TextView)listView.findViewById(R.id.price);
        t3.setText("Rs "+current.getPrice());

        TextView t4=(TextView)listView.findViewById(R.id.stock_quantity);
        t4.setText("In Stock:"+current.getStock());

        TextView t5=(TextView)listView.findViewById(R.id.product_id);
        t5.setText(current.getId().toString());

        return listView;
    }

    
}
