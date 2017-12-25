package com.hjy.daoimpl;

import com.hjy.dao.ShopingCartDao;
import com.hjy.model.ShopingCart;
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

    @Override
    public List<ShopingCart> selectAllByUserID(int user_id) {
        List<ShopingCart> shopingCartList = new ArrayList<ShopingCart>();
        try {
            conn = DatabaseBean.getConnection();
            String sql = "SELECT * FROM tb_ShoppingCart WHERE user_id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1,user_id);
            rs = psmt.executeQuery();
            while (rs.next()) {
                ShopingCart shopingCart = new ShopingCart();
                shopingCart.setId(rs.getInt(rs.getInt("id")));
                shopingCart.setCommodity_id(rs.getInt("commodity_id"));
                shopingCart.setUser_id(rs.getInt("user_id"));
                shopingCart.setValue(rs.getDouble("value"));
                shopingCartList.add(shopingCart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
        return shopingCartList;
    }

    @Override
    public void deleteOneShoppingCartByid(int id) {
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
