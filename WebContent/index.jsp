<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Convert Number to String Representation</title>
</head>
<jsp:directive.include file="header.jsp"/>

<body>
<jsp:directive.include file="nav.jsp" />
<div class="page-header">
<h3>Number to String Representation</h3>
</div>

<form class="navbar-form navbar-left num-converter" role="search" action="Converter" method="POST">
  <div class="form-group">
    <input type="text" class="form-control" id="number" name="number" placeholder="Number to convert">
  </div>
  <button type="submit" class="btn btn-default">Convert</button>
</form>


</body>
</html>