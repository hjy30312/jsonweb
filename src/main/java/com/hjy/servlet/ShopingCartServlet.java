package com.hjy.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hjy.model.Commodity;
import com.hjy.service.CommodityService;
import com.hjy.service.ShopingCartService;
import com.hjy.serviceimpl.CommodityServiceImpl;
import com.hjy.serviceimpl.ShopingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/25
 **/
public class ShopingCartServlet extends HttpServlet{

    private ShopingCartService shopingCartService = new ShopingCartServiceImpl();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user_id = request.getParameter("user_id");
        String commodity_id = request.getParameter("commodity_id");
        shopingCartService.insertShopingCart(Integer.parseInt(user_id),Integer.parseInt(commodity_id));
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
