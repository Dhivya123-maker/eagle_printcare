package com.example.eagle.Dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle.R;

import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {


    List<DashboardModel> dashboardModelList;
    private Context context;


    public DashboardAdapter(Context context, List<DashboardModel> dashboardModelList) {
        this.context = context;
        this.dashboardModelList = dashboardModelList;
    }

    @NonNull
    @Override
    public DashboardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_one, parent, false);


        return new DashboardAdapter.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(dashboardModelList.get(position).getText());
        holder.textView1.setText(dashboardModelList.get(position).getText_one());

    }


    // total number of rows
    @Override
    public int getItemCount() {

        return 7;

    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView, textView1;

        ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.txt);
            textView1 = itemView.findViewById(R.id.txt_one);


        }


    }


}