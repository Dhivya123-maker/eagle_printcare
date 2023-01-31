package com.example.eagle.Dashboard;

public class DashboardModel{

    private String text;
    private String text_one;



    public DashboardModel(){}

    public String getText_one() {
        return text_one;
    }

    public void setText_one(String text_one) {
        this.text_one = text_one;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text= text;
    }




    public DashboardModel(String text_one,String text) {

        this.text= text;
        this.text_one= text_one;

    }}
