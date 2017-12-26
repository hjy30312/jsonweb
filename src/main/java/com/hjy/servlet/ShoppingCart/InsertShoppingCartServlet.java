package com.hjy.servlet.ShoppingCart;


import com.hjy.model.User;
import com.hjy.service.ShoppingCartService;
import com.hjy.serviceimpl.CommodityServiceImpl;
import com.hjy.serviceimpl.ShoppingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author hjy
 * @create 2017/12/25
 **/
@WebServlet(name = "InsertShoppingCartServlet", urlPatterns = "/User/InsertShoppingCartServlet")
public class InsertShoppingCartServlet extends HttpServlet{

    private ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(123);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int user_id = user.getId();
        String commodity_id = request.getParameter("id");
        shoppingCartService.insertShoppingCart(user_id,Integer.parseInt(commodity_id));
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
