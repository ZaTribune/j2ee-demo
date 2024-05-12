<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javax.servlet.jsp.PageContext" %>

<html>
<head>
    <title>Title</title>
    <c:set var="name" value="Page Name" scope="page" />
</head>
<body>

<%
    String s1 = (String) pageContext.getAttribute("name", PageContext.PAGE_SCOPE);
    String s3 = (String) pageContext.getAttribute("name", PageContext.REQUEST_SCOPE);
    String s4 = (String) pageContext.getAttribute("name", PageContext.SESSION_SCOPE);
    String s2 = (String) pageContext.getAttribute("name", PageContext.APPLICATION_SCOPE);

    out.println("PAGE_SCOPE: " + s1);
    out.println("<br/>REQUEST_SCOPE: " + s3);
    out.println("<br/>SESSION_SCOPE: " + s4);
    out.println("<br/>APPLICATION_SCOPE: " + s2);

    out.println("<br/>APPLICATION_SCOPE 2: " + application.getInitParameter("vendor"));

%>

</body>
</html>
