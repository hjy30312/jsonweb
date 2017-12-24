package com.hjy.daoimpl;

import com.hjy.dao.ShopingCartDao;
import com.hjy.util.DatabaseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public class ShopingCartDaoImpl implements ShopingCartDao {
    /**
     * 数据库的链接对象 conn
     * 预编译sql语句对象 psmt
     * 结果集 rs
     */
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public void insertShopingCart(int user_id, int commodity_id) {
        try {
            conn = DatabaseBean.getConnection();
            String sql = "INSERT INTO tb_ShoppingCart(id,user_id,commodity_id,value) VALUES ()";
            psmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(psmt,conn);
        }

    }
}
