<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
    String contextPath = request.getServletContext().getContextPath();
%>
<html>
<base href="<%=basePath%>"/>


<frameset border=0 frameSpacing=0 rows="60, *,40" frameBorder=0>
    <frame name=header src="<%=contextPath%>/admin/header.jsp" frameBorder=0 noResize scrolling=no>
    <frameset cols="230, *">
        <frame name=menu src="<%=contextPath%>/admin/menu.jsp" frameBorder=0 noResize>
        <frame name=main src="<%=contextPath%>/admin/main.jsp" frameBorder=0 noResize scrolling=yes>
    </frameset>
    <frame name="footer" src="<%=contextPath%>/admin/footer.jsp" frameborder="0" scrolling="no">
</frameset>
<noframes>
</noframes>

</html>
