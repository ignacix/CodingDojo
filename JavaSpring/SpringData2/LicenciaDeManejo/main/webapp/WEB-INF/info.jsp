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
<title>Languages</title>

<link rel="Stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/index.js"></script>

</head>
<body>
	<h1> <c:out value="${persona.firstName} ${persona.lastName}"></c:out> </h1>
	<table>
		<tr>
			<td>License Number</td>
			<td> <c:out value="${persona.license.getNumberComoString()}"></c:out> </td>
		</tr>
		<tr>
			<td>State: </td>
			<td> <c:out value="${persona.license.state}"></c:out> </td>
		</tr>
		<tr>
			<td>Expiration Date: </td>
			<td> <c:out value="${persona.license.getExpirationDateFormateado()}"></c:out> </td>
		</tr>
	</table>
</body>
</html>
