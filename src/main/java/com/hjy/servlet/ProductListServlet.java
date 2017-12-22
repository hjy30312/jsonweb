package com.hjy.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.PatternSyntaxException;

/**
 * 得到购物车的列表信息
 * @author hjy
 * @create 2017/12/21
 **/
public class ProductListServlet extends HttpServlet {





    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
