<%@ taglib prefix="c" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 17:17
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
    <title>部门管理</title>
    <style type="text/css">
        /*.table td {*/
        /*!*border: solid 1px black;*!*/
        /*text-align: center;*/
        /*}*/

        /*.table {*/
        /*width: 50%;*/
        /*height: 50%;*/
        /*}*/

        a:hover {
            color: red;
        }

        a {
            text-decoration: none;
            color: cornflowerblue;
        }

        .position {
            float: left;
            position: absolute;
            margin-top: 35px;
            margin-left: 35px;
        }

        /*.table {*/
        /*position: absolute;*/
        /*margin-top: 10%;*/
        /*margin-left: 15%;*/
        /*}*/

        .right_post {
            float: right;
            /*position: absolute;*/
            margin-top: 35px;
            margin-right: 35px;
        }

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


    </style>
</head>
<body>

<div class="position"><span>当前位置：部门管理</span></div>
<div class="right_post">
    <a href="<%=contextPath%>/dept/addPost.jsp">添加部门</a>
</div>


<table class="table">
    <tr>
        <td>部门编号</td>
        <td>部门名称</td>
        <td>部门人数</td>
        <td>部门介绍</td>
        <td>操作</td>
    </tr>

    <c:iterator value="posts" var="post">
        <tr>
            <td><c:property value="#post.postId"/></td>
            <td><c:property value="#post.postName"/></td>
            <td><c:property value="#post.postNum"/></td>
            <td><c:property value="#post.postRemark"/></td>
            <td>
                <s:param name="postId" value="#post.postId"/>
                <a href="<%=contextPath%>/dept/showPost.jsp?postId=<%=request.getAttribute("postId")%>">修改</a>
                <a href="<%=contextPath%>/dept/delPost.jsp?postId=<%=request.getAttribute("postId")%>"
                   onclick="if(confirm('你确定要删除这个部门吗？')) return true; else return false;">删除</a>
            </td>
        </tr>

    </c:iterator>

</table>

</body>
</html>
