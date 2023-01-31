package com.example.eagle.EmployeeReport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle.R;

import java.util.List;

public class EmployeeReportAdapter extends RecyclerView.Adapter<EmployeeReportAdapter.ViewHolder> {


    List<EmployeeReportModel> employeeReportModelList;
    private Context context;


    public EmployeeReportAdapter(Context context, List<EmployeeReportModel> employeeReportModelList) {
        this.context = context;
        this.employeeReportModelList = employeeReportModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_recycle, parent, false);


        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.s_no.setText(employeeReportModelList.get(position).getS_no());
        holder.date.setText(employeeReportModelList.get(position).getDate());
        holder.delivery_date.setText(employeeReportModelList.get(position).getDelivery_date());
        holder.order_no.setText(employeeReportModelList.get(position).getOrder_no());
        holder.job_card_no.setText(employeeReportModelList.get(position).getJob_card_no());
        holder.customer.setText(employeeReportModelList.get(position).getCustomer());
        holder.job_title.setText(employeeReportModelList.get(position).getJob_title());
        holder.job_nature.setText(employeeReportModelList.get(position).getJob_nature());
        holder.quantity.setText(employeeReportModelList.get(position).getQuantity());
        holder.company.setText(employeeReportModelList.get(position).getCompany());
        holder.stage.setText(employeeReportModelList.get(position).getStage());
        holder.status.setText(employeeReportModelList.get(position).getStatus());


        if(position ==0){
            holder.one.setVisibility(View.VISIBLE);
            holder.two.setVisibility(View.VISIBLE);
            holder.three.setVisibility(View.VISIBLE);
            holder.four.setVisibility(View.VISIBLE);
            holder.five.setVisibility(View.VISIBLE);
            holder.six.setVisibility(View.VISIBLE);
            holder.seven.setVisibility(View.VISIBLE);
            holder.eight.setVisibility(View.VISIBLE);
            holder.nine.setVisibility(View.VISIBLE);
            holder.ten.setVisibility(View.VISIBLE);
            holder.eleven.setVisibility(View.VISIBLE);
            holder.twelve.setVisibility(View.VISIBLE);
            holder.thirteen.setVisibility(View.VISIBLE);
            holder.fourteen.setVisibility(View.VISIBLE);
            holder.fifteen.setVisibility(View.VISIBLE);

        }


        else{
            holder.one.setVisibility(View.GONE);
            holder.two.setVisibility(View.GONE);
            holder.three.setVisibility(View.GONE);
            holder.four.setVisibility(View.GONE);
            holder.five.setVisibility(View.GONE);
            holder.six.setVisibility(View.GONE);
            holder.seven.setVisibility(View.GONE);
            holder.eight.setVisibility(View.GONE);
            holder.nine.setVisibility(View.GONE);
            holder.ten.setVisibility(View.GONE);
            holder.eleven.setVisibility(View.GONE);
            holder.twelve.setVisibility(View.GONE);
            holder.thirteen.setVisibility(View.GONE);
            holder.fourteen.setVisibility(View.GONE);
            holder.fifteen.setVisibility(View.GONE);

        }

    }


    // total number of rows
    @Override
    public int getItemCount() {

        return 20;

    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView s_no,employee,stage,start,complete,customer,job_title,date,delivery_date,order_no,job_card_no,job_nature,quantity,company,status;
        TextView one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen,fifteen;


        ViewHolder(View itemView) {
            super(itemView);

            s_no = itemView.findViewById(R.id.txt1);
            employee = itemView.findViewById(R.id.txt2);
            stage = itemView.findViewById(R.id.txt3);
            start = itemView.findViewById(R.id.txt4);
            complete = itemView.findViewById(R.id.txt5);
            customer = itemView.findViewById(R.id.txt6);
            job_title = itemView.findViewById(R.id.txt7);
            date = itemView.findViewById(R.id.txt8);
            delivery_date = itemView.findViewById(R.id.txt9);
            order_no = itemView.findViewById(R.id.txt10);
            job_card_no = itemView.findViewById(R.id.txt11);
            job_nature = itemView.findViewById(R.id.txt12);
            quantity = itemView.findViewById(R.id.txt13);
            company = itemView.findViewById(R.id.txt14);
            status = itemView.findViewById(R.id.txt15);

            one = itemView.findViewById(R.id.one);
            two = itemView.findViewById(R.id.two);
            three = itemView.findViewById(R.id.three);
            four = itemView.findViewById(R.id.four);
            five = itemView.findViewById(R.id.five);
            six = itemView.findViewById(R.id.six);
            seven = itemView.findViewById(R.id.seven);
            eight = itemView.findViewById(R.id.eight);
            nine = itemView.findViewById(R.id.nine);
            ten = itemView.findViewById(R.id.ten);
            eleven = itemView.findViewById(R.id.eleven);
            twelve = itemView.findViewById(R.id.twelve);
            thirteen = itemView.findViewById(R.id.thirteen);
            fourteen = itemView.findViewById(R.id.fourteen);
            fifteen = itemView.findViewById(R.id.fifteen);





        }


    }


}
