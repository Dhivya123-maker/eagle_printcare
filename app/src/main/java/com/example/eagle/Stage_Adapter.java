package com.example.eagle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.eagle.Pending.Pending_Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Stage_Adapter extends RecyclerView.Adapter<Stage_Adapter.ViewHolder> {


    List<Stage_model> stage_models;
    private Context context;







    public Stage_Adapter(Context context, List<Stage_model> stage_models) {
        this.context = context;
        this.stage_models= stage_models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_tfour, parent, false);


        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.stage.setText(stage_models.get(position).getStage());
        holder.order_no.setText(stage_models.get(position).getOrder_no());

        holder.completed_by.setText(stage_models.get(position).getCompleted_by());



        if (stage_models.get(position).getCompleted_at().equals("-")) {


            holder.completed_at.setText("-");

        }else {
            String dateString4 = stage_models.get(position).getCompleted_at();
            //old format
            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date4 = sdf3.parse(dateString4);
                //new format
                SimpleDateFormat sdf4 = new SimpleDateFormat("dd-MM-yyyy hh.mm aa");
                //formatting the given time to new format with AM/PM

                holder.completed_at.setText(sdf4.format(date4));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (stage_models.get(position).getStart_at().equals("-")) {


            holder.started_at.setText("-");

        }else {
            String dateString2 = stage_models.get(position).getStart_at();
            //old format
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date4 = sdf2.parse(dateString2);
                //new format
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh.mm aa");
                //formatting the given time to new format with AM/PM

                holder.started_at.setText(sdf1.format(date4));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }


    // total number of rows
    @Override
    public int getItemCount() {

        return stage_models.size();

    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView stage, order_no,completed_by,completed_at,started_at;



        ViewHolder(View itemView) {
            super(itemView);

            stage = itemView.findViewById(R.id.stage);
            order_no = itemView.findViewById(R.id.order_no);
            completed_by = itemView.findViewById(R.id.completed_by);
            completed_at = itemView.findViewById(R.id.completed_at);
            started_at = itemView.findViewById(R.id.start_at);






        }


    }


}