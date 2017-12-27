package com.hjy.service;

import com.hjy.model.Order;

import java.util.List;

/**
 * @author hjy
 * @create 2017/12/26
 **/
public interface OrderService {
    public List<Order> selectAllById(int userId);
    public void insertOrder(int usrId, double value);
}
