package com.hjy.model;

import java.io.Serializable;

/**
 * @author hjy
 * @create 2017/11/19
 **/
public class Note implements Serializable{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
