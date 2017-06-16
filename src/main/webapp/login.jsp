<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page language="java" pageEncoding="utf-8" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String contextPath=request.getServletContext().getContextPath();
    System.out.println(contextPath);
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>后台登录</title>
    <style type="text/css">
        body {
            margin: 0px;
        }

        .container {
            width: 500px;
            height: 500px;
            position: absolute;
            left: 45%;
            top: 30%
        }

        .table td {
            margin-top: 0px;
            margin-bottom: 0px;
            text-align: center;
        }

        table td a.regist {
            text-decoration: none;
        }

        table td a.regist:hover {
            color: red;
        }

        .label {
            font-family: Verdana, Arial, Helvetica, sans-serif, 宋体;
            font-size: 12px;
        }

        .head_title {
            font-family: Verdana, Arial, Helvetica, sans-serif, 宋体;
            font-size: 20px;
            color: black;
        }
    </style>
</head>
<body>

<div class="container">
    <s:actionerror/>
    <form action="<%=contextPath%>/adminValide.jsp" method="post">
        <table class="table">

            <tr>
                <td colspan="2" class="head_title">
                    后台登录
                </td>
            </tr>
            <tr>
                <td>
                    <label for="admin.adminUserName" class="label">输入用户名</label>
                </td>
                <td>
                    <input type="text" name="admin.adminUserName" id="admin.adminUserName"/>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="admin.adminPwd" class="label">输入密码</label>
                </td>
                <td>
                    <input type="text" name="admin.adminPwd" id="admin.adminPwd"/>
                </td>
            </tr>


            <tr>
                <td>
                    <input type="submit" value="登录"/>
                </td>
                <td>
                    <a href="<%=contextPath%>/registAdmin.jsp" class="regist">注册</a>
                </td>
            </tr>

        </table>
    </form>

</div>

</body>
</html>
