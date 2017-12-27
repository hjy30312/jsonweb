package com.hjy.servlet.ShoppingCart;

import com.hjy.model.User;
import com.hjy.service.ShoppingCartService;
import com.hjy.serviceimpl.ShoppingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: hjy
 * @description:通过购物车ID删除
 */
@WebServlet(name = "DeleteCartServlet", urlPatterns = "/User/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet{

    private ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        shoppingCartService.deleteOneShoppingCartById(Integer.parseInt(id));
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
