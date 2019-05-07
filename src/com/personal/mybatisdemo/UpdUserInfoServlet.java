package com.personal.mybatisdemo;

import com.personal.dao.DAO;
import com.personal.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.Calendar;

@WebServlet(value = "/UpdUserInfoServlet")
public class UpdUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String UserName = req.getParameter("username");
        String MobilePhone = req.getParameter("mobilephone");
        String gender = req.getParameter("gender");
        String profession = req.getParameter("profession");
        Calendar cal = Calendar.getInstance();
        String unid = String.valueOf(cal.getTimeInMillis()) + URLEncoder.encode(UserName, "utf-8");
        UserInfo userInfo = null;
        Connection conn = null;
        String resultJson = "";
        try {
            String birthday = req.getParameter("birthday");
            userInfo = new UserInfo(unid, UserName, MobilePhone, gender, birthday, profession);
            DAO dao = new DAO();
            DBUtil dbUtil = new DBUtil();
            conn = dbUtil.getConn();
            resultJson = dao.UpdUserInfo(conn, userInfo);
            System.out.println(resultJson);
            PrintWriter pWriter = resp.getWriter();
            resp.setContentType("text/json;charset=UTF-8");
            pWriter.write(resultJson);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
