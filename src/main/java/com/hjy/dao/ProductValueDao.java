package com.hjy.dao;

import com.hjy.model.Product_Value;

import java.util.List;

/**
 * 产品和价格表数据访问类
 * @author hjy
 * @create 2017/12/21
 **/
public interface ProductValueDao {
    /**
     * @author: hjy
     * @description:
     */
    public List<Product_Value> selectAllProductValue();
}
