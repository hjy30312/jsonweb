package com.hjy.servlet;


import com.hjy.service.ShoppingCartService;
import com.hjy.serviceimpl.CommodityServiceImpl;
import com.hjy.serviceimpl.ShoppingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author hjy
 * @create 2017/12/25
 **/
@WebServlet(name = "insertShoppingCartServlet", urlPatterns = "/InsertShoppingCartServlet.do")
public class InsertShoppingCartServlet extends HttpServlet{

    private ShoppingCartService shopingCartService = new ShoppingCartServiceImpl();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user_id = request.getParameter("user_id");
        String commodity_id = request.getParameter("commodity_id");
        shopingCartService.insertShoppingCart(Integer.parseInt(user_id),Integer.parseInt(commodity_id));
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
