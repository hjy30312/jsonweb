package com.hjy.model;

import java.io.Serializable;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public class Commodity implements Serializable{
    /**
     * id
     */
    private int id;
    /**
     * 名称
     */
    private String name;
    private String manufacturer;
    private String describe;
    private double value;

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


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
