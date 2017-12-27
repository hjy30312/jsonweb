package com.hjy.daoimpl;

import com.hjy.dao.ProductValueDao;
import com.hjy.model.Product_Value;
import com.hjy.util.DatabaseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品和价格表数据访问类实现
 * @author hjy
 * @create 2017/12/21
 **/
public class ProductValueDaoImpl implements ProductValueDao {
    /**
     * 数据库的链接对象 conn
     * 预编译sql语句对象 psmt
     * 结果集 rs
     */
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;


    @Override
    public List<Product_Value> selectAllProductValue() {
        List<Product_Value> product_valueList = new ArrayList<Product_Value>();


        try {
            conn = DatabaseBean.getConnection();
            String sql = "";
            psmt = conn.prepareStatement(sql);

            psmt.executeQuery();
            while (rs.next()) {
                Product_Value product_value = new Product_Value();
                product_value.setId(rs.getString("id"));
                product_value.setName(rs.getString("name"));
                product_value.setManufacturer(rs.getString("manufacturer"));
                product_value.setDescribe(rs.getString("describe"));
                product_value.setValue(rs.getDouble("value"));
                product_value.setEffectiveTime(rs.getTime("effectiveTime"));
                product_value.setEffectiveStratTime(rs.getTime("effectiveStratTime "));
                product_value.setEffectiveEndTime(rs.getTime("effectiveEndTime"));
                product_valueList.add(product_value);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
        return product_valueList;
    }
}
