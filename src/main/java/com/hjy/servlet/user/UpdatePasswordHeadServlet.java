package com.hjy.servlet.user;

import com.hjy.util.JsonHeadUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hjy
 * @create 2017/12/26
 **/
@WebServlet(name = "UpdatePasswordHeadServlet", urlPatterns = "/User/UpdatePasswordHeadServlet")
public class UpdatePasswordHeadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonHeadUtil.processRequest(response,"/updatePassword.json");
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
