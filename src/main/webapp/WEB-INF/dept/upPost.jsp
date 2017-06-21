<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
    String contextPath = request.getServletContext().getContextPath();
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>修改部门信息</title>
    <style type="text/css">
        table {
            position: absolute;
            border: 1px solid #888888;
            border-collapse: collapse;
            font-family: Arial, Helvetica, sans-serif;
            width: 65%;
            margin-left: 150px;
            margin-top: 150px;

        }

        table td {
            text-align: center;
            background-color: #EFEFEF;
            border: 1px solid #AAAAAA;
            padding: 5px 15px 5px 5px;
        }

        .position {
            float: left;
            position: absolute;
            margin-top: 35px;
            margin-left: 35px;
        }

        .error {
            margin-left: 150px;
            margin-top: 100px;
            position: absolute;
        }

    </style>
</head>
<body>

<div class="position"><span>当前位置：修改部门信息</span></div>

<div class="error">
    <s:fielderror name="post.postName" cssStyle="color:red;"/>
</div>

<form action="<%=contextPath%>/dept/updatePost.jsp" method="post">
    <table class="table">
        <tr>
            <td>
                部门名称
            </td>
            <td>
                <%--<input type="text" value="<%=request.getAttribute("postName")%>" name="post.postName">--%>
                <%--<input type="text" value="${post.postName}" name="post.postName">--%>
                <%--<s:textfield name="post.postId" type="hidden" label="部门名称"/>--%>
                <%--<s:textfield name="post.postName"/>--%>

                <input type="hidden" name="post.postId" value="${post.postId}"/>
                <input type="text" name="post.postName" value="${post.postName}"/>
                <%--<s:property value="#post.postName"/>--%>

            </td>

        </tr>
        <tr>
            <td>
                部门介绍
            </td>
            <td>
                <%--<input type="text" name="post.postRemark" value="${post.postRemark}"/>--%>
                <%--<input type="text" value="<%=request.getAttribute("postRemark")%>" name="post.postName">--%>

                <%--<s:textfield name="post.postRemark" label="部门介绍"/>--%>
                <%--<s:property value="#post.postRemark"/>--%>

                <input type="text" name="post.postRemark" value="${post.postRemark}"/>

            </td>

        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="确定">
            </td>
        </tr>

    </table>

</form>

</body>
</html>
