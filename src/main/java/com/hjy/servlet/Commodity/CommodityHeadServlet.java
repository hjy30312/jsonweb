package com.hjy.servlet.Commodity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hjy.util.JsonHeadUtil;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;



@WebServlet(name = "CommodityHeadServlet", urlPatterns = "/commodityHead")
public class CommodityHeadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonHeadUtil.processRequest(response,"/commodity.json");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    /**
     * 测试取出的json
     * @param args
     */
    public static void main(String[] args) throws IOException {
        InputStream in = CommodityHeadServlet.class.getResourceAsStream("/commodity.json");
        String result = IOUtils.toString(in,"UTF-8");
        System.out.println(result);

        JSONObject object = JSON.parseObject(result);

        System.out.println(object);
        System.out.println(object.get("id"));

    }
}




