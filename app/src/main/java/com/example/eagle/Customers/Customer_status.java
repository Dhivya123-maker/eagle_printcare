package com.example.eagle.Customers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.eagle.EmployeeReportFragment;
import com.example.eagle.HomeFragment;

import com.example.eagle.Pending.PendingFragment;
import com.example.eagle.ProjectReportFragment;
import com.example.eagle.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Customer_status extends AppCompatActivity{


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_status);

//        recyclerView1 =findViewById(R.id.customer_recycler);
//        plan = findViewById(R.id.plan_recycler);
//        profile = findViewById(R.id.profile);
//        spinKitView = findViewById(R.id.progressBar);
//        relativeLayout_plan = findViewById(R.id.plan);
//
//        spinKitView.setVisibility(View.VISIBLE);

//        swipeRefreshLayout= findViewById(R.id.swiper);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,
                    new PendingFragment()).commit();
        }


//        tabLayout=(TabLayout) findViewById(R.id.tabLayout);



//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                // Fragment fragment = null;
//                switch (tab.getPosition()) {
//                    case 0:
//
//                        data();
//                        relativeLayout_plan.setVisibility(View.GONE);
//                        refrash = "customers";
//                        break;
//                    case 1:
//                        String URL = "http://eagle.spksystems.in/public/api/project-list";
//                        data3(URL);
//                        data1();
//                        relativeLayout_plan.setVisibility(View.VISIBLE);
//                        refrash = "projects";
//                        break;
//
//                }
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                swipeRefreshLayout.setRefreshing(false);
//
//                if (refrash.equals("customers")){
//                    data();
//                }else if (refrash.equals("projects")){
//                    if (s_id == 0){
//                        String URL = "http://eagle.spksystems.in/public/api/project-list";
//                        data3(URL);
//                    }else {
//                        String URL = "http://eagle.spksystems.in/public/api/project-list?stage_id="+s_id;
//                        data3(URL);
//                    }
//
//                }
//
//            }
//        });
//
//        calende = findViewById(R.id.calender);
//        filter = findViewById(R.id.filter);
//
//        filter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                PopupMenu popup = new PopupMenu(Customer_status.this, v);
//                MenuInflater inflater = popup.getMenuInflater();
//                inflater.inflate(R.menu.filter_menu, popup.getMenu());
//                popup.show();
//                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        int id = item.getItemId();
//
//                        switch (id) {
//
//                            case R.id.date:
//
//                                if (date != null){
//                                    filter_type = "Date";
//                                    String URL = "http://eagle.spksystems.in/public/api/project-list?date="+date+"&filter_by="+filter_type;
//                                    data3(URL);
//                                }else {
//                                    Toast.makeText(Customer_status.this, "Date is required.", Toast.LENGTH_SHORT).show();
//                                }
//
//
//                                break;
//
//                            case R.id.delivery:
//
//                                if (date != null){
//                                    filter_type = "Delivery";
//                                    String URL2 = "http://eagle.spksystems.in/public/api/project-list?date="+date+"&filter_by="+filter_type;
//                                    data3(URL2);
//                                }else {
//                                    Toast.makeText(Customer_status.this, "Date is required.", Toast.LENGTH_SHORT).show();
//                                }
//                                break;
//
//                            case R.id.delay:
//                                if (date != null){
//                                    filter_type = "Delay";
//                                    String URL3 = "http://eagle.spksystems.in/public/api/project-list?date="+date+"&filter_by="+filter_type;
//                                    data3(URL3);
//                                }else {
//                                    Toast.makeText(Customer_status.this, "Date is required.", Toast.LENGTH_SHORT).show();
//                                }
//                                break;
//
//                        }
//
//
//                        return true;
//                    }
//                });
//
//
//            }
//        });



//        calende.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("NewApi")
//            @Override
//            public void onClick(View view) {
//                calendar = Calendar.getInstance();
//                int day = calendar.get(Calendar.DAY_OF_MONTH);
//                int month = calendar.get(Calendar.MONTH);
//                int year = calendar.get(Calendar.YEAR);
//
//
//
//
//                dd = new DatePickerDialog(Pending_Class.this,new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
//
//
////                        Toast.makeText(Pending_Class.this,mDay+"-"+ (mMonth+1) + "-" + +mYear , Toast.LENGTH_SHORT).show();
//
//
//
//                    }
//                },day,month,year);
//
//                dd.show();
//
//
//
//            }
//        });







