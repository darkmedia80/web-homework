<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: G
  Date: 2024/10/22
  Time: 下午4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2></h2>
<%
    Map<String,Object> sessionMap = new HashMap<String, Object>("sessionMap");
    response.setIntHeader("Refresh", 5);
%>>
<ul>
    <%
        for (Map.Entry<String,Object> entry : sessionMap.entrySet()) {


    %>
    <li>
        <%=entry.getValue()%>
    </li>
    <%
        }
    %>
</ul>
</body>
</html>
