package com.example.eagle;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
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
import com.example.eagle.Customers.Customer_status;
import com.example.eagle.Dashboard.Dashboard_one_adapter;
import com.example.eagle.Dashboard.Dashboard_one_model;
import com.example.eagle.Pending.Pending_Adapter;
import com.example.eagle.Pending.Pending_Adapter_one;
import com.example.eagle.Pending.Pending_Model;
import com.example.eagle.Pending.Pending_Model_one;
import com.example.eagle.utils.PreferenceUtils;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HomeFragment extends Fragment implements Pending_Adapter_one.OnItemClickListener {
    List<Dashboard_one_model> dashboard_one_modelList;
    Dashboard_one_adapter adapter1;
    RecyclerView recyclerView1,plan;
    LinearLayout profile;
    SpinKitView spinKitView;

    String user_name,email,phone,image="null";

    private long pressedTime;

    SwipeRefreshLayout swipeRefreshLayout;

    TabLayout tabLayout;

    List<Pending_Model> pending_modelList;
    Pending_Adapter adapter;

    List<Pending_Model_one> pendingModelOneList;
    Pending_Adapter_one adapter_one;

    RelativeLayout relativeLayout_plan;

    int s_id = 0;


    ImageView calende;

    Calendar calendar;
    DatePickerDialog dd;

    ImageView filter;

    String date = null;

    String filter_type = "Date";
    String refrash = "customers";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView1 =root.findViewById(R.id.customer_recycler);
        plan = root.findViewById(R.id.plan_recycler);
        profile =root.findViewById(R.id.profile);
        spinKitView =root.findViewById(R.id.progressBar);
        relativeLayout_plan = root.findViewById(R.id.plan);
        calende = root.findViewById(R.id.calender);
        spinKitView.setVisibility(View.VISIBLE);

        swipeRefreshLayout= root.findViewById(R.id.swiper);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);

                if (refrash.equals("customers")){
                    data();
                }else if (refrash.equals("projects")){
                    if (s_id == 0){
                        String URL = "http://eagle.spksystems.in/public/api/project-list";
                        data3(URL);
                    }else {
                        String URL = "http://eagle.spksystems.in/public/api/project-list?stage_id="+s_id;
                        data3(URL);
                    }

                }

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

                if (image.equals("null")){

                }else {
                    Glide.with(getActivity()).load(image).into(porfile_img);
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
                                                PreferenceUtils.saveTokan(token,getActivity());
                                                Intent i = new Intent(getActivity(), SplashScreen.class);
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

        data2();
        data();


        return root;
    }
    private void data2() {




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
//                        Toast.makeText(Customer_status.this, error.toString(), Toast.LENGTH_SHORT).show();

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
                params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(getActivity()));


                return params;
            }
        };


        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjectRequest);


    }

    private void data() {

        dashboard_one_modelList= new ArrayList<>();
        spinKitView.setVisibility(View.VISIBLE);

        final String URL = "http://eagle.spksystems.in/public/api/customer-list";


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                spinKitView.setVisibility(View.GONE);
//                    Toast.makeText(AdminActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                try {

                    JSONArray data = response.getJSONArray("data");

                    for (int i = 0; i < data.length(); i++) {

                        JSONObject jsonObject = data.getJSONObject(i);


                        String name = jsonObject.getString("name");
                        String project_count = jsonObject.getString("project_count");
                        String id = jsonObject.getString("id");

                        Dashboard_one_model viewmodel1 = new Dashboard_one_model();


                        viewmodel1.setText(name);
                        viewmodel1.setId(id);
                        viewmodel1.setProject_count(project_count);




                        dashboard_one_modelList.add(viewmodel1);

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));

                adapter1 =  new Dashboard_one_adapter(getActivity(),dashboard_one_modelList);
                recyclerView1.setAdapter(adapter1);

            }


        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        spinKitView.setVisibility(View.GONE);