//        calende.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calendar = Calendar.getInstance();
//
//                final DatePickerDialog.OnDateSetListener dateA = new DatePickerDialog.OnDateSetListener() {
//
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int monthOfYear,
//                                          int dayOfMonth) {
//                        // TODO Auto-generated method stub
//                        calendar.set(Calendar.YEAR, year);
//                        calendar.set(Calendar.MONTH, monthOfYear);
//                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//
//                        date = dayOfMonth+"-"+(monthOfYear+1)+"-"+year;
//
//                        String URL = "http://eagle.spksystems.in/public/api/project-list?date="+date+"&filter_by="+filter_type;
//                        data3(URL);
//                    }
//                };
//
//                new DatePickerDialog(Customer_status.this, dateA, calendar.get(Calendar.YEAR),
//                        calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });

//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Dialog dialog;
//
//                dialog=new Dialog(v.getContext());
//
//                // set custom dialog
//                dialog.setContentView(R.layout.profile);
//
//                // set custom height and width
//                dialog.getWindow().setLayout(600,800);
//                dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//                // set transparent background
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//                // show dialog
//                dialog.show();
//
//                TextView uname=dialog.findViewById(R.id.name);
//                TextView uemail=dialog.findViewById(R.id.email);
//                TextView number=dialog.findViewById(R.id.phone);
//                ImageView porfile_img=dialog.findViewById(R.id.profile_img);
//                Button logout=dialog.findViewById(R.id.logout);
//
//                uname.setText("Name: "+user_name);
//                uemail.setText("Email: "+email);
//                number.setText("Phone: "+phone);
//
//                if (image.equals("null")){
//
//                }else {
//                    Glide.with(Customer_status.this).load(image).into(porfile_img);
//                }
//
//                logout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        dialog.dismiss();
//
//                        Dialog dialog2;
//
//                        dialog2=new Dialog(v.getContext());
//
//                        // set custom dialog
//                        dialog2.setContentView(R.layout.alert_dailogbox);
//
//                        // set custom height and width
////                dialog.getWindow().setLayout(600,800);
//                        dialog2.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//                        // set transparent background
//                        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//                        // show dialog
//                        dialog2.show();
//
//                        // Initialize and assign variable
//                        TextView title=dialog2.findViewById(R.id.title);
//                        TextView message=dialog2.findViewById(R.id.message);
//                        RelativeLayout no=dialog2.findViewById(R.id.no);
//                        RelativeLayout yes=dialog2.findViewById(R.id.yes);
//
//                        title.setText("Alert");
//                        message.setText("Are you sure want to logout");
//
//                        no.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                                dialog2.dismiss();
//                            }
//                        });
//                        yes.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//
//
//                                final String URL = "http://eagle.spksystems.in/public/api/logout";
//
//
//                                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
//                                    @Override
//                                    public void onResponse(JSONObject response) {
//
//
//                                        try {
//                                            String success = response.getString("success");
//
//                                            if (success.equals("true")){
//                                                Toast.makeText(v.getContext(), "You have been successfully logged out", Toast.LENGTH_SHORT).show();
//                                                dialog2.dismiss();
//                                                String token = null;
//                                                PreferenceUtils.saveTokan(token,Customer_status.this);
//                                                Intent i = new Intent(Customer_status.this, SplashScreen.class);
//                                                startActivity(i);
//                                            }
//
//                                        } catch (JSONException jsonException) {
//                                            jsonException.printStackTrace();
//                                        }
//
//
//                                    }
//
//
//                                },
//                                        new Response.ErrorListener() {
//                                            @Override
//                                            public void onErrorResponse(VolleyError error) {
//
//
//
//
//
//                                            }
//
//                                        }){
//
//                                    @Override
//                                    public Map<String, String> getHeaders() throws AuthFailureError {
//                                        Map<String,String> params = new HashMap<String, String>();
//                                        params.put("Accept", "application/json");
//                                        params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(v.getContext()));
//
//
//                                        return params;
//                                    }
//                                };
//
//
//                                jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
//                                        10000,
//                                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//                                RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
//                                requestQueue.getCache().clear();
//                                requestQueue.add(jsonObjectRequest);
//
//
//
//                            }
//                        });
//
//
//                    }
//                });
//
//            }
//        });

//        data2();
//        data();




    }

