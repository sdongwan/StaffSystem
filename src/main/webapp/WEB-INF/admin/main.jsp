<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <style type="text/css">
        .table td {
            border: solid 1px black;

            margin-top: 0px;
            margin-bottom: 0px;
            text-align: center;

        }
        .table{
            width: 80%;
            height: 80%;
            position: absolute;
            margin-top: 5%;
            margin-left: 10%;
        }

    </style>
</head>
<body>


<table class="table">
    <tr>
        <td colspan="2">欢迎进入网站管理中心</td>
    </tr>

    <tr>
        <td>
            当前时间：
        </td>
        <td>
            <%=new Date(System.currentTimeMillis())%>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            你的相关信息
        </td>
    </tr>

    <tr>
        <td>登录用户名：</td>
        <td>
            <%=request.getSession().getAttribute("adminUserName")%>
        </td>
    </tr>
    <tr>
        <td>真实姓名：</td>
        <td>
            <%=request.getSession().getAttribute("adminName")%>
        </td>
    </tr>
    <tr>
        <td>登录次数：</td>
        <td><%=request.getSession().getAttribute("loginCount")%>
        </td>
    </tr>
    <tr>
        <td>上线时间：</td>
        <td>
            <%=new Date(System.currentTimeMillis())%>
        </td>
    </tr>

    <tr>
        <td>IP地址：</td>
        <td><%=request.getLocalAddr()%>
        </td>
    </tr>

    <tr>
        <td>身份过期：</td>
        <td>
            <%=request.getSession().getMaxInactiveInterval()%>
        </td>
    </tr>

</table>

</body>
</html>
