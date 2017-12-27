package com.hjy.daoimpl;

import com.hjy.dao.OrderDao;
import com.hjy.model.Order;
import com.hjy.util.DatabaseBean;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/26
 **/
public class OrderDaoImpl implements OrderDao {

    /**
     * 数据库的链接对象 conn
     * 预编译sql语句对象 psmt
     * 结果集 rs
     */
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public List<Order> selectAllById(int userId) {
        List<Order> orderList = new ArrayList<Order>();
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from tb_order where user_id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1,userId);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setUser_id(rs.getInt("user_id"));
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Timestamp timestamp = rs.getTimestamp("time");
                order.setTime(dateFormat.format(timestamp));
                order.setValue(rs.getDouble("value"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs,psmt,conn);
        }
        return orderList;
    }

    @Override
    public void insertOrder(int userId, double value) {
        Calendar cal = Calendar.getInstance();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTime().getTime());

        try {
            conn = DatabaseBean.getConnection();
            String sql =
                    "INSERT INTO tb_order(id,user_id,time,value) VALUES (order_id.nextval,?,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1,userId);
            psmt.setTimestamp(2, timestamp);
            psmt.setDouble(3,value);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(psmt,conn);
        }
    }

    /**
     * 测试时间
     * @param args
     */
    public static void main(String[] args) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        System.out.println(dateFormat.format(date));


        OrderDao orderDao =  new OrderDaoImpl();
        //orderDao.insertOrder(1,1,1);
    }


}