//                            Toast.makeText(Customer_status.this, error.toString(), Toast.LENGTH_SHORT).show();

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
                params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(getActivity()));


                return params;
            }
        };


        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjectRequest);




    }
    private void data3(String URL) {

        pending_modelList = new ArrayList<>();


        spinKitView.setVisibility(View.VISIBLE);



        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

//                    Toast.makeText(Pending_Class.this, response.toString(), Toast.LENGTH_SHORT).show();

                spinKitView.setVisibility(View.GONE);


                try {


                    JSONObject data = response.getJSONObject("data");

                    String status_change_permission = data.getString("status_change_permission");



                    JSONArray projects = data.getJSONArray("projects");


                    Log.i("iubhggbybhbnu",projects.toString());
                    for (int i = 0; i < projects.length(); i++) {

                        JSONObject jsonObject = projects.getJSONObject(i);

                        String id = jsonObject.getString("id");
                        String name = jsonObject.getString("job_title");
                        String status = jsonObject.getString("status");
                        String Project_type = jsonObject.getString("project_type");
                        String stage = jsonObject.getString("stage");
                        String design_file = jsonObject.getString("design_file");
                        String current_stage_person = jsonObject.getString("current_stage_person");


                        JSONObject Project_type_object = new JSONObject(Project_type);
                        JSONObject stage_object = new JSONObject(stage);


                        String Project_type_name = Project_type_object.getString("name");
                        String stage_name = stage_object.getString("name");




                        Pending_Model viewmodel = new Pending_Model();

                        viewmodel.setPermission(status_change_permission);
                        viewmodel.setStatus(status);
                        viewmodel.setId(id);
                        viewmodel.setProject_type(Project_type_name);
                        viewmodel.setProject_name(name);
                        viewmodel.setCurrent_stage(stage_name);
                        viewmodel.setImg(design_file);
                        viewmodel.setCurrent_user(current_stage_person);




                        pending_modelList.add(viewmodel);


                    }


                    LinearLayoutManager layoutManager1=new LinearLayoutManager(getActivity()){
                        @Override
                        public boolean canScrollVertically() {
                            return true;
                        }
                    };

                    recyclerView1.setLayoutManager(layoutManager1);

                    adapter =  new Pending_Adapter(getActivity(),pending_modelList);
                    recyclerView1.setAdapter(adapter);



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
                params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(getActivity()));


                return params;
            }
        };


        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjectRequest);
    }



    private void data1() {

        pendingModelOneList = new ArrayList<>();


        final String URL = "http://eagle.spksystems.in/public/api/project-list";


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

//                    Toast.makeText(AdminActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                try {

                    JSONObject data = response.getJSONObject("data");

                    JSONArray stages = data.getJSONArray("stages");
                    String allProjectCount = data.getString("allProjectCount");

                    Pending_Model_one viewmodel2 = new Pending_Model_one();



                    viewmodel2.setText("ALL");
                    viewmodel2.setCount("( "+allProjectCount+" )");


                    pendingModelOneList.add(viewmodel2);

                    for (int i = 0; i < stages.length(); i++) {

                        JSONObject jsonObject = stages.getJSONObject(i);

                        int id = jsonObject.getInt("id");
                        String name = jsonObject.getString("name");
                        String project_count = jsonObject.getString("project_count");



                        Pending_Model_one viewmodel = new Pending_Model_one();



                        viewmodel.setText(name);
                        viewmodel.setId(id);
                        viewmodel.setCount("( "+project_count+" )");

                        pendingModelOneList.add(viewmodel);



                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                adapter_one =  new Pending_Adapter_one(getActivity(),pendingModelOneList);
                plan.setAdapter(adapter_one);
                plan.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                adapter_one.setOnItemClickListener((Pending_Adapter_one.OnItemClickListener) getActivity());

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
                params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(getActivity()));


                return params;
            }
        };


        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjectRequest);

    }

    @Override
    public void onItemClick(int position) {


        Pending_Model_one viewmodel = pendingModelOneList.get(position);


        s_id = viewmodel.getId();
        String name = viewmodel.getText();

        if (name.equals("ALL")){
            String URL = "http://eagle.spksystems.in/public/api/project-list";
            data3(URL);
            s_id = 0;
            filter_type = "Date";
            date = null;
        }else {
            String URL = "http://eagle.spksystems.in/public/api/project-list?stage_id="+s_id;
            data3(URL);
            filter_type = "Date";
            date = null;
        }



    }

}