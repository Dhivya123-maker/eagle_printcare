package com.example.eagle.Pending;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle.R;

import java.util.List;

public class Pending_Adapter_one extends RecyclerView.Adapter<Pending_Adapter_one.ViewHolder> {


    List<Pending_Model_one> pendingModelOneList;
    private Context context;
    public static Pending_Adapter_one.OnItemClickListener mListener;


    public interface OnItemClickListener{
        void onItemClick(int position);

    }

    int selectedItemPosition = 0;


    public void setOnItemClickListener(Pending_Adapter_one.OnItemClickListener listener){

        mListener = listener;

    }

    public Pending_Adapter_one(Context context, List<Pending_Model_one> pendingModelOneList) {
        this.context = context;
        this.pendingModelOneList = pendingModelOneList;
    }

    @NonNull
    @Override
    public Pending_Adapter_one.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_recycler, parent, false);


        return new Pending_Adapter_one.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(pendingModelOneList.get(position).getText());
        holder.count.setText(pendingModelOneList.get(position).getCount());

        final int[] row_index = new int[1];
        if (pendingModelOneList.get(position).getText().equals("ALL")){
            holder.linearLayout.setBackgroundResource(R.drawable.change_background);

        }
        String result = null;
        pendingModelOneList.get(position).getResult();


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (mListener != null) {


                        selectedItemPosition = position;
                        notifyDataSetChanged();


                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);

                        }

                    }


                }
            });




        if (selectedItemPosition == position) {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#F4941C"));
            holder.textView.setTextColor(Color.parseColor("#ffffff"));
            holder.count.setTextColor(Color.parseColor("#ffffff"));
        } else {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.textView.setTextColor(Color.parseColor("#000000"));
            holder.count.setTextColor(Color.parseColor("#000000"));
        }
    }


    // total number of rows
    @Override
    public int getItemCount() {

        return pendingModelOneList.size();

    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView,count;

        LinearLayout linearLayout;

        ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.txt1);
            linearLayout = itemView.findViewById(R.id.design_lnr);
            count = itemView.findViewById(R.id.count);




//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    if (mListener != null) {
//
//                        int position = getAdapterPosition();
//
//                        if (position != RecyclerView.NO_POSITION) {
//                            mListener.onItemClick(position);
//
//                        }
//
//                    }
//
//                }
//            });


//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    if (mListener != null) {
//
//                        int position = getAdapterPosition();
//                        selectedItemPosition = position;
//                        notifyDataSetChanged();
//
//
//                        if (position != RecyclerView.NO_POSITION) {
//                            mListener.onItemClick(position);
//
//                        }
//
//                    }
//                }
//            });
//
//            int position = getAdapterPosition();
//            if (selectedItemPosition == position) {
//                linearLayout.setBackgroundColor(Color.parseColor("#F4941C"));
//                textView.setTextColor(Color.parseColor("#ffffff"));
//            } else {
//                linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
//                textView.setTextColor(Color.parseColor("#000000"));
//            }
        }
    }


}