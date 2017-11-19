package com.example.alex.hiproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int imgIdx = getIntent().getIntExtra("com.example.alex.hiproj.itemIdex", -1);
        ImageView detailImageView = (ImageView) findViewById(R.id.myDetailImageView);
        detailImageView.setImageResource(getImage(imgIdx));
    }

    private int getImage(int index){
        if (index == 0) return R.drawable.apple;
        if (index == 1) return R.drawable.pear;
        if (index == 2) return R.drawable.pine;
        throw new RuntimeException("unknown index = " + index);
    }
}
