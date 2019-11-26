<%--
  Created by IntelliJ IDEA.
  User: Yangzy
  Date: 2019/11/25
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.personal.mybatisdemo.User" %>
<%@ page import="com.personal.mybatisdemo.UserInfo" %>
<%@ page import="com.personal.util.DBUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.personal.dao.DAO" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Personal Info</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
<%
    DBUtil dbUtil = new DBUtil();
    Connection conn = dbUtil.getConn();
    List<User> userObject = (List<User>) request.getSession().getAttribute("userlist");
    DAO dao = new DAO();
    UserInfo userInfo = dao.getUserInfo(conn, userObject.get(0).getUnid());
%>

<div align="center">
    <h3>个人信息</h3>
    <form>
        <table class="table table-striped" style="width:40%;">
            <tr class="form-group">
                <td>姓名：</td>
                <td><input class="form-control" type="text" name="username" id="username" readonly="readonly"
                           value="<%= userInfo.getUserName() %>"></td>
            </tr>
            <tr class="form-group">
                <td>手机号：</td>
                <td><input class="form-control" type="text" name="mobilephone" id="mobilephone" readonly="readonly"
                           value="<%=userInfo.getMobilephone()%>"></td>
            </tr>
            <tr class="form-group">
                <td>性别：</td>
                <td>
                    <input class="form-control" readonly="readonly" type="text" name="gender"
                           value="<%=userInfo.getGender().equals("1")?"女":"男"%>">
                </td>
            </tr>
            <tr class="form-group">
                <td>生日：</td>
                <td><input class="form-control" type="text" name="birthday" id="birthday" readonly="readonly"
                           value="<%=userInfo.getBirthday().substring(0,10)%>"></td>
            </tr>
            <tr class="form-group">
                <td>职业：</td>
                <td><input class="form-control" type="text" name="profession" id="profession" readonly="readonly"
                           value="<%=userInfo.getProfession()%>"></td>
            </tr>

        </table>
        <input class="btn btn-warning" type="button" value="取消">
    </form>

</div>
</body>
</html>
