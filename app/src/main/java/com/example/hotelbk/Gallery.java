package com.example.hotelbk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Gallery extends AppCompatActivity {

    ImageView mimage1;
    ImageView mimage2;
    ImageView mimage3;
    ImageView mimage4;
    ImageView mimage5;
    ImageView mimage6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mimage1 = (ImageView) findViewById(R.id.imageView);
        mimage2 = (ImageView) findViewById(R.id.imageView2);
        mimage3 = (ImageView) findViewById(R.id.imageView3);
        mimage4 = (ImageView) findViewById(R.id.imageView4);
        mimage5 = (ImageView) findViewById(R.id.imageView5);
        mimage6 = (ImageView) findViewById(R.id.imageView6);

        mimage1.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(Gallery.this,gal5.class);
            startActivity(intentLoadNewActivity);
        });
        mimage2.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(Gallery.this,gal1.class);
            startActivity(intentLoadNewActivity);
        });

        mimage3.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(Gallery.this,gal3.class);
            startActivity(intentLoadNewActivity);
        });

        mimage4.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(Gallery.this,gal4.class);
            startActivity(intentLoadNewActivity);
        });
        mimage5.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(Gallery.this,gal6.class);
            startActivity(intentLoadNewActivity);
        });
        mimage6.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(Gallery.this,gal2.class);
            startActivity(intentLoadNewActivity);
        });

    }
}