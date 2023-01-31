
package com.example.eagle.Pending;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
import com.example.eagle.Dashboard.DashboardActivity;
import com.example.eagle.Dashboard.DashboardAdapter;
import com.example.eagle.Dashboard.DashboardModel;
import com.example.eagle.Dashboard.Dashboard_one_adapter;
import com.example.eagle.Dashboard.Dashboard_one_model;
import com.example.eagle.R;
import com.example.eagle.SplashScreen;
import com.example.eagle.utils.PreferenceUtils;
import com.github.ybq.android.spinkit.SpinKitView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PendingFragment extends Fragment implements  Pending_Adapter_one.OnItemClickListener{
    List<Pending_Model> pending_modelList;
    Pending_Adapter adapter;
    List<Pending_Model_one> pendingModelOneList;
    Pending_Adapter_one adapter_one;

    RecyclerView plan, recyclerView;

    String customer_id;

    LinearLayout profile;
    SpinKitView spinKitView;

    String user_name,email,phone,image="null";

    TextView no_data;

    int s_id = 0;
    SwipeRefreshLayout swipeRefreshLayout;

    ImageView calende;

    Calendar calendar;
    DatePickerDialog dd;

    ImageView filter;

    String date = null;

    String filter_type = "Date";

    String result = "false";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_pending, container, false);



        recyclerView =root.findViewById(R.id.pending_recycle);
        plan = root.findViewById(R.id.plan_recycler);
        spinKitView =root.findViewById(R.id.progressBar);

        Intent intent =getActivity().getIntent();
        customer_id = intent.getStringExtra("id");



        profile =root.findViewById(R.id.profile);
        no_data = root.findViewById(R.id.no_data);
        calende =root.findViewById(R.id.calender);
        filter = root.findViewById(R.id.filter);

        swipeRefreshLayout= root.findViewById(R.id.swiper);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);


                if (s_id == 0) {
//                    String URL = "http://eagle.spksystems.in/public/api/project-list?customer_id="+customer_id;
                    String URL = "http://eagle.spksystems.in/public/api/project-list";
                    data2(URL);
                }

                else {
                    String URL = "http://eagle.spksystems.in/public/api/project-list?customer_id="+customer_id+"&stage_id="+s_id;

                    data2(URL);



                }



            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PopupMenu popup = new PopupMenu(getActivity(), v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.filter_menu, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();

                        switch (id) {

                            case R.id.date:

                                if (date != null){
                                    filter_type = "Date";
                                    String URL = "http://eagle.spksystems.in/public/api/project-list?customer_id="+customer_id+"&date="+date+"&filter_by="+filter_type;
                                    data2(URL);
                                }else {
                                    Toast.makeText(getActivity(), "Date is required.", Toast.LENGTH_SHORT).show();
                                }


                                break;

                            case R.id.delivery:

                                if (date != null){
                                    filter_type = "Delivery";
                                    String URL2 = "http://eagle.spksystems.in/public/api/project-list?customer_id="+customer_id+"&date="+date+"&filter_by="+filter_type;
                                    data2(URL2);
                                }else {
                                    Toast.makeText(getActivity(), "Date is required.", Toast.LENGTH_SHORT).show();
                                }
                                break;

                            case R.id.delay:
                                if (date != null){
                                    filter_type = "Delay";
                                    String URL3 = "http://eagle.spksystems.in/public/api/project-list?customer_id="+customer_id+"&date="+date+"&filter_by="+filter_type;
                                    data2(URL3);
                                }else {
                                    Toast.makeText(getActivity(), "Date is required.", Toast.LENGTH_SHORT).show();
                                }
                                break;

                        }


                        return true;
                    }
                });


            }
        });



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

        calende.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();

                final DatePickerDialog.OnDateSetListener dateA = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        date = dayOfMonth+"-"+(monthOfYear+1)+"-"+year;

                        String URL = "http://eagle.spksystems.in/public/api/project-list?customer_id="+customer_id+"&date="+date+"&filter_by="+filter_type;
                        data2(URL);
                    }
                };

                new DatePickerDialog(getActivity(), dateA, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
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

        data3();
        data1();

//        String URL = "http://eagle.spksystems.in/public/api/project-list?customer_id="+customer_id;
        String URL = "http://eagle.spksystems.in/public/api/project-list";
        data2(URL);



        return root;


    }

    private void data3() {

        final String URL = "http://eagle.spksystems.in/public/api/profile";


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


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

                    }

                }){


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


//        final String URL = "http://eagle.spksystems.in/public/api/project-list?customer_id="+customer_id;
        final String URL = "http://eagle.spksystems.in/public/api/project-list";


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


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
                adapter_one.setOnItemClickListener(PendingFragment.this);


            }


        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        spinKitView.setVisibility(View.GONE);


                    }

                }){

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
    private void data2(String URL) {

        pending_modelList = new ArrayList<>();


        spinKitView.setVisibility(View.VISIBLE);



        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                spinKitView.setVisibility(View.GONE);
                result = "true";

                try {


                    JSONObject data = response.getJSONObject("data");

                    String status_change_permission = data.getString("status_change_permission");



                    JSONArray projects = data.getJSONArray("projects");

                    if (projects.toString().equals("[]")){
                        no_data.setVisibility(View.VISIBLE);
                    }else {
                        no_data.setVisibility(View.GONE);
                    }
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

                    recyclerView.setLayoutManager(layoutManager1);

                    adapter =  new Pending_Adapter(getActivity(),pending_modelList);
                    recyclerView.setAdapter(adapter);



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        spinKitView.setVisibility(View.GONE);


                    }

                }){


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
            String URL = "http://eagle.spksystems.in/public/api/project-list?customer_id="+customer_id;
            data2(URL);
            s_id = 0;
            filter_type = "Date";
            date = null;
            String result = "false";
            adapter.notifyDataSetChanged();
            adapter_one.notifyDataSetChanged();



        }else {
            String URL = "http://eagle.spksystems.in/public/api/project-list?customer_id="+customer_id+"&stage_id="+s_id;
            data2(URL);
            filter_type = "Date";
            date = null;
            String result = "false";
            adapter.notifyDataSetChanged();
            adapter_one.notifyDataSetChanged();


        }





    }



}


