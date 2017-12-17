package com.hjy.servlet;


import com.alibaba.fastjson.JSONArray;
import com.hjy.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hjy
 * @create 2017/11/19
 **/
public class LoadStudentServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req,
                        HttpServletResponse res) throws ServletException, IOException {
        //将笔记信息以JSON格式输出   需通过DAO层封装实现
        List<Student> list = new ArrayList<Student>();
        Student note = new Student();
        note.setId("01");
        note.setName("ID");
        Student note1 = new Student();
        note1.setId("02");
        note1.setName("Name");
        list.add(note);
        list.add(note1);
        //将note对象转成json字符串
        //JSONObject json = (JSONObject) JSONObject.toJSON(note);
        //String json_str = json.toString();
       // System.out.println(json_str);

        //将list转成json字符串
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
        String jsonArr_str = jsonArray.toString();
        System.out.println(jsonArr_str);
        System.out.println("123");
        //将json字符串输出
        res.setContentType(
                "text/plain;charset=utf-8"
        );
        PrintWriter out = res.getWriter();
       // out.print(json_str);
        out.print(jsonArr_str);
        out.close();
    }
}
