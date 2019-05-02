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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/UpdUserInfoServlet")
public class UpdUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println("===================");
        String UserName = req.getParameter("username");
        String MobilePhone = req.getParameter("mobilephone");
        String gender = req.getParameter("gender");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String profession = req.getParameter("profession");
        Calendar cal = Calendar.getInstance();
        String unid = String.valueOf(cal.getTimeInMillis()) + URLEncoder.encode(UserName, "utf-8");
        UserInfo userInfo = null;
        Connection conn = null;
        String resultJson = "";
        try {
            Date birthday = sdf.parse(req.getParameter("birthday"));
            userInfo = new UserInfo(unid, UserName, MobilePhone, gender, birthday, profession);
            DAO dao = new DAO();
            DBUtil dbUtil = new DBUtil();
            conn = dbUtil.getConn();
            resultJson = dao.UpdUserInfo(conn, userInfo);
            PrintWriter pWriter = resp.getWriter();
            pWriter.print(resultJson);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
