package com.hjy.daoimpl;

import com.hjy.dao.ProductDao;
import com.hjy.model.Product;
import com.hjy.util.DatabaseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品数据访问类实现
 * @author hjy
 * @create 2017/12/18
 **/
public class ProductDaoImpl implements ProductDao {
    /**
     * 数据库的链接对象 conn
     * 预编译sql语句对象 psmt
     * 结果集 rs
     */
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public List<Product> selectAllProduct() {
        List<Product> productList = new ArrayList<Product>();

        try {
            conn = DatabaseBean.getConnection();

            String sql = "select * from taobao_product";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getString("id"));
                product.setName(rs.getString("name"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setDescribe(rs.getString("describe"));
                productList.add(product);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs,psmt,conn);
        }
        return productList;
    }

    @Override
    public Product selectOneProduct(String id) {

        return null;
    }
}
