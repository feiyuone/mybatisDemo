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
</head>
<body>
    <div align="center">
        <form action="RegUserServlet" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="userName"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="Password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right"><input type="submit" value="确定"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
