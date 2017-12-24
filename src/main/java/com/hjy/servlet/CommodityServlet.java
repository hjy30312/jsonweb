package com.hjy.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hjy.model.Commodity;
import com.hjy.service.CommodityService;
import com.hjy.serviceimpl.CommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/24
 **/

@WebServlet(name = "CommodityServlet", urlPatterns = "/commodity.do")
public class CommodityServlet extends HttpServlet{


    private CommodityService commodityService = new CommodityServiceImpl();
    public static void main(String[] args) {
        CommodityService commodityService = new CommodityServiceImpl();
        List<Commodity> commodities = null;
        commodities = commodityService.findAllCommodity();
        String jsonObject = JSON.toJSONString(commodities);
        JSONArray jsonArray = (JSONArray) JSONArray.parse(jsonObject);
        System.out.println(jsonObject);
        System.out.println(jsonArray);

        //      System.out.println(object);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CommodityService commodityService = new CommodityServiceImpl();
        List<Commodity> commodities = null;
        commodities = commodityService.findAllCommodity();
        String jsonObject = JSON.toJSONString(commodities);
        JSONArray jsonArray = (JSONArray) JSONArray.parse(jsonObject);
        response.setCharacterEncoding("utf-8");

        response.getWriter().write(jsonArray.toString());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }


}
