<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
    String contextPath = request.getServletContext().getContextPath();
%>
<html>
<head>
    <base href="<%=basePath%>">
    <style type="text/css">
        body {
            margin: 0px;

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

        .user {
            margin-top: 20px;
            line-height: 15px;
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
                    <a href="<%=contextPath%>/admin/logout.jsp"
                       onclick="if(confirm('确定要退出吗？')) return true; else return false;"
                       target="_top">退出系统</a>
                </div>

                <span class="user">
                    当前用户:<%=request.getSession().getAttribute("adminName")%>
                </span>

            </div>
        </td>
    </tr>
</table>


</body>
</html>
