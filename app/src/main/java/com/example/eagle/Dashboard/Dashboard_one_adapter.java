package com.example.eagle.Dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle.Pending.Pending_Class;
import com.example.eagle.R;

import java.util.List;

public class Dashboard_one_adapter extends RecyclerView.Adapter<Dashboard_one_adapter.ViewHolder> {


    List<Dashboard_one_model> dashboard_one_modelList;
    private Context context;


    public Dashboard_one_adapter(Context context, List<Dashboard_one_model> dashboard_one_modelList) {
        this.context = context;
        this.dashboard_one_modelList = dashboard_one_modelList;
    }

    @NonNull
    @Override
    public Dashboard_one_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_two, parent, false);


        return new Dashboard_one_adapter.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(dashboard_one_modelList.get(position).getText());
        holder.project_count.setText("No.of.projects: "+dashboard_one_modelList.get(position).getProject_count());



    }


    // total number of rows
    @Override
    public int getItemCount() {

        return dashboard_one_modelList.size();

    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView,project_count;


        ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.pending_txt);
            project_count  = itemView.findViewById(R.id.projects_txt);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    String id = dashboard_one_modelList.get(position).getId();

                    Intent intent = new Intent(v.getContext(), Pending_Class.class);
                    intent.putExtra("id",id);
                    v.getContext().startActivity(intent);
                }
            });


        }


    }


}