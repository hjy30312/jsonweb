package com.hjy.servlet.user;

import com.hjy.model.Student;
import com.hjy.model.User;
import com.hjy.service.UserService;
import com.hjy.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author hjy
 * @create 2017/12/10
 **/
@WebServlet(name = "UserLoginServlet", urlPatterns = {"/User/LoginServlet"})
public class UserLoginServlet extends HttpServlet{

    private final UserService userService = new UserServiceImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();

            User user = userService.findUserByUsernamePassword(username,password);

            HttpSession session = request.getSession(true);
            if (user != null) {
                //找到用户
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/User/Index");
            } else {
                //没有找到用户，可能用户名或密码错误！
                session.setAttribute("message", "账号或密码错误!");
                response.sendRedirect(request.getContextPath() + "/User/Login");
            }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }




}
