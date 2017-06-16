<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/12
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%
    String contextPath=request.getServletContext().getContextPath();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改口令</title>
    <style type="text/css">
        .table td {
            border: solid 1px black;
            margin-top: 0px;
            margin-bottom: 0px;
            text-align: center;
        }

        .position {
            float: left;
            margin-top: 35px;
            margin-left: 35px;
        }

        .table {
            position: absolute;
            margin-top: 10%;
            margin-left: 15%;
        }
    </style>
</head>
<body>
<div class="position"><span>当前位置：修改口令</span></div>

<form action="<%=contextPath%>/admin/updateAdmin.jsp" method="post" target="_top">
    <table class="table">
        <tr>
            <td>
                <label for="admin.adminName">管理员名字</label>
                <input type="text" name="admin.adminName" id="admin.adminName" value="${admin.adminName}">
            </td>
        </tr>

        <tr>
            <td>
                <label for="admin.adminUserName">管理员用户账号</label>
                <input type="text" name="admin.adminUserName" value="${admin.adminUserName}" id="admin.adminUserName">
            </td>
        </tr>

        <tr>
            <td>
                <label for="admin.adminPwd">管理员用户密码</label>
                <input type="text" name="admin.adminPwd" id="admin.adminPwd" value="${admin.adminPwd}">
            </td>
        </tr>


        <tr>
            <td>
                <input type="reset" value="重置">&nbsp;&nbsp;&nbsp;
                <input type="submit" value="确定">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
