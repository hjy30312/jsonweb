package com.hjy.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hjy.util.DatabaseBean;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "productListServlet", urlPatterns = "productList.do")
/**
 * @author: hjy
 * @description: 得到购物车的列表头信息
 */
public class ProductListServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*InputStream in = ProductListServlet.class.getResourceAsStream("/product.json");
        JSONObject jsonObject = (JSONObject) JSON.toJSON(in);
        String json = jsonObject.toString();
        PrintWriter out = response.getWriter();
        out.print(json);
        out.close();*/

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
