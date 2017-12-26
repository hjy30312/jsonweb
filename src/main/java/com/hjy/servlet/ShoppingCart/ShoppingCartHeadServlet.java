package com.hjy.servlet.ShoppingCart;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hjy.servlet.Commodity.CommodityHeadServlet;
import com.hjy.util.JsonHeadUtil;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @author hjy
 * @create 2017/12/25
 **/

@WebServlet(name = "ShoppingCartHeadServlet", urlPatterns = "/ShoppingCartHead")
public class ShoppingCartHeadServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonHeadUtil.processRequest(response,"/shoppingCart.json");
    }

    public static void main(String[] args) throws IOException {
        InputStream in = CommodityHeadServlet.class.getResourceAsStream("/shoppingCart.json");
        String result = IOUtils.toString(in,"UTF-8");
        System.out.println(result);

        JSONObject object = JSON.parseObject(result);

        System.out.println(object);
        System.out.println(object.get("id"));

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
