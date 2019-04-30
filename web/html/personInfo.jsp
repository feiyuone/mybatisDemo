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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
    <form>
        <table>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>手机号：</td>
                <td><input type="text" name="mobilephone"></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>
                    <input type="radio" name="gender" value="0">男
                    <input type="radio" name="gender" value="1">女
                </td>
            </tr>
            <tr>
                <td>生日：</td>
                <td><input type="date" name="birthday"></td>
            </tr>
            <tr>
                <td>职业：</td>
                <td><input type="text" name="profession"></td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
