<%--
  Created by IntelliJ IDEA.
  User: Yangzy
  Date: 2019/4/21
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Information</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
    <h3>个人信息</h3>
    <form action="UpdUserInfoServlet" method="post">
        <table class="table table-striped" style="width:40%;">
            <tr class="form-group">
                <td>姓名：</td>
                <td><input class="form-control" type="text" name="username"></td>
            </tr>
            <tr class="form-group">
                <td>手机号：</td>
                <td><input class="form-control" type="text" name="mobilephone"></td>
            </tr>
            <tr class="form-group">
                <td>性别：</td>
                <td>
                    <label class="input-group-addon"><input type="radio" name="gender" value="0" checked>男</label>
                    <label class="input-group-addon"><input type="radio" name="gender" value="1">女</label>
                </td>
            </tr>
            <tr class="form-group">
                <td>生日：</td>
                <td><input class="form-control" type="date" name="birthday"></td>
            </tr>
            <tr class="form-group">
                <td>职业：</td>
                <td><input class="form-control" type="text" name="profession"></td>
            </tr>

        </table>
    </form>
    <input class="btn btn-default" type="submit" value="确定">
    <input class="btn btn-warning" type="button" value="取消">
</div>
</body>
</html>
