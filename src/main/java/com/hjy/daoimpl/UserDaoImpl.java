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
            String sql = "select * from tb_taobao_user where username=? and password=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,username);
            psmt.setString(2,password);
            rs = psmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
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
