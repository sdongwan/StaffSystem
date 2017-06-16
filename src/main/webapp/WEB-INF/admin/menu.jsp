<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 18:53
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

    <base href="<%=basePath%>"/>
    <script type="text/javascript">
        function expand(e1) {
            childObj = document.getElementById("child" + e1);
            if (childObj.style.display == 'none') {
                childObj.style.display = 'block';
            } else {
                childObj.style.display = 'none';
            }
            return;
        }

    </script>

    <style type="text/css">
        body {
            margin: 0px;
        }

        .column1, .column2, .column3 {
            margin-top: 25px;
            margin-left: 15px;
        }

        .column1 a, .column2 a, .column3 a {
            text-decoration: none;
            color: black;

        }

        #child1, #child2, #child3 {

            margin-left: 35px;
            margin-top: 5px;
            margin-bottom: 5px;

        }

        .container {
            float: left;
            height: 100%;
            width: 150px;
            display: block;
            text-align: center;
            background-color: #ffffff;
        }

        #child1 a, #child2 a, #child3 a {
            color: #416899;
            text-decoration: none;
            font-family: Verdana, Arial, Helvetica, sans-serif, 宋体;
            font-size: 12px;

        }

        #child1 td, #child2 td, #child3 td {

            cursor: pointer;
            transition: all 0.3s;
        }

        #child1 td:hover, #child2 td:hover, #child3 td:hover {
            transform: scale(1.4);
        }

        a:hover {
            color: #000;
        }

        .icon {
            width: 15px;
            height: 15px;
            margin-right: 5px;
        }

        .tableContainer {
            padding: auto;
        }
    </style>
</head>
<body>

<div class="container">

    <div class="tableContainer">


        <table class="column1">
            <tr>
                <td><img src="<%=contextPath%>/image/ico1.gif" class="icon"><a href="javascript:void(0)"
                                                                               onclick="expand(1)">部门管理</a>
                </td>
            </tr>
        </table>

        <table id="child1">
            <tr>
                <td><a href="<%=contextPath%>/dept/showDepts.jsp" target="main">管理部门</a></td>
            </tr>
            <tr>
                <td><a href="<%=contextPath%>/dept/addDept.jsp" target="main">添加部门</a></td>
            </tr>
        </table>

        <table class="column2">
            <tr>
                <td><img src="<%=contextPath%>/image/ico1.gif" class="icon"><a href="javascript:void(0)"
                                                                               onclick="expand(2)">员工管理</a>
                </td>
            </tr>
        </table>

        <table id="child2">
            <tr>
                <td><a href="<%=contextPath%>/user/showUsers.jsp" target="main">管理员工</a></td>
            </tr>
            <tr>
                <td><a href="<%=contextPath%>/user/addUserInfo.jsp" target="main">添加员工</a></td>
            </tr>
        </table>

        <table class="column3">
            <tr>
                <td><img src="<%=contextPath%>/image/ico1.gif" class="icon"><a href="javascript:void(0)"
                                                                               onclick="expand(3)">个人管理</a>
                </td>
            </tr>
        </table>

        <table id="child3">
            <tr>
                <td><a href="<%=contextPath%>/admin/updateAdmin.jsp" target="main">修改口令</a></td>
            </tr>

            <tr>
                <td><a href="<%=contextPath%>/admin/toBackAdmin.jsp" target="main">返回首页</a></td>
            </tr>

            <tr>
                <td><a href="<%=contextPath%>/admin/logout.jsp" target="_top"
                       onclick="if(confirm('确定要退出系统吗？')) return true;else  return false;">退出系统</a>
                </td>
            </tr>

        </table>
    </div>
</div>
</body>
</html>
