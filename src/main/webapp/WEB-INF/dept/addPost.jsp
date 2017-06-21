<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 17:07
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
    <title>添加部门</title>
    <style type="text/css">

        .position {
            float: left;
            position: absolute;
            margin-top: 35px;
            margin-left: 35px;
        }

        .btn {
            margin-top: 35px;
        }

        .errorMessage {
            color: red;
        }

        table {
            position: absolute;
            border: 1px solid #888888;
            border-collapse: collapse;
            font-family: Arial, Helvetica, sans-serif;
            width: 45%;
            margin-left: 150px;
            margin-top: 150px;

        }

        table td {
            text-align: center;
            background-color: #EFEFEF;
            border: 1px solid #AAAAAA;
            padding: 5px 15px 5px 5px;
        }

        .error {
            margin-left: 150px;
            margin-top: 70px;
            position: absolute;
        }


    </style>
</head>
<body>
<div class="position"><span>当前位置：添加部门</span></div>
<div class="error">
    <s:fielderror name="post.postName"/>
    <%--<s:fielderror name="post.postRemark"/>--%>
</div>
<form action="<%=contextPath%>/dept/addPost.jsp" method="post">

    <table class="table">
        <tr>
            <td>
                部门名称
            </td>
            <td>

                <%--<s:textfield name="post.postName" label="部门名称">--%>

                <%--</s:textfield>--%>

                <input type="text" name="post.postName">
            </td>
        </tr>

        <tr>
            <td>
                部门介绍
            </td>
            <td>
                <textarea name="post.postRemark">

            </textarea>

            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="确定" class="btn">
            </td>
        </tr>

    </table>
</form>


</body>
</html>
