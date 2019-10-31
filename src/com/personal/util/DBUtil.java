package com.personal.util;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
    private String dbUrl = "jdbc:mysql://192.168.1.11:3306/mybatisdemo?useUnicode=true&characterEncoding=utf-8";
    private String dbUserName = "root";
    private String dbPassword = "986692";
    String driver = "com.mysql.cj.jdbc.Driver";

    public Connection getConn() throws Exception{
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            conn.setAutoCommit(true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConn(Connection conn) throws Exception{
        if (conn!=null)
            conn.close();
    }

    public static void main(String args[]) throws Exception{
        DBUtil dbUtil = new DBUtil();
        try{
            dbUtil.getConn();
            System.out.println("数据库连接成功！");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
