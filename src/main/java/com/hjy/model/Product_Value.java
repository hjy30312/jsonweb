package com.hjy.model;

import java.sql.Time;
import java.util.Calendar;

/**
 * 产品和价格表
 * @author hjy
 * @create 2017/12/21
 **/
public class Product_Value {
    String id;      //产品编号
    private String name;    //名称
    private String manufacturer;    //生产厂家
    private String describe;        //说明
    private double value;   //价格
    private Time effectiveTime;     //价格有效时间
    private Time effectiveStratTime;    //有效开始时间
    private Time effectiveEndTime;      //有效结束时间


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

    public Time getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Time effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Time getEffectiveStratTime() {
        return effectiveStratTime;
    }

    public void setEffectiveStratTime(Time effectiveStratTime) {
        this.effectiveStratTime = effectiveStratTime;
    }

    public Time getEffectiveEndTime() {
        return effectiveEndTime;
    }

    public void setEffectiveEndTime(Time effectiveEndTime) {
        this.effectiveEndTime = effectiveEndTime;
    }
}
