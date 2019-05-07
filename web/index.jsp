<%--
  Created by IntelliJ IDEA.
  User: Yangzy
  Date: 2019/4/15
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,com.personal.mybatisdemo.User" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            padding-top: 70px;
        }
    </style>
    <script type="text/javascript">
        function showunid() {
            var unid = document.getElementById("unid").value;
            alert(unid);
        }
    </script>
</head>
<body>
<%
    ArrayList userList = (ArrayList) request.getAttribute("userlist");
    User user = (User) userList.get(0);
%>
<div style="display: none">
    <%=userList.size()%>
    <input type="password" id="unid" value="<%=user.getUnid() %>">
</div>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <ul class="nav nav-pills">
            <li role="presentation" class="active"><a href="#">Home</a></li>
            <li role="presentation"><a href="html/personInfo.jsp">Personal</a></li>
            <li role="presentation"><a href="#">Settings</a></li>
        </ul>
    </div>
</nav>
<p>欢迎您，这里是首页！</p>
<input type="button" value="Click here" id="test" onclick="showunid()">
</body>
</html>
