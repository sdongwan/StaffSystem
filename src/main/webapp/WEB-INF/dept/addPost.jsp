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
    String contextPath=request.getServletContext().getContextPath();
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>添加部门</title>
    <style type="text/css">
        .table td {
            text-align: center;
        }

        .position {
            float: left;
            position: absolute;
            margin-top: 35px;
            margin-left: 35px;
        }

        .container {
            position: absolute;
            margin-top: 15%;
            margin-left: 20%;
        }

        .btn {
            margin-top: 35px;
        }

        .errorMessage {
            color: red;
        }

    </style>
</head>
<body>
<div class="position"><span>当前位置：添加部门</span></div>


<div class="container">
    <form action="<%=contextPath%>/dept/addPost.jsp" method="post">
        <table class="table">
            <tr>

                <td colspan="2">

                    <s:textfield name="post.postName" label="部门名称">

                    </s:textfield>
                </td>
            </tr>

            <tr>
                <td>
                    部门介绍：
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
</div>

</body>
</html>
