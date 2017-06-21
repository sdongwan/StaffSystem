<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
    String contextPath = request.getServletContext().getContextPath();
%>
<html>
<head>
    <base href=<%=basePath%>>
    <title>员工列表</title>
    <style type="text/css">
        .table td {
            border: solid 1px black;

            margin-top: 0px;
            margin-bottom: 0px;
            text-align: center;

        }

        table td img.photo {
            width: 80px;
            height: 80px;
            cursor: pointer;
            transition: all 0.6s;
        }

        table td img.photo:hover {
            transform: scale(1.4);
        }

        a:hover {
            color: red;
        }

        a {
            text-decoration: none;
            color: cornflowerblue;
        }

        .position {
            float: left;
            margin-top: 35px;
            margin-left: 35px;
        }

        /*.table {*/
        /*position: absolute;*/
        /*margin-top: 10%;*/
        /*margin-left: 15%;*/
        /*}*/

        .addStaff {
            float: right;
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


<div class="position"><span>当前界面：用户管理界面</span></div>

<div class="addStaff">
    <a href="<%=contextPath%>/user/addUser.jsp">
        添加新员工
    </a>
</div>
<table>
    <s:iterator value="userList" var="user">
        <tr>
            <td rowspan="5">
                <s:param value="#user.photo" name="photo"/>
                <img src="<%=contextPath%>/admin/upload.jsp?photo=<%=request.getAttribute("photo")%>" class="photo"/>
            </td>

            <td colspan="3">
                <s:param value="#user.userId" name="userId"/>
                <a href="<%=contextPath%>/user/showUser.jsp?userId=<%=request.getAttribute("userId")%>">修改</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="<%=contextPath%>/user/delUser.jsp?userId=<%=request.getAttribute("userId")%>"
                   onclick="if(confirm('确定要删除吗？')) return true; else return false;">删除</a>
            </td>
        </tr>

        <tr>
            <td>
                用户编号： <s:property value="#user.userId"/>
            </td>
            <td>
                登录账号： <s:property value="#user.username"/>
            </td>
            <td>
                登录密码： <s:property value="#user.userPass"/>
            </td>
        </tr>

        <tr>
            <td>
                用户姓名： <s:property value="#user.name"/>
            </td>
            <td>
                用户性别： <s:property value="#user.sex"/>
            </td>
            <td>
                出生日期： <s:date name="#user.birthday" format="yyyy-MM-dd"/>
            </td>
        </tr>

        <tr>
            <td>
                入职日期： <s:date name="#user.entryDate" format="yyyy-MM-dd"/>
            </td>
            <td colspan="2">
                所属部门： <s:property value="#user.post.postName"/>
            </td>
        </tr>
        <tr>

            <td colspan="3">
                个人介绍：<s:property value="#user.remark"/>
            </td>
        </tr>

    </s:iterator>
</table>

</body>
</html>
