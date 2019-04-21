<%--
  Created by IntelliJ IDEA.
  User: Yangzy
  Date: 2019/4/18
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
    <div align="center">
        <form action="RegUserServlet" method="post">
            <table class="form-group">
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="userName" class="form-control" placeholder="account"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="Password" class="form-control" placeholder="Password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right"><input type="submit" value="确定" class="btn-primary"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
