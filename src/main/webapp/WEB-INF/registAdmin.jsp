<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/12
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%
    String contextPath=request.getServletContext().getContextPath();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>注册用户</title>
    <style type="text/css">
        .table td {
            border: solid 1px black;
            text-align: center;
        }

        .container {
            width: 500px;
            height: 500px;
            position: absolute;
            left: 45%;
            top: 30%
        }

    </style>
</head>
<body>
<s:actionerror/>
<div class="container">
    <form action="<%=contextPath%>/registAdmin.jsp" method="post">
        <table class="table">
            <tr>
                <td>
                    注册管理员
                </td>
            </tr>
            <tr>
                <td>
                    <label for="admin.adminName">管理员名字</label>
                    <input type="text" name="admin.adminName" id="admin.adminName">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="admin.adminUserName">管理员用户账号</label>
                    <input type="text" name="admin.adminUserName" id="admin.adminUserName">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="admin.adminPwd">管理员用户密码</label>
                    <input type="text" name="admin.adminPwd" id="admin.adminPwd">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="reset" value="重置">&nbsp;&nbsp;
                    <input type="submit" value="确定">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
