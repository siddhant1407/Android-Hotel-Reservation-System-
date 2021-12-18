package com.example.hotelbk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;
    Button myImageButton4;
    Button myImageButton3;
    Button myImageButton6;
    Button myImageButton5;
    Button myImageButton;
    Button myImageButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int images[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3};

        v_flipper = findViewById(R.id.v_flipper);

        myImageButton4= (Button) findViewById(R.id.Button4);
        myImageButton3= (Button) findViewById(R.id.Button3);
        myImageButton6= (Button) findViewById(R.id.Button6);
        myImageButton5= (Button) findViewById(R.id.Button5);
        myImageButton= (Button) findViewById(R.id.Button);
        myImageButton2= (Button) findViewById(R.id.Button2);

        myImageButton4.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(MainActivity.this,facilities.class);
            startActivity(intentLoadNewActivity);
        });
        myImageButton2.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(MainActivity.this,ContactUs.class);
            startActivity(intentLoadNewActivity);
        });
        myImageButton3.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(MainActivity.this,roomrates.class);
            startActivity(intentLoadNewActivity);
        });
        myImageButton5.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(MainActivity.this,Gallery.class);
            startActivity(intentLoadNewActivity);
        });
        myImageButton6.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(MainActivity.this,location.class);
            startActivity(intentLoadNewActivity);
        });
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this,Reservation.class);
                startActivity(intentLoadNewActivity);
            }
        });

        for(int i =0;i< images.length;i++){
            flipperImages(images[i]);
        }
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(2000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
    }


}