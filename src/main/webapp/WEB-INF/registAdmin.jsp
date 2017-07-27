<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="a" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/12
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%
    String contextPath = request.getServletContext().getContextPath();
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

        body {
            margin: 0px;

        }

        #footer {
            height: 40px;
            line-height: 40px;
            position: fixed;
            bottom: 0;
            width: 100%;
            text-align: center;
            background: #333;
            color: #fff;
            font-family: Arial;
            font-size: 12px;
            letter-spacing: 1px;
        }

        .header_left {
            float: left;
            width: 168px;
            height: 80px;
            align-content: center;
            background: url("<%=contextPath%>/image/bg2.gif");
        }

        .img_left {
            width: 94px;
            height: 80px;
            cursor: pointer;
            transition: all 0.6s;
        }

        .img_left:hover {
            transform: scale(1.4);
        }

        .header_right {
            width: 100%;
            height: 80px;
            background: url("<%=contextPath%>/image/bg2.gif");
        }

        .container {
            height: 80px;
            width: auto;
            float: right;

        }

        a {
            text-decoration: none;
        }

        a:hover {
            color: red;
        }

        .lougout {
            margin-top: 20px;
            line-height: 15px;
            float: right;
            margin-left: 25px;
            margin-right: 25px;
        }

        html {
            width: 100%;
            height: 100%;
            overflow: hidden;
            font-style: sans-serif;
        }

        body {
            width: 100%;
            height: 100%;
            font-family: 'Open Sans', sans-serif;
            margin: 0;
        }

        #login {
            position: absolute;
            top: 50%;
            left: 50%;
            margin: -150px 0 0 -150px;
            width: 300px;
            height: 300px;
        }

        #login h1 {
            color: #000;
            text-shadow: 0 0 10px;
            letter-spacing: 1px;
            text-align: center;
        }

        h1 {
            font-size: 2em;
            margin: 0.67em 0;
        }

        input {
            width: 278px;
            height: 18px;
            margin-bottom: 10px;
            outline: none;
            padding: 10px;
            font-size: 13px;
            color: #000;
            /*text-shadow: 1px 1px 1px;*/
            border-top: 1px solid #312E3D;
            border-left: 1px solid #312E3D;
            border-right: 1px solid #312E3D;
            border-bottom: 1px solid #56536A;
            border-radius: 4px;
            background-color: #fff;
        }

        .but {
            float: left;
            width: 120px;
            min-height: 20px;
            display: block;
            background-color: #4a77d4;
            border: 1px solid #3762bc;
            color: #fff;
            padding: 9px 14px;
            font-size: 15px;
            line-height: normal;
            border-radius: 5px;
            margin: 5px;
        }


    </style>
</head>
<body>

<table>
    <tr>
        <td class="header_left">
            <img src="<%=contextPath%>/image/lg.gif" class="img_left">
        </td>
        <td class="header_right">
            <div class="container">
                <div class="lougout">

                </div>
            </div>
        </td>
    </tr>
</table>


<div id="login">
    <h1>员工信息管理系统
        注册用户</h1>
    <form method="post" action="<%=contextPath%>/registAdmin.jsp">
        <input type="text" required="required" placeholder="管理员名字" name="admin.adminName"></input>
        <input type="password" required="required" placeholder="管理员用户账号" name="admin.adminUserName"></input>
        <input type="password" required="required" placeholder="管理员用户密码" name="admin.adminPwd"></input>
        <button class="but" type="submit">注册</button>
        <button class="but" type="reset">重置</button>

    </form>
    <p><a:actionerror/></p>
</div>


<div id="footer">CopyRight@copy2017</div>
</body>
</html>