//    private void data2() {
//
//
//
//
//        final String URL = "http://eagle.spksystems.in/public/api/profile";
//
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//
////                    Toast.makeText(AdminActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
//                try {
//
//                    JSONObject data = response.getJSONObject("data");
//
//
//
//
//                         user_name = data.getString("name");
//                         phone = data.getString("phone");
//                         email = data.getString("email");
//                         image = data.getString("image");
//
//
//
//
//
//
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//
//
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                        spinKitView.setVisibility(View.GONE);
////                        Toast.makeText(Customer_status.this, error.toString(), Toast.LENGTH_SHORT).show();
//
//                    }
//
//                }){
//            //                @Override
////                protected Map<String,String> getParams(){
////                    Map<String,String> params = new HashMap<String, String>();
////
////
////
////                    return params;
////                }
////
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("Accept", "application/json");
//                params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(Customer_status.this));
//
//
//                return params;
//            }
//        };
//
//
//        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
//                10000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//        RequestQueue requestQueue = Volley.newRequestQueue(Customer_status.this);
//        requestQueue.getCache().clear();
//        requestQueue.add(jsonObjectRequest);
//
//
//    }
//
//    private void data() {
//
//        dashboard_one_modelList= new ArrayList<>();
//        spinKitView.setVisibility(View.VISIBLE);
//
//        final String URL = "http://eagle.spksystems.in/public/api/customer-list";
//
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                spinKitView.setVisibility(View.GONE);
////                    Toast.makeText(AdminActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
//                try {
//
//                    JSONArray data = response.getJSONArray("data");
//
//                    for (int i = 0; i < data.length(); i++) {
//
//                        JSONObject jsonObject = data.getJSONObject(i);
//
//
//                        String name = jsonObject.getString("name");
//                        String project_count = jsonObject.getString("project_count");
//                        String id = jsonObject.getString("id");
//
//                        Dashboard_one_model viewmodel1 = new Dashboard_one_model();
//
//
//                        viewmodel1.setText(name);
//                        viewmodel1.setId(id);
//                        viewmodel1.setProject_count(project_count);
//
//
//
//
//                        dashboard_one_modelList.add(viewmodel1);
//
//                    }
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                recyclerView1.setLayoutManager(new LinearLayoutManager(Customer_status.this));
//
//                adapter1 =  new Dashboard_one_adapter(Customer_status.this,dashboard_one_modelList);
//                recyclerView1.setAdapter(adapter1);
//
//            }
//
//
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                        spinKitView.setVisibility(View.GONE);
////                            Toast.makeText(Customer_status.this, error.toString(), Toast.LENGTH_SHORT).show();
//
//                    }
//
//                }){
//            //                @Override
////                protected Map<String,String> getParams(){
////                    Map<String,String> params = new HashMap<String, String>();
////
////
////
////                    return params;
////                }
////
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("Accept", "application/json");
//                    params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(Customer_status.this));
//
//
//                return params;
//            }
//        };
//
//
//        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
//                10000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//        RequestQueue requestQueue = Volley.newRequestQueue(Customer_status.this);
//        requestQueue.getCache().clear();
//        requestQueue.add(jsonObjectRequest);
//
//
//
//
//    }

    public void onBackPressed() {







        Dialog dialog2;

        dialog2=new Dialog(this);

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
        message.setText("Are you sure want to exit");

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog2.dismiss();
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer_status.super.onBackPressed();
                finishAffinity();

            }
        });

    }

