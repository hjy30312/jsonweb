package com.hjy.daoimpl;

import com.hjy.dao.ValueDao;
import com.hjy.model.Value;
import com.hjy.util.DatabaseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 价格表数据访问类
 * @author hjy
 * @create 2017/12/21
 **/
public class ValueDaoImpl implements ValueDao {

    /**
     * 数据库的链接对象 conn
     * 预编译sql语句对象 psmt
     * 结果集 rs
     */
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;


    @Override
    public List<Value> selectAllValue() {
        List<Value> valueList = new ArrayList<Value>();
        try {
            conn = DatabaseBean.getConnection();

            String sql = "select * from taobao_value";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()) {
                Value value = new Value();
                value.setId(rs.getInt("id"));
                value.setValue(rs.getDouble("value"));
                value.setEffectiveTime(rs.getTime("effectiveTime"));
                value.setEffectiveStratTime(rs.getTime("effectiveStratTime "));
                value.setEffectiveEndTime(rs.getTime("effectiveEndTime"));
                valueList.add(value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs,psmt,conn);
        }
        return valueList;
    }

    @Override
    public Value selectOneValue(String id) {
        return null;
    }
}
