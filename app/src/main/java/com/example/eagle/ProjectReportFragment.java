package com.example.eagle;


import android.Manifest;
import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle.ChangePassword;
import com.example.eagle.ForgetPassword;
import com.example.eagle.ProjectReport.ProjectReportAdapter;
import com.example.eagle.ProjectReport.ProjectReportModel;
import com.example.eagle.R;
import com.example.eagle.SplashScreen;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ProjectReportFragment extends Fragment {

    List<ProjectReportModel> reportModelList;
    ProjectReportAdapter reportAdapter;
    RecyclerView recyclerView;
    ImageView from,to;
    Calendar calendar;
    EditText from_edit,to_edit;
    LinearLayout export,filter;
    Context context;
    File direct,direct1,direct2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_project_report, container, false);


        recyclerView = view.findViewById(R.id.recycle);
        export = view.findViewById(R.id.export);
        filter = view.findViewById(R.id.filter);


        from = view.findViewById(R.id.from_calender);
        to = view.findViewById(R.id.to_calender);
        from_edit = view.findViewById(R.id.from_edit);
        to_edit = view.findViewById(R.id.to_edit);




        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel("My Notification","My Notification",NotificationManager.IMPORTANCE_DEFAULT);
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

                export();
            }
        });

        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();

                final DatePickerDialog.OnDateSetListener dateA = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);


                        from_edit.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);



                    }
                };

                new DatePickerDialog(getActivity(), dateA, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();

                final DatePickerDialog.OnDateSetListener dateA = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);


                        to_edit.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);



                    }
                };

                new DatePickerDialog(getActivity(), dateA, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        reportModelList = new ArrayList<>();
        for(int i=0;i<=20;i++){
            ProjectReportModel reportModel = new ProjectReportModel();
            reportModel.setS_no("1");
            reportModel.setDate("02-04-2022");
            reportModel.setDelivery_date("02-04-2022");
            reportModel.setOrder_no("March 194/2022");
            reportModel.setJob_card_no("060");
            reportModel.setCustomer("LGB - RDB");
            reportModel.setJob_title("Route Card Rubber Moulded Products");
            reportModel.setJob_nature("Card");
            reportModel.setQuantities("4000");
            reportModel.setCompany("LGB - RDB");
            reportModel.setCoating(" - ");
            reportModel.setStage("Other");
            reportModel.setStatus("Completed");

            reportModelList.add(reportModel);



        }


        reportAdapter =  new ProjectReportAdapter(getActivity(),reportModelList);
        recyclerView.setAdapter(reportAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(linearLayoutManager);


        return  view;
    }

    public  void export(){
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED  && ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        }else{

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Custom Sheet");


            reportModelList = new ArrayList<>();
            for (int i = 0; i <= 5; i++) {
                ProjectReportModel reportModel = new ProjectReportModel();
                reportModel.setS_no("5");
                reportModel.setDate("02-04-2022");
                reportModel.setDelivery_date("02-04-2022");
                reportModel.setOrder_no("March 194/2022");
                reportModel.setJob_card_no("060");
                reportModel.setCustomer("LGB - RDB");
                reportModel.setJob_title("Route Card Rubber Moulded Products");
                reportModel.setJob_nature("Card");
                reportModel.setQuantities("4000");
                reportModel.setCompany("LGB - RDB");
                reportModel.setCoating(" - ");
                reportModel.setStage("Other");
                reportModel.setStatus("Completed");

                reportModelList.add(reportModel);


                String[][] bookData = {

                        {"S_No","Date","Delivery Date","Order No"
                                ,"Jobcard No","Customer","Job Title","Job Nature",
                                "Quantities","Company","Coating","Stage","Status"},




                };


                for(int  i2=0; i2<=5; i2++) {


                    Row row = sheet.createRow(i);

                    row.createCell(0).setCellValue(reportModelList.get(i).getS_no());
                    row.createCell(1).setCellValue(reportModelList.get(i).getDate());
                    row.createCell(2).setCellValue(reportModelList.get(i).getDelivery_date());
                    row.createCell(3).setCellValue(reportModelList.get(i).getOrder_no());
                    row.createCell(4).setCellValue(reportModelList.get(i).getJob_card_no());
                    row.createCell(5).setCellValue(reportModelList.get(i).getCustomer());
                    row.createCell(6).setCellValue(reportModelList.get(i).getJob_title());
                    row.createCell(7).setCellValue(reportModelList.get(i).getJob_nature());
                    row.createCell(8).setCellValue(reportModelList.get(i).getQuantities());
                    row.createCell(9).setCellValue(reportModelList.get(i).getCompany());
                    row.createCell(10).setCellValue(reportModelList.get(i).getCoating());
                    row.createCell(11).setCellValue(reportModelList.get(i).getStage());
                    row.createCell(12).setCellValue(reportModelList.get(i).getStatus());

                }

                int rowCount = 0;

                for (String[] aBook : bookData) {
                    Row row = sheet.createRow(rowCount++);

                    int columnCount = 0;
                    for (Object field : aBook) {
                        Cell cell = row.createCell(columnCount++);
                        Log.i("jueysdgiuey7",cell.toString());
                        if (field instanceof String) {
                            cell.setCellValue((String) field);
                        } else if (field instanceof Integer) {
                            cell.setCellValue((Integer) field);
                        }
                    }

                }


            }

            direct = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"/qqq");
            direct1 = new File(Environment.getExternalStorageDirectory(),"/qqq/Demo.xls");




            if(!direct.exists()) {
                direct.mkdir();


                try {
                    if (!direct1.exists()) {
                        direct1.createNewFile();
                        Log.i("fileeee",direct1.toString());


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
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(getContext(),"My Notification");

                builder.setContentTitle("Title");
                builder.setContentText("Simple notification");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                builder.setDefaults(Notification.DEFAULT_SOUND);
                builder.setWhen(System.currentTimeMillis());

                Intent intent = new Intent(Intent.ACTION_VIEW);
                File file = new File("/storage/emulated/0/"+"/qqq/Demo.xls");
                Uri path = FileProvider.getUriForFile(getContext(), "com.example.eagle.provider", file);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Log.i("qwuioegrioeuy2r",file.toString());
                intent.setDataAndType(path, "application/vnd.ms-excel");



                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);


                // Add as notification
                NotificationManager notificationManager= (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1,builder.build());

            }
            else if(direct.exists()){
                Toast.makeText(getContext(), "File already exists",Toast.LENGTH_SHORT).show();




            }


        }

    }

}


