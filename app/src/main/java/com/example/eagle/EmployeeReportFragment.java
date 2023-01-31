package com.example.eagle;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle.EmployeeReport.EmployeeReportAdapter;
import com.example.eagle.EmployeeReport.EmployeeReportModel;
import com.example.eagle.R;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


public class EmployeeReportFragment extends Fragment {

    List<EmployeeReportModel> employeeReportModelList;
    EmployeeReportAdapter employeeReportAdapter;
    RecyclerView recyclerView;
    LinearLayout export;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_employee_report, container, false);


        recyclerView = view.findViewById(R.id.recycle);
        export = view.findViewById(R.id.export_lnr);

        if (Build.VERSION.SDK_INT >= 23) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        }

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            manager.createNotificationChannel(notificationChannel);

        }
        export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("Custom Sheet");


                employeeReportModelList = new ArrayList<>();
                for(int i=0;i<=20;i++){
                    EmployeeReportModel reportModel = new EmployeeReportModel();
                    reportModel.setS_no("1");
                    reportModel.setDate("02-04-2022");
                    reportModel.setDelivery_date("02-04-2022");
                    reportModel.setOrder_no("March 194/2022");
                    reportModel.setJob_card_no("060");
                    reportModel.setCustomer("LGB - RDB");
                    reportModel.setJob_title("Route Card Rubber Moulded Products");
                    reportModel.setJob_nature("Card");
                    reportModel.setQuantity("4000");
                    reportModel.setCompany("LGB - RDB");
                    reportModel.setStage("Designing Approval");
                    reportModel.setStatus("Completed");
                    reportModel.setStart("10-05-2022 03:22 PM");
                    reportModel.setComplete("10-05-2022 03:22 PM");
                    reportModel.setEmployee("Sharmila Devi");

                    employeeReportModelList.add(reportModel);


                    String[][] bookData = {

                            {"S_No","Date","Delivery Date","Order No"
                                    ,"Jobcard No","Customer","Job Title","Job Nature",
                                    "Quantities","Company","Coating","Stage","Status"},




                    };


                    for(int  i2=0; i2<=5; i2++) {


                        Row row = sheet.createRow(i);

                        row.createCell(0).setCellValue(employeeReportModelList.get(i).getS_no());
                        row.createCell(1).setCellValue(employeeReportModelList.get(i).getDate());
                        row.createCell(2).setCellValue(employeeReportModelList.get(i).getDelivery_date());
                        row.createCell(3).setCellValue(employeeReportModelList.get(i).getOrder_no());
                        row.createCell(4).setCellValue(employeeReportModelList.get(i).getJob_card_no());
                        row.createCell(5).setCellValue(employeeReportModelList.get(i).getCustomer());
                        row.createCell(6).setCellValue(employeeReportModelList.get(i).getJob_title());
                        row.createCell(7).setCellValue(employeeReportModelList.get(i).getJob_nature());
                        row.createCell(8).setCellValue(employeeReportModelList.get(i).getQuantity());
                        row.createCell(9).setCellValue(employeeReportModelList.get(i).getCompany());
                        row.createCell(10).setCellValue(employeeReportModelList.get(i).getStart());
                        row.createCell(10).setCellValue(employeeReportModelList.get(i).getComplete());
                        row.createCell(11).setCellValue(employeeReportModelList.get(i).getStage());
                        row.createCell(12).setCellValue(employeeReportModelList.get(i).getStatus());
                        row.createCell(12).setCellValue(employeeReportModelList.get(i).getEmployee());




                    }

                    int rowCount = 0;

                    for (String[] aBook : bookData) {
                        Row row = sheet.createRow(rowCount++);

                        int columnCount = 0;
                        for (Object field : aBook) {
                            Cell cell = row.createCell(columnCount++);
                            if (field instanceof String) {
                                cell.setCellValue((String) field);
                            } else if (field instanceof Integer) {
                                cell.setCellValue((Integer) field);
                            }
                        }

                    }


                }


                File direct = new File(Environment.getExternalStorageDirectory()+"/tt");
                File direct1 = new File(Environment.getExternalStorageDirectory()+"/tt/cc.xls");

                Log.i("fhiehwfiotre",direct.toString());
                if(!direct.exists()) {
                    direct.mkdir();
                    try {
                        if (!direct1.exists()) {
                            direct1.createNewFile();
                        }

                        FileOutputStream fileOutputStream = new FileOutputStream(direct1);
                        workbook.write(fileOutputStream);

                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getContext(), "File Downloaded Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "File already exists", Toast.LENGTH_SHORT).show();
                }



                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(getContext(),"My Notification");

                builder.setContentTitle("Title");
                builder.setContentText("Simple notification");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                builder.setDefaults(Notification.DEFAULT_SOUND);
                builder.setWhen(System.currentTimeMillis());

                Intent intent = new Intent(Intent.ACTION_VIEW);
                File file = new File("/storage/emulated/0/"+"/tt/cc.xls");
                Uri path = FileProvider.getUriForFile(getActivity(), "com.example.eagle.provider", file);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Log.i("qwuioegrioeuy2r",file.toString());
                intent.setDataAndType(path, "application/vnd.ms-excel");



                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(),0,intent,PendingIntent.FLAG_IMMUTABLE);
                builder.setContentIntent(pendingIntent);


                // Add as notification
                NotificationManager notificationManager= (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1,builder.build());


            }
        });


        employeeReportModelList = new ArrayList<>();
        for(int i=0;i<=20;i++){
            EmployeeReportModel reportModel = new EmployeeReportModel();
            reportModel.setS_no("1");
            reportModel.setDate("02-04-2022");
            reportModel.setDelivery_date("02-04-2022");
            reportModel.setOrder_no("March 194/2022");
            reportModel.setJob_card_no("060");
            reportModel.setCustomer("LGB - RDB");
            reportModel.setJob_title("Route Card Rubber Moulded Products");
            reportModel.setJob_nature("Card");
            reportModel.setQuantity("4000");
            reportModel.setCompany("LGB - RDB");
            reportModel.setStage("Designing Approval");
            reportModel.setStatus("Completed");
            reportModel.setStart("10-05-2022 03:22 PM");
            reportModel.setComplete("10-05-2022 03:22 PM");
            reportModel.setEmployee("Sharmila Devi");

            employeeReportModelList.add(reportModel);



        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        employeeReportAdapter =  new EmployeeReportAdapter(getActivity(),employeeReportModelList);
        recyclerView.setAdapter(employeeReportAdapter);
        LinearLayoutManager layoutManager1=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recyclerView.setLayoutManager(layoutManager1);


        return view;
    }
}