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

@WebServlet("/RegUserServlet")
public class RegUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("userName");
        System.out.println("注册用户："+userName);
        String Password = req.getParameter("Password");
        DBUtil dbUtil = new DBUtil();
        User user = new User(userName,Password);
        DAO dao = new DAO();
        boolean regSucess = false;
        try{
            Connection conn = dbUtil.getConn();
            regSucess = dao.RegUser(conn,user);
            if (regSucess)
                resp.sendRedirect("Login.jsp");
            else
                resp.sendRedirect("RegUser.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
