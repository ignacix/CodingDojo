<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> <c:out value="${lenguaje.name}"></c:out> </title>

<link rel="Stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/index.js"></script>

</head>
<body>	
		<div class="card p-3">
			<a href="/lenguaje" >Dashboard</a>
			
			<h2> Nombre: <c:out value="${lenguaje.name}"></c:out> </h2>
			<h2> Creador: <c:out value="${lenguaje.creator}"></c:out> </h2>
			<h2> Version: <c:out value="${lenguaje.version}"></c:out> </h2>
			
			<a href="/lenguaje/${lenguaje.id}/edit">Edit</a>
			<form action="/lenguaje/${lenguaje.id}" method="post">
		        <input type="hidden" name="_method" value="delete">
        		<input type="submit" value="Delete">          	
		    </form>
		</div>
		
</body>
</html>