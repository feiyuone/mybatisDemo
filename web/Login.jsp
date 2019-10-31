<%--
  Created by IntelliJ IDEA.
  User: Yangzy
  Date: 2019/4/17
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登陆</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/maskdiv.css">
    <script type="text/javascript">
        function openRegPage() {
            location.href = "RegUser.jsp";
        }
    </script>
</head>
<body>

<form action="LoginServlet" method="get" class="maskDiv">
    <div class="page-header"> 顶部</div>
    <div class="left">左边</div>
    <div class="right maskDivShow">
        <div class="divContent form-group">
            <h3>登陆界面</h3>
            <table border="0">
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" class="form-control" name="userName"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" class="form-control" name="Password"></td>
                </tr>
                <tr>
                    <td><input class="btn btn-default" type="submit" value="登录"></td>
                    <td><input class="btn btn-warning" type="button" value="注册" onclick="openRegPage()"></td>
                </tr>
            </table>
        </div>
    </div>

</form>

</body>
</html>
