package com.example.eagle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class OTPActivity extends AppCompatActivity {
    TextInputLayout textInputLayout;
    Button btn;
    String data;
   TextView get_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpactivity);

        get_txt = findViewById(R.id.gmail_com);


        Intent intent = getIntent();
        data = intent.getStringExtra("email");
        get_txt.setText(data);


        btn = findViewById(R.id.verify_otp_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OTPActivity.this,ChangePassword.class);
                startActivity(intent);
            }
        });


    }
}