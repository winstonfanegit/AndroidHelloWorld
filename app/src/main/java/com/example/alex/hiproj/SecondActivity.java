package com.example.alex.hiproj;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ListView myListView;
    String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("myMessage")){
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(getIntent().getExtras().getString("myMessage"));
        }

        myListView = (ListView)findViewById(R.id.myListView);
        items = getResources().getStringArray(R.array.my_items);

        List<String> descs = Arrays.asList(new String[]{"something good", "no, it's good", "really good"});
        List<String> prices = Arrays.asList(new String[]{"6.09", "5.99","8.99"});
        List<String> itemLi = Arrays.asList(items);

//        myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_listview_details, items));

        // myListView doesn't know the myListViewDetails, it's the adapter who brings the detail view
        myListView.setAdapter(new MyItemAdapter(this, itemLi, descs, prices));

        final Context that = this;
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /// that or use getApplicationContext()
                Intent detailAct = new Intent(that, DetailActivity.class);
                detailAct.putExtra("com.example.alex.hiproj.itemIdex", i);
                startActivity(detailAct);
            }
        });

    }
}
