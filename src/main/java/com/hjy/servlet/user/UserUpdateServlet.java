package com.hjy.servlet.user;

import com.hjy.model.User;
import com.hjy.service.ShoppingCartService;
import com.hjy.service.UserService;
import com.hjy.serviceimpl.ShoppingCartServiceImpl;
import com.hjy.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author hjy
 * @create 2017/12/26
 **/
public class UserUpdateServlet extends HttpServlet {


    private UserService userService = new UserServiceImpl();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int user_id = user.getId();
        userService.updatePassword(user_id,password);
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
