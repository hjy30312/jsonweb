package com.hjy.serviceimpl;

import com.hjy.dao.OrderDao;
import com.hjy.daoimpl.OrderDaoImpl;
import com.hjy.model.Order;
import com.hjy.service.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/26
 **/
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public List<Order> selectAllById(int userId) {
        List<Order> orderList = new ArrayList<Order>();
        orderList = orderDao.selectAllById(userId);
        return orderList;
    }

    @Override
    public void insertOrder(int userId, double value) {
        orderDao.insertOrder(userId, value);
    }
}
