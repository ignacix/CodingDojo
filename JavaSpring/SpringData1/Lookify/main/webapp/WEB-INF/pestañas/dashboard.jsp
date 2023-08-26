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
	<div class="row d-flex justify-content-around pt-4">
		<div class="col-4">
		<a href="/songs/new">Add New</a>
		<a href="/search/topTen">Top Songs</a>		
		</div>
		<div class="col-4" >
			<form action="/search" method="get">
				<input type="text" name="artist" placeholder="Nombre del Artista">
				<button type="submit" >Buscar Artista</button>
			</form>
		</div>
	</div>
	
	
	
	<div class="card p-4 m-5" >
		<table class="table">
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Rating</th>
		            <th>actions</th>		         
		        </tr>
		    </thead>
			<tbody>
				<c:forEach items="${listSong}" var="song">
					<tr>		            
						<td> <a href="/songs/${song.id}"> <c:out value="${song.title}"/> </a> </td>
						<td><c:out value="${song.rating}"/></td>
						<td> 						
							<form action="/delete/${song.id}" method="post">
			            		<input type="hidden" name="_method" value="delete">
			            		<input type="submit" value="Delete">          	
			            	</form>
						 </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
</body>
</html>

