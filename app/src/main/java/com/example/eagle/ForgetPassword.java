package com.example.eagle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ForgetPassword extends AppCompatActivity {
    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;
    Button send;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        textInputEditText = findViewById(R.id.forget_edit);



        send = findViewById(R.id.send_otp_btn);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(textInputEditText.getText().toString().matches(emailPattern)){
                    Intent intent = new Intent(ForgetPassword.this, OTPActivity.class);
                    String email = textInputEditText.getText().toString();
                    intent.putExtra("email", email);
                    startActivity(intent);


                }else {
                    Toast.makeText(ForgetPassword.this, "Please enter valid email address", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textInputLayout = findViewById(R.id.forget);
        textInputLayout.setStartIconTintList(ContextCompat.getColorStateList(this,R.color.purple_700));
    }
}