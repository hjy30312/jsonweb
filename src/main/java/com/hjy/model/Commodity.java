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
    /**
     * 类型
     */
    private String type;
    private double weight;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
