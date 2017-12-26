package com.hjy.dao;

import com.hjy.model.Order;

import java.util.List;

/**
 * @author hjy
 * @create 2017/12/26
 **/
public interface OrderDao {
    public List<Order> selectAllById(int userId);
    public void insertOrder(int user_id,double value);
}
