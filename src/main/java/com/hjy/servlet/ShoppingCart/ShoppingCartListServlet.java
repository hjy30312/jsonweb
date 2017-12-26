package com.hjy.servlet.ShoppingCart;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hjy.model.Commodity;
import com.hjy.model.ShoppingCart;
import com.hjy.model.User;
import com.hjy.service.CommodityService;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/26
 **/
@WebServlet(name = "ShoppingCartListServlet", urlPatterns = "/cartList")
public class ShoppingCartListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ShoppingCartService cartService = new ShoppingCartServiceImpl();
        List<ShoppingCart> cartList = new ArrayList<ShoppingCart>();
        HttpSession session = request.getSession();
        User user = new User();
        user = (User) session.getAttribute("user");
        cartList = cartService.selectAllByUserID(user.getId());
        String jsonObject = JSON.toJSONString(cartList);
        JSONArray jsonArray = (JSONArray) JSONArray.parse(jsonObject);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonArray.toString());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
