package com.hjy.model;

import java.io.Serializable;

/**
 * @author hjy
 * @create 2017/11/19
 **/
public class Student implements Serializable{
    private int id;
    private String name;
    private String sno;
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
