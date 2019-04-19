package com.personal.mybatisdemo;

import com.personal.dao.DAO;
import com.personal.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("userName");
        String Password = req.getParameter("Password");
        User user = new User();
        User checkUser = new User();
        user.setUserName(userName);
        user.setPassword(Password);
        DBUtil dbUtil = new DBUtil();
        DAO dao = new DAO();
        try {
            Connection conn = dbUtil.getConn();
            checkUser = dao.Login(conn, user);
            if (checkUser != null) {
                resp.sendRedirect("index.jsp");
            } else {
                System.out.println("登录失败，用户："+user.getUserName());
                resp.sendRedirect("RegUser.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
