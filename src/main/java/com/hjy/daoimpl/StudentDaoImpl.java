package com.hjy.daoimpl;

import com.hjy.dao.StudentDao;
import com.hjy.model.Student;
import com.hjy.util.DatabaseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author hjy
 * @create 2017/11/28
 **/
public class StudentDaoImpl implements StudentDao {

    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;


    @Override
    public void insertStudent(Student stu) {
        try {
            conn = DatabaseBean.getConnection();

            String sql = "insert into rb_json_student(id,name) VALUES (?,?) ";

            psmt = conn.prepareStatement(sql);
            //psmt.setString(1, stu.getId());
            psmt.setString(2, stu.getName());
            psmt.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
