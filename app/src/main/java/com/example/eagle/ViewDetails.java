package com.example.eagle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.eagle.Pending.Pending_Adapter;
import com.example.eagle.Pending.Pending_Adapter_one;
import com.example.eagle.Pending.Pending_Class;
import com.example.eagle.Pending.Pending_Model;
import com.example.eagle.Pending.Pending_Model_one;
import com.example.eagle.utils.PreferenceUtils;
import com.github.ybq.android.spinkit.SpinKitView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewDetails extends AppCompatActivity {

    TextView Order_no,Customer,Company,Project_type,Order_type,Status,Current_stage,Cancel_reason,Remark,No_of_set,Coating,No_of_quantity,Date,Delivery_date,Job_title,Design_no,Mail_receive_date,Current_user;
    String order_no,customer,company,project_type,order_type,status,current_stage,design_file,job_card,cancel_reason,remark,no_of_set,coating,no_of_quantity,date,delivery_date,job_title,design_no,mail_receive_date,current_user;
    String id;
    ImageView Job_card,Design_file;
    LinearLayout cancel_layout,remark_layout;
    SpinKitView spinKitView;

    LinearLayout profile;

    RecyclerView recyclerView;

    List<Stage_model> stage_models;
    Stage_Adapter adapter;

    String user_name,email,phone,image="null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        Order_no = findViewById(R.id.order_no);
        Customer = findViewById(R.id.customer);
        Company = findViewById(R.id.company);
        Project_type = findViewById(R.id.project_type);
        Order_type = findViewById(R.id.order_type);
        Status = findViewById(R.id.status);
        Current_stage = findViewById(R.id.current_stage);
        Cancel_reason = findViewById(R.id.cancel_reason);
        Job_card = findViewById(R.id.job_card);
        Design_file = findViewById(R.id.design_file);
        cancel_layout = findViewById(R.id.cancel_lay);
        Remark = findViewById(R.id.remarks);
        remark_layout = findViewById(R.id.remark_lay);
        No_of_set  = findViewById(R.id.no_of_set);
        Coating = findViewById(R.id.coating);
        No_of_quantity = findViewById(R.id.no_of_quantity);
        Date = findViewById(R.id.date);
        Delivery_date = findViewById(R.id.delivery_date);
        Job_title = findViewById(R.id.job_title);
        Design_no = findViewById(R.id.design_no);
        recyclerView = findViewById(R.id.stages_recyclerview);
        profile = findViewById(R.id.profile);
        Mail_receive_date = findViewById(R.id.mail_receive_date);
        Current_user = findViewById(R.id.current_user);


        spinKitView = findViewById(R.id.progressBar);
        spinKitView.setVisibility(View.VISIBLE);

        Intent i = getIntent();

        id = i.getStringExtra("id");

//        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();

        Job_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewDetails.this,FullViewImage.class);
                i.putExtra("image",job_card);
                startActivity(i);
            }
        });
        Design_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewDetails.this,FullViewImage.class);
                i.putExtra("image",design_file);
                startActivity(i);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog;

                dialog=new Dialog(v.getContext());

                // set custom dialog
                dialog.setContentView(R.layout.profile);

                // set custom height and width
                dialog.getWindow().setLayout(600,800);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                // set transparent background
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                // show dialog
                dialog.show();

                TextView uname=dialog.findViewById(R.id.name);
                TextView uemail=dialog.findViewById(R.id.email);
                TextView number=dialog.findViewById(R.id.phone);
                ImageView porfile_img=dialog.findViewById(R.id.profile_img);
                Button logout=dialog.findViewById(R.id.logout);

                uname.setText("Name: "+user_name);
                uemail.setText("Email: "+email);
                number.setText("Phone: "+phone);

                if (image != "null"){
                    Glide.with(ViewDetails.this).load(image).into(porfile_img);
                }

                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();

                        Dialog dialog2;

                        dialog2=new Dialog(v.getContext());

                        // set custom dialog
                        dialog2.setContentView(R.layout.alert_dailogbox);

                        // set custom height and width
