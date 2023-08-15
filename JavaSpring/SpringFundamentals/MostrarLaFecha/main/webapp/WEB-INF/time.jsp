<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!--  ESTO VA DENTRO DEL JSP  -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/styleTime.css">
<script type="text/javascript" src="js/index.js"></script>
<title>Time</title>
</head>
<body onload="alerta('time')">
	<h1> <c:out value="${time}"></c:out> </h1>
</body>
</html>