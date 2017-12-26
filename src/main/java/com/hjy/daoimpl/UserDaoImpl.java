package com.hjy.daoimpl;

import com.hjy.dao.UserDao;
import com.hjy.model.User;
import com.hjy.util.DatabaseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author hjy
 * @create 2017/12/10
 **/
public class UserDaoImpl implements UserDao {

    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public User selectOneByUsernamePassword(String username, String password) {
        User user = null;
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from tb_user where username=? and password=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,username);
            psmt.setString(2,password);
            rs = psmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs,psmt,conn);
        }
        return user;
    }

    @Override
    public void updatePassword(int id, String oldPassword,String password) {
        try {
            conn = DatabaseBean.getConnection();
            String sql = "UPDATE tb_user SET password=? where id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,password);
            psmt.setInt(2,id);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(psmt,conn);
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        String username = "123";
        String password = "456";
        User user = null;
        user = userDao.selectOneByUsernamePassword(username,password);
        System.out.println(user);
    }
}
