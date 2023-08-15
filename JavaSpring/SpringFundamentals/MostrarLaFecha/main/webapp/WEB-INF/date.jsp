<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!--  ESTO VA DENTRO DEL JSP  -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/styleDate.css">
<script type="text/javascript" src="js/index.js"></script>
<title>Date</title>
</head>
<body onload="alerta('date')">
	<h1> <c:out value="${fecha}"></c:out> </h1>
</body>
</html>