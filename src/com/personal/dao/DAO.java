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
                checkUser.setUnid(rs.getString("unid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkUser;
    }

    public boolean RegUser(Connection connection, User user) throws Exception {
        boolean RegSucess = false;
        String sql = "INSERT into t_user(userName,Password,unid) values(?,?,?)";
        try {
            PreparedStatement pstate = connection.prepareStatement(sql);
            pstate.setString(1, user.getUserName());
            pstate.setString(2, user.getPassword());
            pstate.setString(3, user.getUnid());
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
        String sqlQuery = "Select * from t_userinfo where username = ?";
        String sqlInsert = "Insert into t_userinfo(unid,username,mobilephone,gender,birthday,profession) values(?,?,?,?,?,?)";
        String sqlUpdate = "Update t_userinfo Set username=? , mobilephone=? , gender=? , birthday=date_format(?,'%Y-%m-%d') , profession=?";
        try {
            PreparedStatement pprstate = conn.prepareStatement(sqlQuery);
            pprstate.setString(1, userInfo.getUserName());
            ResultSet rs = pprstate.executeQuery();
            if (rs.next()) {
                PreparedStatement pprstateUpd = conn.prepareStatement(sqlUpdate);
                pprstateUpd.setString(1, userInfo.getUserName());
                pprstateUpd.setString(2, userInfo.getMobilephone());
                pprstateUpd.setString(3, userInfo.getGender());
                pprstateUpd.setString(4, userInfo.getBirthday());
                pprstateUpd.setString(5, userInfo.getProfession());
                if (pprstateUpd.executeUpdate() > 0) rtnJsonStr = "{\"tips\":\"个人信息修改成功！\"}";
                else rtnJsonStr = "{\"tips\":\"个人信息修改失败！\"}";
            } else {
                PreparedStatement pprstateInsert = conn.prepareStatement(sqlInsert);
                pprstateInsert.setString(1, userInfo.getUnid());
                pprstateInsert.setString(2, userInfo.getUserName());
                pprstateInsert.setString(3, userInfo.getMobilephone());
                pprstateInsert.setString(4, userInfo.getGender());
                pprstateInsert.setString(5, userInfo.getBirthday());
                pprstateInsert.setString(6, userInfo.getProfession());
                if (pprstateInsert.executeUpdate() > 0) rtnJsonStr = "{\"tips\":\"个人信息保存成功！\"}";
                else {
                    System.out.println("更新数据库数据失败，请检查数据库连接！");
                    rtnJsonStr = "{\"tips\":\"个人信息保存失败！\"}";
                }
                //rtnJsonStr = URLEncoder.encode(rtnJsonStr,"utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtnJsonStr;
    }

    public UserInfo getUserInfo(Connection connection, String UserName) {
        UserInfo userInfo = new UserInfo();
        String querySql = "Select * from t_userinfo where unid=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setString(1, UserName);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                userInfo.setUserName(rs.getString("username"));
                userInfo.setMobilephone(rs.getString("mobilephone"));
                userInfo.setGender(rs.getString("gender"));
                userInfo.setProfession(rs.getString("profession"));
                userInfo.setBirthday(rs.getString("birthday"));
            } else {
                System.out.println("错误，用户尚未完善个人信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    public String getTableRowCount(Connection conn, String tableName) {
        String count = "";
        String queryStr = "Select count(*) from ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(queryStr);
            preparedStatement.setString(1, tableName);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                count = rs.getString("count(*)");
            } else {
                System.out.println("该表中尚无数据");
                count = "0";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
