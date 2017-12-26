package com.hjy.daoimpl;

import com.hjy.dao.OrderDao;
import com.hjy.model.Order;
import com.hjy.util.DatabaseBean;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            String sql = "select * from tb_order where id=?";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setUser_id(rs.getInt("user_id"));
                order.setTime(rs.getTimestamp("time"));
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
    public void insertOrder(int user_id, double value) {
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from tb_order where id=?";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setUser_id(rs.getInt("user_id"));
                order.setTime(rs.getTimestamp("time"));
                order.setValue(rs.getDouble("value"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs,psmt,conn);
        }
    }
}
