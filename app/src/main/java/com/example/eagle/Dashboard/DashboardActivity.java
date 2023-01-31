package com.example.eagle.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.eagle.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    List<DashboardModel> dashboardModelList;
    DashboardAdapter adapter;

    List<Dashboard_one_model> dashboard_one_modelList;
    Dashboard_one_adapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       dashboardModelList = new ArrayList<>();

        RecyclerView recyclerView =findViewById(R.id.rv);


        for (int i = 0; i < 7; i++) {

           DashboardModel viewmodel = new DashboardModel();


            viewmodel.setText_one("20");
            viewmodel.setText("Thu");



            dashboardModelList.add(viewmodel);

        }
        dashboard_one_modelList= new ArrayList<>();

        RecyclerView recyclerView1 =findViewById(R.id.rv1);


        for (int i = 0; i < 3; i++) {

            Dashboard_one_model viewmodel1 = new Dashboard_one_model();





            dashboard_one_modelList.add(viewmodel1);

        }

        recyclerView.setLayoutManager(new LinearLayoutManager(DashboardActivity.this));

        adapter =  new DashboardAdapter(DashboardActivity.this,dashboardModelList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(DashboardActivity.this, LinearLayoutManager.HORIZONTAL, false));




        recyclerView1.setLayoutManager(new LinearLayoutManager(DashboardActivity.this));

        adapter1 =  new Dashboard_one_adapter(DashboardActivity.this,dashboard_one_modelList);
        recyclerView1.setAdapter(adapter1);



    }
}