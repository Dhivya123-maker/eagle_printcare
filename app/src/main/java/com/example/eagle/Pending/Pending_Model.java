package com.example.eagle.Pending;

public class Pending_Model {

    private String project_name;
    private String project_type;
    private String img;
    private String permission;
    private String id;
    private String status;
    private String current_stage;
    private String current_user;


    public Pending_Model() {
    }

    public Pending_Model(String project_name, String project_type, String img, String permission,String id,String status,String current_stage,String current_user) {
        this.project_name = project_name;
        this.project_type = project_type;
        this.img = img;
        this.permission = permission;
        this.id = id;
        this.status = status;
        this.current_stage = current_stage;
        this.current_user = current_user;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_type() {
        return project_type;
    }

    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrent_stage() {
        return current_stage;
    }

    public void setCurrent_stage(String current_stage) {
        this.current_stage = current_stage;
    }

    public String getCurrent_user() {
        return current_user;
    }

    public void setCurrent_user(String current_user) {
        this.current_user = current_user;
    }
}
