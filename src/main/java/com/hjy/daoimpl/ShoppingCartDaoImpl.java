package com.hjy.daoimpl;

import com.hjy.dao.ShoppingCartDao;
import com.hjy.model.ShoppingCart;
import com.hjy.util.DatabaseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    /**
     * 数据库的链接对象 conn
     * 预编译sql语句对象 psmt
     * 结果集 rs
     */
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public void insertShoppingCart(int user_id, int commodity_id, double value) {
        try {
            conn = DatabaseBean.getConnection();
            String sql = "INSERT INTO tb_ShoppingCart(id,user_id,commodity_id,value) VALUES (ShoppingCart_id.nextval,?,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, user_id);
            psmt.setInt(2, commodity_id);
            psmt.setDouble(3,value);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(psmt,conn);
        }
    }

    @Override
    public List<ShoppingCart> selectAllByUserID(int user_id) {
        List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
        try {
            conn = DatabaseBean.getConnection();
            String sql = "SELECT * FROM tb_ShoppingCart WHERE user_id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1,user_id);
            rs = psmt.executeQuery();
            while (rs.next()) {
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setId(rs.getInt("id"));
                shoppingCart.setCommodity_id(rs.getInt("commodity_id"));
                shoppingCart.setUser_id(rs.getInt("user_id"));
                shoppingCart.setValue(rs.getDouble("value"));
                shoppingCartList.add(shoppingCart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
        return shoppingCartList;
    }

    @Override
    public void deleteOneShoppingCartById(int id) {
        try {
            conn = DatabaseBean.getConnection();
            String sql = "DELETE FROM tb_ShoppingCart WHERE id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1,id);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(psmt,conn);
        }
    }
}
