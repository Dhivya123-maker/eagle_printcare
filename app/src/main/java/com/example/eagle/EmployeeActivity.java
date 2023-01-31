package com.example.eagle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class EmployeeActivity extends AppCompatActivity {
    TextInputLayout textInputLayout,textInputLayout1;
    TextView forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        forget =  findViewById(R.id.forget_txt);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeActivity.this,ForgetPassword.class);
                startActivity(intent);
            }
        });



        textInputLayout = findViewById(R.id.user1);
        textInputLayout1 = findViewById(R.id.pass_edt1);
        textInputLayout.setStartIconTintList(ContextCompat.getColorStateList(this,R.color.purple_700));
        textInputLayout1.setStartIconTintList(ContextCompat.getColorStateList(this,R.color.purple_700));


    }
}