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
import java.io.PrintWriter;

@WebServlet(name = "CommodityHeadServlet", urlPatterns = "/CommodityHead")
/**
 * @author: hjy
 * @description: 得到购物车的列表头信息
 */
public class CommodityHeadServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //读取配置文件
//        InputStream in = CommodityHeadServlet.class.getResourceAsStream("/commodity.json");
//        //利用apache.commons.io.IOUtils 将InputStream转换成String  JsonObject文本数据
//        String result = IOUtils.toString(in,"UTF-8");
//        //将JsonObject数据转换为Json
//        JSONObject object = JSON.parseObject(result);
//        response.setContentType(
//                "text/plain;charset=utf-8"
//        );
//        PrintWriter out = response.getWriter();
//        out.print(object);
//        out.close();
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




