package com.example.eagle.EmployeeReport;

public class EmployeeReportModel {
    String s_no;
    String employee;
    String stage;
    String start;
    String complete;

    public String getS_no() {
        return s_no;
    }

    public void setS_no(String s_no) {
        this.s_no = s_no;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
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

    public String getJob_nature() {
        return job_nature;
    }

    public void setJob_nature(String job_nature) {
        this.job_nature = job_nature;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String customer;
    String job_title;
    String date;

    public EmployeeReportModel(String s_no, String employee, String stage, String start, String complete, String customer, String job_title, String date, String delivery_date, String order_no, String job_card_no, String job_nature, String quantity, String company, String status) {
        this.s_no = s_no;
        this.employee = employee;
        this.stage = stage;
        this.start = start;
        this.complete = complete;
        this.customer = customer;
        this.job_title = job_title;
        this.date = date;
        this.delivery_date = delivery_date;
        this.order_no = order_no;
        this.job_card_no = job_card_no;
        this.job_nature = job_nature;
        this.quantity = quantity;
        this.company = company;
        this.status = status;
    }

    String delivery_date;
    String order_no;
    String job_card_no;
    String job_nature;
    String quantity;
    String company;
    String status;

    public EmployeeReportModel(){}
}
