package com.example.eagle.Pending;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.eagle.AdminActivity;
import com.example.eagle.Customers.Customer_status;
import com.example.eagle.Dashboard.DashboardModel;
import com.example.eagle.R;
import com.example.eagle.ViewDetails;
import com.example.eagle.utils.PreferenceUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pending_Adapter extends RecyclerView.Adapter<Pending_Adapter.ViewHolder> {


    List<Pending_Model> pending_modelList;
    private Context context;







    public Pending_Adapter(Context context, List<Pending_Model> pending_modelList) {
        this.context = context;
        this.pending_modelList= pending_modelList;
    }

    @NonNull
    @Override
    public Pending_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_three, parent, false);


        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(pending_modelList.get(position).getProject_name());
        holder.textView1.setText(pending_modelList.get(position).getProject_type());
        holder.current_stage.setText(pending_modelList.get(position).getCurrent_stage());
        holder.status.setText(pending_modelList.get(position).getStatus());
        holder.current_user.setText(pending_modelList.get(position).getCurrent_user());



        Glide.with(context)
                .load(pending_modelList.get(position).getImg())
                .into(holder.img);

    }


    // total number of rows
    @Override
    public int getItemCount() {

        return pending_modelList.size();

    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView, textView1,current_stage,status,current_user;
        ImageView img;



        ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.project_txt);
            textView1 = itemView.findViewById(R.id.quantity_txt);
            img = itemView.findViewById(R.id.arrow_img);
            current_stage = itemView.findViewById(R.id.current_stage);
            status = itemView.findViewById(R.id.status);
            current_user = itemView.findViewById(R.id.current_user);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    String id = pending_modelList.get(position).getId();

                    Intent i = new Intent(v.getContext(), ViewDetails.class);
                    i.putExtra("id",id);
                    v.getContext().startActivity(i);

                }
            });




        }


    }


}