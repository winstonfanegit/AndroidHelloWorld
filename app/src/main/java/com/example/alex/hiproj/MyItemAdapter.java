package com.example.alex.hiproj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by winston on 11/18/2017.
 */

public class MyItemAdapter extends BaseAdapter {

    List<String> items;
    List<String> descriptions;
    List<String> prices;
    LayoutInflater myInflater;

    public MyItemAdapter(Context ctx, List<String> items, List<String> descs, List<String> prices){
        myInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = items;
        this.descriptions = descs;
        this.prices = prices;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = myInflater.inflate(R.layout.my_listview_details, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView descTextView = (TextView) v.findViewById(R.id.descriptionTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);

        nameTextView.setText(items.get(i));
        descTextView.setText(descriptions.get(i));
        priceTextView.setText(prices.get(i));
        return v;
    }
}
