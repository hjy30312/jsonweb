package com.hjy.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
        //读取配置文件
        InputStream in = ProductListHeadServlet.class.getResourceAsStream("/shoppingCart.json");
        //利用apache.commons.io.IOUtils 将InputStream转换成String  JsonObject文本数据
        String result = IOUtils.toString(in,"UTF-8");
        //将JsonObject数据转换为Json
        JSONObject object = JSON.parseObject(result);
        response.setContentType(
                "text/plain;charset=utf-8"
        );
        PrintWriter out = response.getWriter();
        out.print(object);
        out.close();
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
