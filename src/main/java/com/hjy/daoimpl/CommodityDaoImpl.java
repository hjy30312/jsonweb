package com.hjy.daoimpl;

import com.hjy.dao.CommodityDao;
import com.hjy.model.Commodity;
import com.hjy.util.DatabaseBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public class CommodityDaoImpl implements CommodityDao {

    /**
     * 数据库的链接对象 conn
     * 预编译sql语句对象 psmt
     * 结果集 rs
     */
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public List<Commodity> selectAllCommodity() {
        List<Commodity> commoditiesList = new ArrayList<Commodity>();
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from tb_commodity";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                Commodity commodity = new Commodity();
                commodity.setId(rs.getInt("id"));
                commodity.setName(rs.getString("name"));
                commodity.setType(rs.getString("type"));
                commodity.setWeight(rs.getDouble("weight"));
                commodity.setValue(rs.getDouble("value"));
                commoditiesList.add(commodity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs,psmt,conn);
        }
        return commoditiesList;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        CommodityDao commodityDao = new CommodityDaoImpl();
        List<Commodity> commdities = null;

        commdities = commodityDao.selectAllCommodity();
        System.out.println(commdities.get(0).getId());
    }
}
