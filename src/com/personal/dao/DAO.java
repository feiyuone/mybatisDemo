package com.personal.dao;

import com.personal.mybatisdemo.User;
import com.personal.mybatisdemo.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

    public User Login(Connection connection, User user) throws Exception {
        User checkUser = null;
        String sql = "Select * from t_user where userName = ? and Password = ?";
        try {
            PreparedStatement pstate = connection.prepareStatement(sql);
            pstate.setString(1, user.getUserName());
            pstate.setString(2, user.getPassword());
            ResultSet rs = pstate.executeQuery();
            if (rs.next()) {
                checkUser = new User();
                checkUser.setUserName(rs.getString("userName"));
                checkUser.setPassword(rs.getString("Password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkUser;
    }

    public boolean RegUser(Connection connection, User user) throws Exception {
        boolean RegSucess = false;
        String sql = "INSERT into t_user(userName,Password) values(?,?)";
        try {
            PreparedStatement pstate = connection.prepareStatement(sql);
            pstate.setString(1, user.getUserName());
            pstate.setString(2, user.getPassword());
            if (pstate.executeUpdate() > 0) {
                RegSucess = true;
                System.out.println("注册成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RegSucess;
    }

    public String UpdUserInfo(Connection conn, UserInfo userInfo) {
        String rtnJsonStr = "";

        return rtnJsonStr;
    }
}
