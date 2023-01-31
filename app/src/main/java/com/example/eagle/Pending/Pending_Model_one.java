package com.example.eagle.Pending;

public class Pending_Model_one {

    private String text;
    private  int id;
    public String result;
    private String count;



    public Pending_Model_one(){}

    public Pending_Model_one(String text, int id,String result,String count) {
        this.text = text;
        this.id = id;
        this.result = result;
        this.count = count;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
