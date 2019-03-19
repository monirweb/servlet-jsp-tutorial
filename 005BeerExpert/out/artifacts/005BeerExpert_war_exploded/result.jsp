<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: monir
  Date: 3/19/2019
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
        <%
            List styles = (List)request.getAttribute("style");
            for (Object s:styles) {%>
               <br><%=(String) s%>
            <%}
        %>
</body>
</html>
