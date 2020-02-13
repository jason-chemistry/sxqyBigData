package com.test.api.model;

import java.sql.Timestamp;

public class Request {
    private int id;
    private String app_way;
    private String count;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApp_way() {
        return app_way;
    }

    public void setApp_way(String app_way) {
        this.app_way = app_way;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
