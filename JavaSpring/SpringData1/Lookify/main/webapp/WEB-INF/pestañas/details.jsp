
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
<title>Details</title>

<link rel="Stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/index.js"></script>

</head>
<body>

	<a href="/dashboard">Dashboard</a>	
		
	<div class="card m-5 p-3 col-5">
		<table>
			<tr class="m-3">
				<td class="p">Title:</td>
				<td> <c:out value="${song.title}"></c:out> </td>
			</tr>
			<tr>
				<td>Artist:</td>
				<td> <c:out value="${song.artist}"></c:out> </td>
			</tr>
			<tr>
				<td>Rating(1-10):</td>
				<td> <c:out value="${song.rating}"></c:out> </td>
			</tr>
			<tr>
				<td>
					<form action="/delete/${song.id}" method="post">
		        		<input type="hidden" name="_method" value="delete">
				        <input type="submit" value="Delete">          	
				   	</form>				
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
