package com.hjy.model;

/**
 * @author hjy
 * @create 2017/12/18
 **/
public class Product {
    /**产品表：
     id 产品编号
     name 名称
     manufacturer 生产厂家
     describe 说明
     */
    private String id;
    private String name;
    private String manufacturer;
    private String describe;


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
}
