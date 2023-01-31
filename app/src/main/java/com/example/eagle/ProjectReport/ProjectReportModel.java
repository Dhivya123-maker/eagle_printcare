package com.example.eagle.ProjectReport;

public class ProjectReportModel {
    String s_no;
    String date;
    String delivery_date;
    String order_no;
    String job_card_no;
    String Customer;

    public String getS_no() {
        return s_no;
    }

    public void setS_no(String s_no) {
        this.s_no = s_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getJob_card_no() {
        return job_card_no;
    }

    public void setJob_card_no(String job_card_no) {
        this.job_card_no = job_card_no;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getJob_nature() {
        return Job_nature;
    }

    public void setJob_nature(String job_nature) {
        Job_nature = job_nature;
    }

    public String getQuantities() {
        return quantities;
    }

    public void setQuantities(String quantities) {
        this.quantities = quantities;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCoating() {
        return coating;
    }

    public void setCoating(String coating) {
        this.coating = coating;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String job_title;
    String Job_nature;

    public ProjectReportModel(String s_no, String date, String delivery_date, String order_no, String job_card_no, String customer, String job_title, String job_nature, String quantities, String company, String coating, String stage, String status) {
        this.s_no = s_no;
        this.date = date;
        this.delivery_date = delivery_date;
        this.order_no = order_no;
        this.job_card_no = job_card_no;
        Customer = customer;
        this.job_title = job_title;
        Job_nature = job_nature;
        this.quantities = quantities;
        this.company = company;
        this.coating = coating;
        this.stage = stage;
        this.status = status;
    }

    String quantities;
    String company;
    String coating;
    String stage;
    String status;

    public ProjectReportModel(){}
}

