<%--
  Created by IntelliJ IDEA.
  User: Yangzy
  Date: 2019/4/17
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <link href="css/bootstrap.min.css">
    <link href="css/bootstrap-theme.min.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function openRegPage() {
            location.href = "RegUser.jsp";
        }
    </script>
</head>
<body>

<form action="LoginServlet" method="post" algin="center">
    <div class="form-group">
        <h3>登陆界面</h3>
        <table border="0">
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="Password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
                <td><input type="button" value="注册" onclick="openRegPage()"></td>
            </tr>
        </table>
    </div>
</form>

</body>
</html>