//                dialog.getWindow().setLayout(600,800);
                        dialog2.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                        // set transparent background
                        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                        // show dialog
                        dialog2.show();

                        // Initialize and assign variable
                        TextView title=dialog2.findViewById(R.id.title);
                        TextView message=dialog2.findViewById(R.id.message);
                        RelativeLayout no=dialog2.findViewById(R.id.no);
                        RelativeLayout yes=dialog2.findViewById(R.id.yes);

                        title.setText("Alert");
                        message.setText("Are you sure want to logout");

                        no.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                dialog2.dismiss();
                            }
                        });
                        yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {









                                final String URL = "http://eagle.spksystems.in/public/api/logout";


                                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {


                                        try {
                                            String success = response.getString("success");

                                            if (success.equals("true")){
                                                Toast.makeText(v.getContext(), "You have been successfully logged out", Toast.LENGTH_SHORT).show();
                                                dialog2.dismiss();
                                                String token = null;
                                                PreferenceUtils.saveTokan(token,ViewDetails.this);
                                                Intent i = new Intent(ViewDetails.this, SplashScreen.class);
                                                startActivity(i);
                                            }

                                        } catch (JSONException jsonException) {
                                            jsonException.printStackTrace();
                                        }


                                    }


                                },
                                        new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {





                                            }

                                        }){

                                    @Override
                                    public Map<String, String> getHeaders() throws AuthFailureError {
                                        Map<String,String> params = new HashMap<String, String>();
                                        params.put("Accept", "application/json");
                                        params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(v.getContext()));


                                        return params;
                                    }
                                };


                                jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                                        10000,
                                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                                RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
                                requestQueue.getCache().clear();
                                requestQueue.add(jsonObjectRequest);



                            }
                        });


                    }
                });

            }
        });


        data();
        data3();
    }

    private void data() {

        final String URL = "http://eagle.spksystems.in/public/api/project-view?id="+id;

        stage_models = new ArrayList<>();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                spinKitView.setVisibility(View.GONE);
//                    Toast.makeText(ViewDetails.this, response.toString(), Toast.LENGTH_SHORT).show();
                try {

                    JSONObject data = response.getJSONObject("data");



                    order_no = data.getString("order_no");
                    company = data.getString("company");
                    order_type = data.getString("order_type");
                    status = data.getString("status");
                    remark = data.getString("remarks");
                    cancel_reason = data.getString("cancel_reason");
                    design_file = data.getString("design_file");
                    job_card = data.getString("job_card");
                    mail_receive_date = data.getString("mail_receive_date");

                    no_of_set = data.getString("no_of_set");
                    no_of_quantity = data.getString("no_of_quantity");
                    date = data.getString("date");
                    delivery_date = data.getString("delivery_date");
                    job_title = data.getString("job_title");
                    design_no = data.getString("design_no");
                    current_user = data.getString("current_stage_person");

                    String customer_s = data.getString("customer");
                    String  project_type_s = data.getString("project_type");
                    String  stage_s = data.getString("stage");
//


                    JSONObject customer_o = new JSONObject(customer_s);
                    JSONObject project_type_o = new JSONObject(project_type_s);
                    JSONObject stage_o = new JSONObject(stage_s);



                    customer = customer_o.getString("name");
                    project_type = project_type_o.getString("name");

                    current_stage = stage_o.getString("name");

                    Customer.setText(customer);
                    Order_no.setText(order_no);
                    Company.setText(company);
                    Project_type.setText(project_type);
                    Order_type.setText(order_type);
                    Status.setText(status);

                    No_of_set.setText(no_of_set);

                    No_of_quantity.setText(no_of_quantity);
                    Date.setText(date);
                    Delivery_date.setText(delivery_date);
                    Job_title.setText(job_title);
                    Design_no.setText(design_no);
                    Current_user.setText(current_user);
                    if (mail_receive_date.equals("null")){
                        Mail_receive_date.setText("-");
                    }else {
                        Mail_receive_date.setText(mail_receive_date);
                    }


                    if (status.equals("Cancelled")){
                        Cancel_reason.setText(cancel_reason);
                        cancel_layout.setVisibility(View.VISIBLE);
                    }
                    if (remark != "null"){
                        Remark.setText(remark);
                        remark_layout.setVisibility(View.VISIBLE);
                    }
                    Current_stage.setText(current_stage);
                    if(this !=null) {
                        Glide.with(getApplicationContext()).load(job_card).into(Job_card);
                        Glide.with(getApplicationContext()).load(design_file).into(Design_file);
                    }

                    String  coating_s = data.getString("coating");

                    if (coating_s.equals("null")){
                        Coating.setText("-");
                    }else{
                        JSONObject coating_o = new JSONObject(coating_s);

                        coating = coating_o.getString("name");

                        Coating.setText(coating);
                    }


                    JSONArray stages = data.getJSONArray("stages");


                    for (int i =0;i<stages.length();i++){
                        try {
                            JSONObject object = stages.getJSONObject(i);

                            String order_no = object.getString("order_no");
                            String completed_by = object.getString("user");
                            String completed_at = object.getString("completed_at");
                            String started_at = object.getString("started_at");





                            JSONObject stage = object.getJSONObject("stage");



                            String stage_name = stage.getString("name");



                            Stage_model model = new Stage_model();

                            model.setOrder_no(order_no);
                            model.setStage(stage_name);
                            if (completed_at.equals("null")){
                                model.setCompleted_at("-");
                            }else {
                                model.setCompleted_at(completed_at);
                            }

                            if (started_at.equals("null")){
                                model.setStart_at("-");
                            }else {
                                model.setStart_at(started_at);
                            }



                            stage_models.add(model);



                            if (completed_by.equals("null")){
                                model.setCompleted_by("-");
                            }else {
                                JSONObject emp = new JSONObject(completed_by);
                                String employee_name = emp.getString("name");
                                model.setCompleted_by(employee_name);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                adapter =  new Stage_Adapter(ViewDetails.this,stage_models);
                recyclerView.setAdapter(adapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewDetails.this) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                recyclerView.setLayoutManager(linearLayoutManager);

            }


        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        spinKitView.setVisibility(View.GONE);

//                        Toast.makeText(Pending_Class.this, error.toString(), Toast.LENGTH_SHORT).show();

                    }

                }){
            //                @Override
//                protected Map<String,String> getParams(){
//                    Map<String,String> params = new HashMap<String, String>();
//
//
//
//                    return params;
//                }
//
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(ViewDetails.this));


                return params;
            }
        };


        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestQueue = Volley.newRequestQueue(ViewDetails.this);
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjectRequest);
    }

    private void data3() {

        final String URL = "http://eagle.spksystems.in/public/api/profile";


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

//                    Toast.makeText(AdminActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                try {

                    JSONObject data = response.getJSONObject("data");




                    user_name = data.getString("name");
                    phone = data.getString("phone");
                    email = data.getString("email");
                    image = data.getString("image");








                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        spinKitView.setVisibility(View.GONE);
//                        Toast.makeText(Pending_Class.this, error.toString(), Toast.LENGTH_SHORT).show();

                    }

                }){
            //                @Override
//                protected Map<String,String> getParams(){
//                    Map<String,String> params = new HashMap<String, String>();
//
//
//
//                    return params;
//                }
//
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(ViewDetails.this));


                return params;
            }
        };


        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestQueue = Volley.newRequestQueue(ViewDetails.this);
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjectRequest);

    }

}