//
//    private void data3(String URL) {
//
//        pending_modelList = new ArrayList<>();
//
//
//        spinKitView.setVisibility(View.VISIBLE);
//
//
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//
////                    Toast.makeText(Pending_Class.this, response.toString(), Toast.LENGTH_SHORT).show();
//
//                spinKitView.setVisibility(View.GONE);
//
//
//                try {
//
//
//                    JSONObject data = response.getJSONObject("data");
//
//                    String status_change_permission = data.getString("status_change_permission");
//
//
//
//                    JSONArray projects = data.getJSONArray("projects");
//
//
//                    Log.i("iubhggbybhbnu",projects.toString());
//                    for (int i = 0; i < projects.length(); i++) {
//
//                        JSONObject jsonObject = projects.getJSONObject(i);
//
//                        String id = jsonObject.getString("id");
//                        String name = jsonObject.getString("job_title");
//                        String status = jsonObject.getString("status");
//                        String Project_type = jsonObject.getString("project_type");
//                        String stage = jsonObject.getString("stage");
//                        String design_file = jsonObject.getString("design_file");
//                        String current_stage_person = jsonObject.getString("current_stage_person");
//
//
//                        JSONObject Project_type_object = new JSONObject(Project_type);
//                        JSONObject stage_object = new JSONObject(stage);
//
//
//                        String Project_type_name = Project_type_object.getString("name");
//                        String stage_name = stage_object.getString("name");
//
//
//
//
//                        Pending_Model viewmodel = new Pending_Model();
//
//                        viewmodel.setPermission(status_change_permission);
//                        viewmodel.setStatus(status);
//                        viewmodel.setId(id);
//                        viewmodel.setProject_type(Project_type_name);
//                        viewmodel.setProject_name(name);
//                        viewmodel.setCurrent_stage(stage_name);
//                        viewmodel.setImg(design_file);
//                        viewmodel.setCurrent_user(current_stage_person);
//
//
//
//
//                        pending_modelList.add(viewmodel);
//
//
//                    }
//
//
//                    LinearLayoutManager layoutManager1=new LinearLayoutManager(Customer_status.this){
//                        @Override
//                        public boolean canScrollVertically() {
//                            return true;
//                        }
//                    };
//
//                    recyclerView1.setLayoutManager(layoutManager1);
//
//                    adapter =  new Pending_Adapter(Customer_status.this,pending_modelList);
//                    recyclerView1.setAdapter(adapter);
//
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//
//
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                        spinKitView.setVisibility(View.GONE);
////                        Toast.makeText(Pending_Class.this, error.toString(), Toast.LENGTH_SHORT).show();
//
//                    }
//
//                }){
//            //                @Override
////                protected Map<String,String> getParams(){
////                    Map<String,String> params = new HashMap<String, String>();
////
////
////
////                    return params;
////                }
////
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("Accept", "application/json");
//                params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(Customer_status.this));
//
//
//                return params;
//            }
//        };
//
//
//        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
//                10000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//        RequestQueue requestQueue = Volley.newRequestQueue(Customer_status.this);
//        requestQueue.getCache().clear();
//        requestQueue.add(jsonObjectRequest);
//    }
//
//
//
//    private void data1() {
//
//        pendingModelOneList = new ArrayList<>();
//
//
//        final String URL = "http://eagle.spksystems.in/public/api/project-list";
//
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//
////                    Toast.makeText(AdminActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
//                try {
//
//                    JSONObject data = response.getJSONObject("data");
//
//                    JSONArray stages = data.getJSONArray("stages");
//                    String allProjectCount = data.getString("allProjectCount");
//
//                    Pending_Model_one viewmodel2 = new Pending_Model_one();
//
//
//
//                    viewmodel2.setText("ALL");
//                    viewmodel2.setCount("( "+allProjectCount+" )");
//
//
//                    pendingModelOneList.add(viewmodel2);
//
//                    for (int i = 0; i < stages.length(); i++) {
//
//                        JSONObject jsonObject = stages.getJSONObject(i);
//
//                        int id = jsonObject.getInt("id");
//                        String name = jsonObject.getString("name");
//                        String project_count = jsonObject.getString("project_count");
//
//
//
//                        Pending_Model_one viewmodel = new Pending_Model_one();
//
//
//
//                        viewmodel.setText(name);
//                        viewmodel.setId(id);
//                        viewmodel.setCount("( "+project_count+" )");
//
//                        pendingModelOneList.add(viewmodel);
//
//
//
//                    }
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                adapter_one =  new Pending_Adapter_one(Customer_status.this,pendingModelOneList);
//                plan.setAdapter(adapter_one);
//                plan.setLayoutManager(new LinearLayoutManager(Customer_status.this, LinearLayoutManager.HORIZONTAL, false));
//                adapter_one.setOnItemClickListener(Customer_status.this);
//
//            }
//
//
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                        spinKitView.setVisibility(View.GONE);
////                        Toast.makeText(Pending_Class.this, error.toString(), Toast.LENGTH_SHORT).show();
//
//                    }
//
//                }){
//            //                @Override
////                protected Map<String,String> getParams(){
////                    Map<String,String> params = new HashMap<String, String>();
////
////
////
////                    return params;
////                }
////
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("Accept", "application/json");
//                params.put("Authorization", "Bearer  " + PreferenceUtils.getTokan(Customer_status.this));
//
//
//                return params;
//            }
//        };
//
//
//        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
//                10000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//        RequestQueue requestQueue = Volley.newRequestQueue(Customer_status.this);
//        requestQueue.getCache().clear();
//        requestQueue.add(jsonObjectRequest);
//
//    }
//
//    @Override
//    public void onItemClick(int position) {
//
//
//        Pending_Model_one viewmodel = pendingModelOneList.get(position);
//
//
//        s_id = viewmodel.getId();
//        String name = viewmodel.getText();
//
//        if (name.equals("ALL")){
//            String URL = "http://eagle.spksystems.in/public/api/project-list";
//            data3(URL);
//            s_id = 0;
//            filter_type = "Date";
//            date = null;
//        }else {
//            String URL = "http://eagle.spksystems.in/public/api/project-list?stage_id="+s_id;
//            data3(URL);
//            filter_type = "Date";
//            date = null;
//        }
//
//
//
//    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.menu_home:
                            selectedFragment = new PendingFragment();
                            break;
                        case R.id.menu_matches:

                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.menu_relationship:
                            selectedFragment = new ProjectReportFragment();

                            break;
                        case R.id.posts:
                            selectedFragment = new EmployeeReportFragment();

                            break;

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment,
                            selectedFragment).commit();

                    return true;
                }

            };



}