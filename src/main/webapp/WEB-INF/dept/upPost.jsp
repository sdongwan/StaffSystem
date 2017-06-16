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
    String contextPath=request.getServletContext().getContextPath();
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>修改部门信息</title>
    <style type="text/css">
        .container {
            position: absolute;
            margin-top: 15%;
            margin-left: 20%;
        }

        .table td {
            text-align: center;
        }

        .position {
            float: left;
            position: absolute;
            margin-top: 35px;
            margin-left: 35px;
        }
    </style>
</head>
<body>

<div class="position"><span>当前位置：修改部门信息</span></div>

<div class="container">
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
                <td>
                    <s:actionerror cssStyle="color: red"/>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="确定">
                </td>
            </tr>

        </table>

    </form>
</div>
</body>
</html>
