package com.hjy.servlet.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hjy.model.Commodity;
import com.hjy.model.Order;
import com.hjy.model.User;
import com.hjy.service.CommodityService;
import com.hjy.service.OrderService;
import com.hjy.serviceimpl.CommodityServiceImpl;
import com.hjy.serviceimpl.OrderServiceImpl;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/27
 **/

@WebServlet(name = "OrderContentServlet", urlPatterns = "/User/OrderList")
public class OrderContentServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OrderService orderService = new OrderServiceImpl();
        List<Order> orderList = null;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getId();

        orderList = orderService.selectAllById(id);
        String jsonObject = JSON.toJSONString(orderList);

        JSONArray jsonArray = (JSONArray) JSONArray.parse(jsonObject);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonArray.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }



    public static void main(String[] args) {

    }
}
