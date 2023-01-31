package com.example.eagle;

public class Stage_model {

    String stage;
    String order_no;
    String completed_by;
    String completed_at;
    String start_at;
    public  Stage_model(){}

    public Stage_model(String stage, String order_no, String completed_by, String completed_at,String start_at) {
        this.stage = stage;
        this.order_no = order_no;
        this.completed_by = completed_by;
        this.completed_at = completed_at;
        this.start_at = start_at;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getCompleted_by() {
        return completed_by;
    }

    public void setCompleted_by(String completed_by) {
        this.completed_by = completed_by;
    }

    public String getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(String completed_at) {
        this.completed_at = completed_at;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }
}

