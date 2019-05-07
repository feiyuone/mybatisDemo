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
    <script type="text/javascript">
        function updperinfo() {
            var username = $("#username").val();
            var mobilephone = document.getElementById("mobilephone").value;
            var gender = $("input:radio[name='gender']:checked").val();
            var birthday = $("#birthday").val();
            var prof = $("#profession").val();
            $.ajax({
                type: "post",
                url: "../UpdUserInfoServlet",
                data: {
                    username: username,
                    mobilephone: mobilephone,
                    gender: gender,
                    birthday: birthday,
                    profession: prof
                },
                success: function (rtndata) {
                    console.log(rtndata);
                    var jsonobj = eval(rtndata);
                    alert(jsonobj.tips);
                },
                error: function () {
                    alert("更新失败！");
                }
            });
        }
    </script>
</head>
<body>
<div align="center">
    <h3>个人信息</h3>
    <%--    <form action="../UpdUserInfoServlet" method="post">--%>
    <form>
        <table class="table table-striped" style="width:40%;">
            <tr class="form-group">
                <td>姓名：</td>
                <td><input class="form-control" type="text" name="username" id="username"></td>
            </tr>
            <tr class="form-group">
                <td>手机号：</td>
                <td><input class="form-control" type="text" name="mobilephone" id="mobilephone"></td>
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
                <td><input class="form-control" type="date" name="birthday" id="birthday"></td>
            </tr>
            <tr class="form-group">
                <td>职业：</td>
                <td><input class="form-control" type="text" name="profession" id="profession"></td>
            </tr>

        </table>
        <input class="btn btn-default" type="button" value="确定" onclick="updperinfo()">
        <input class="btn btn-warning" type="button" value="取消">
    </form>

</div>
</body>
</html>
