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
	<div class="row d-felx">
		<div class="col">
			<p class="display-5">Top Ten Song</p>
		</div>
		<div class="col-3 ml-auto p-2">
			<a href="/dashboard">Dashboard</a>	
		</div>
	</div>
	
	
	<div class="card p-4 m-5" >
		<table class="table">
			<tbody>
				<c:forEach items="${listaTopTen}" var="song">
					<tr>		            
						<td> <p> <c:out value="${song.rating}"/> - </p> </td>
						<td> <a href="/songs/${song.id}"> <c:out value="${song.title}"/> </a> </td>
						<td> 						
							<p> - <c:out value="${song.artist}"></c:out> </p>
						 </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>
