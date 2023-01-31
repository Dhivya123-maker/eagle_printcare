package com.example.eagle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.jsibbold.zoomage.ZoomageView;


public class FullViewImage extends AppCompatActivity {

    ZoomageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view_image);

        image = findViewById(R.id.image);

        Intent i = getIntent();



        if(this !=null) {
            Glide.with(getApplicationContext()).load(i.getStringExtra("image")).into(image);
        }

    }
}