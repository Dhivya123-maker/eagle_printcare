package com.example.eagle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.eagle.Customers.Customer_status;
import com.example.eagle.Dashboard.DashboardActivity;
import com.example.eagle.Pending.Pending_Class;
import com.example.eagle.utils.PreferenceUtils;

public class SplashScreen extends AppCompatActivity {
    private final int SPLASH_TIME_OUT = 3350;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {


                if (PreferenceUtils.getTokan(SplashScreen.this) == null) {
                    Intent i = new Intent(SplashScreen.this, AdminActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(SplashScreen.this, Customer_status.class);
                    startActivity(i);
                }
                finish();

            }
        }, SPLASH_TIME_OUT);




    }
}