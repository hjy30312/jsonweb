package com.hjy.servlet.ShoppingCart;

import com.hjy.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: hjy
 * @description:
 */
@WebServlet(name = "PaymentServlet", urlPatterns = "/User/PaymentServlet")
public class PaymentServlet extends HttpServlet{

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
