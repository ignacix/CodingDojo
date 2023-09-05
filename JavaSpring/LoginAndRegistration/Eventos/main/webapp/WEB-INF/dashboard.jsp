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
	<div class="container">
		<div class="row">
			<div class="col" >
				<h1> Bienvenido, <c:out value="${usuario.firstName}"></c:out> !</h1>
			</div>
			<div class="col text-end " >
				<a href="/logout">salir</a>
			</div>		
		</div>
		<div class="row" >
			<h3>Here are some events in your same state:</h3>
			<table class="table">
				<thead>
					<tr>
						<th>Name </th>
						<th>Date  </th> 						
						<th>Location</th>
						<th>Host</th>
						<th>Action/Status</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${eventosProvinciaUser}" var="eventosUser">
					<tr></tr>					
							<td><c:out value="${eventosUser.name}"></c:out> </td>
							
							<td>
								<fmt:formatDate value="${eventosUser.fecha}" pattern="MMMM dd, yyyy" var="fechaFormateada"/>
								<c:out value="${fechaFormateada}"></c:out> 
							</td>
							<td><c:out value="${eventosUser.location}"></c:out> </td>
							<td> <c:out value="${eventosUser.organizador.firstName}"></c:out> </td>
							<td>
								<c:choose>
									<c:when test="${eventosUser.organizador.id == usuario.id}">
										<a href="/events/${eventosUser.id}/edit" >Edit</a>
										<form:form action="/events/${eventosUser.id}/delete" method="post">
											<input type="hidden" name="_method" value="delete"/>										
											<button class="btn btn-danger">Delete</button>
										</form:form>																		
									</c:when>
									<c:otherwise>
										<a href="" >Unirse</a>
										<a href="" >Cancelar</a>
									</c:otherwise>
								</c:choose>										
							</td>
							
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="row" >
			<h3>Here are some events in other state:</h3>
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Date</th> 						
						<th>Location</th>
						<th>Provincia</th>
						<th>Host</th>
						<th>Action/Status</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${eventosProvinciaNoUser}" var="eventosDistintos">
					<tr></tr>					
							<td><c:out value="${eventosDistintos.name}"></c:out> </td>
							
							<td>
								<fmt:formatDate value="${eventosDistintos.fecha}" pattern="MMMM dd, yyyy" var="fechaFormateada"/>
								<c:out value="${fechaFormateada}"></c:out> 
							
							</td>
							<td><c:out value="${eventosDistintos.location}"></c:out> </td>
							<td><c:out value="${eventosDistintos.provincia}"></c:out></td>
							<td> <c:out value="${eventosDistintos.organizador.firstName}"></c:out> </td>
							<td>
								<c:choose>
									<c:when test="${eventosDistintos.organizador.id == usuario.id}">
										<a href="/events/${eventosDistintos.id}/edit" >Edit</a>
										<form:form action="/events/${eventosDistintos.id}/delete" method="post">
											<input type="hidden" name="_method" value="delete"/>										
											<button class="btn btn-danger">Delete</button>
										</form:form>
									
									</c:when>
									<c:otherwise>
										<a href="" >Unirse</a>
										<a href="" >Cancelar</a>
									</c:otherwise>
								</c:choose>						
							</td>
							
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="row">		
			
			    <form:form method="POST" action="/nuevo/evento" modelAttribute="evento">
			    	<form:input type="hidden" path="organizador" value="${usuario.id}"/>
			        <div>
			            <form:label path="name">Name:</form:label>
			            <form:input type="text" path="name"/>
			            <form:errors class="text-danger" path="name"/>
			        </div>
			        <div>
			            <form:label path="fecha">Date:</form:label>
			            <form:input type="date" path="fecha"/>
			            <form:errors class="text-danger" path="fecha"/>
			        </div>
			        
			        <div>
			            <form:label path="location">Location:</form:label>
			            <form:input type="text" path="location"/>
			            <form:errors class="text-danger" path="location"/>
			        </div>
			        <div>
			            <form:label path="provincia">Provincia:</form:label>
			            <form:select path="provincia" type="text" class="form-control">
			            	<c:forEach items="${provincias}" var="provincia">
			            		<form:option value="${provincia}"></form:option>
			            	</c:forEach>
			            </form:select>
			            <form:errors class="text-danger" path="provincia"/>			           
			        </div>			      
			        <input type="submit" value="Create Event!"/>
			    </form:form>
		</div>
		
	</div>
</body>
</html>