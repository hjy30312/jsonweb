package com.hjy.model;

import java.sql.Timestamp;

/**
 * @author hjy
 * @create 2017/12/26
 **/
public class Order {
    private int id;
    private int user_id;
    private Timestamp time;
    private double value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
