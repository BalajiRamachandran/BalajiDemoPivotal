<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Converted Result</title>
</head>

<jsp:directive.include file="header.jsp"/>

<body>
<jsp:directive.include file="nav.jsp"/>
<div class="page-header">
<h3>Result</h3>
</div>
<p><%
	if (session.getAttribute("result") == null ) {
		response.sendRedirect("index.jsp");
	}
	out.println ( session.getAttribute("result"));
	session.removeAttribute("result");
%></p>

</body>
</html>




