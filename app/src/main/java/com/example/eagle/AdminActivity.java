package com.example.eagle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.eagle.Customers.Customer_status;
import com.example.eagle.Dashboard.DashboardActivity;
import com.example.eagle.utils.Api;
import com.example.eagle.utils.PreferenceUtils;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class AdminActivity extends AppCompatActivity {

    EditText name,pass;
    Button login;
    TextView Error1,Error2;
    SpinKitView spinKitView;

    public static String  user_name = null;
    public static String password = null;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        name = findViewById(R.id.user);
        pass = findViewById(R.id.password);
        Error1 = findViewById(R.id.error1);
        Error2 = findViewById(R.id.error2);
        spinKitView = findViewById(R.id.progressBar);

//        Api a = new Api();
//        api = a.getBASE_URL();

        login = findViewById(R.id.adminsignin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinKitView.setVisibility(View.VISIBLE);
                Error1.setVisibility(View.GONE);
                Error2.setVisibility(View.GONE);
                Login();

//                String user_name = name .getText().toString();
//                String password = pass.getText().toString();


            }


        });



    }

    private void Login() {

          user_name = name .getText().toString();
          password = pass.getText().toString();


        Log.i("user_name",user_name);
        Log.i("jhdhdbkjhdbkqed",password);


//        if (user_name.isEmpty()) {
//            Error1.setText("The Email field is required");
//            Error1.setVisibility(View.VISIBLE);
//        } else if (password.isEmpty()) {
//            Error2.setText("The password field is required");
//            Error2.setVisibility(View.VISIBLE);
//
//        } else {





            final String URL = "http://eagle.spksystems.in/public/api/login";


            StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    spinKitView.setVisibility(View.GONE);
//                    Toast.makeText(AdminActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                            try {

//                                    JSONObject jsonObject = new JSONObject(response.toString());

                                String Success;
                                JSONObject data;

                                JSONObject object = new JSONObject(response);
//                                Toast.makeText(AdminActivity.this, "fcxgxdzfgbccfh"+response.toString(), Toast.LENGTH_SHORT).show();
//                                Log.i("response","fcxgxdzfgbccfh"+response);
                                Success = object.getString("success");
                                data = object.getJSONObject("data");

                                if (Success == "true") {


                                     token = data.getString("token");
                                    PreferenceUtils.saveTokan(token, AdminActivity.this);

                                    Intent intent = new Intent(AdminActivity.this, Customer_status.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

                                    startActivity(intent);


                                }

                                Log.i("rhg9y",token);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }


                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {



                            spinKitView.setVisibility(View.GONE);
//                            Toast.makeText(AdminActivity.this, error.toString(), Toast.LENGTH_SHORT).show();


                            try {
                                Charset charset = Charset.defaultCharset();
                                String str = new String(error.networkResponse.data,charset);
                                JSONObject jsonObject = new JSONObject(str);
                                JSONObject data = jsonObject.getJSONObject("data");

                                JSONArray jsonArray1 = data.getJSONArray("email");
                                Error1.setText(jsonArray1.getString(0));
                                Error1.setVisibility(View.VISIBLE);
//                            email.setError(jsonArray1.getString(0));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            try {
                                Charset charset = Charset.defaultCharset();
                                String str = new String(error.networkResponse.data,charset);
                                JSONObject jsonObject = new JSONObject(str);
                                JSONObject data = jsonObject.getJSONObject("data");

                                JSONArray jsonArray1 = data.getJSONArray("password");
                                Error2.setText(jsonArray1.getString(0));
                                Error2.setVisibility(View.VISIBLE);
//                            email.setError(jsonArray1.getString(0));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            try {
                                Charset charset = Charset.defaultCharset();
                                String str = new String(error.networkResponse.data,charset);
                                JSONObject jsonObject = new JSONObject(str);
                                JSONObject data = jsonObject.getJSONObject("data");

                                String errorall = data.getString("error");
                                Error2.setText(errorall);
                                Error2.setVisibility(View.VISIBLE);
//                            email.setError(jsonArray1.getString(0));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<String, String>();


                    params.put("email", user_name);
                    params.put("password", password);


                    return params;
                }
//
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("Accept", "application/json");
//                    params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(AdminActivity.this));


                    return params;
                }
            };


                jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                        10000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                RequestQueue requestQueue = Volley.newRequestQueue(AdminActivity.this);
        requestQueue.getCache().clear();
                requestQueue.add(jsonObjectRequest);


//        }


    }




}


