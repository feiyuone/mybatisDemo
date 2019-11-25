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

@WebServlet(value = "/GetUserInfoServlet")
public class GetUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        User UserObject = new User();
        UserInfo userInfo = new UserInfo();
        String UserName = "";
        String unid = "";
        try {
            UserObject = (User) req.getAttribute("userlist");
            UserName = UserObject.getUserName();
            unid = UserObject.getUnid();
            DBUtil dbUtil = new DBUtil();
            Connection connection = dbUtil.getConn();
            DAO dao = new DAO();
            userInfo = dao.getUserInfo(connection, UserName);
            req.setAttribute("userinfo", userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
