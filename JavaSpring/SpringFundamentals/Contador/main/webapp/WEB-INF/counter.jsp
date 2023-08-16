<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!--  ESTO VA DENTRO DEL JSP  -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current visit count</title>
<!--  BOOTSTRAP LINKERS-->
<link rel="Stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>You have visited <a href="/your_server">http://your_server</a> <c:out value="${contador }"></c:out> </h1>
	<h2> <a href="/your_server"> Test another visit?</a> </h2>
	<a href="/your_server/reset"><button>Reset</button></a> 
</body>
</html>