package com.hjy.dao;

import com.hjy.model.Product;

import java.util.List;

/**
 * 产品数据访问类
 * @author hjy
 * @create 2017/12/18
 **/
public interface ProductDao {
    /**
     * 获取所有产品信息
     */
    public List<Product> selectAllProduct();

    /**
     * 通过Id获取一个产品
     * @param id
     * @return Product
     */
    public Product selectOneProduct(String id);
}
