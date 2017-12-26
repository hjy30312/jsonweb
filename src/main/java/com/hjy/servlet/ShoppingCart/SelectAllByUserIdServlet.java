package com.hjy.servlet.ShoppingCart;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hjy.model.ShoppingCart;
import com.hjy.model.User;
import com.hjy.service.ShoppingCartService;
import com.hjy.serviceimpl.ShoppingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/25
 **/
public class SelectAllByUserIdServlet extends HttpServlet {

    private ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int user_id = user.getId();
        List<ShoppingCart> shoppingCartList = null;
        shoppingCartList = shoppingCartService.selectAllByUserID(user_id);
        String jsonObject = JSON.toJSONString(shoppingCartList);
        JSONArray jsonArray = (JSONArray) JSONArray.parse(jsonObject);
        response.getWriter().write(jsonArray.toString());
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
