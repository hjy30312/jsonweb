package com.hjy.dao;

import com.hjy.model.Product;

import java.util.List;

/**
 * @author hjy
 * @create 2017/12/18
 **/
public interface ProductDao {
    /**
     * 获取所有产品
     */
    public List<Product> selectAllProduct();

    /**
     * 通过Id获取一个产品
     * @param id
     */
    public void selectOneProduct(String id);
}
