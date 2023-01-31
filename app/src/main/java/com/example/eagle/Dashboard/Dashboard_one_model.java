package com.example.eagle.Dashboard;

public class Dashboard_one_model {

    private String text;
    private String id;
    public String project_count;


    public Dashboard_one_model() {
    }

    public Dashboard_one_model(String text, String id,String project_count) {
        this.text = text;
        this.id = id;
        this.project_count =project_count;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject_count() {
        return project_count;
    }

    public void setProject_count(String project_count) {
        this.project_count = project_count;
    }
}