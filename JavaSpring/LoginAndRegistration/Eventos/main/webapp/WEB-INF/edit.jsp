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
			    <form:form method="POST" action="/events/${evento.id}/edit" modelAttribute="evento">
			    	<input type="hidden" name="_method" value="put"/>
			    	<!--este encia el id del usuario para validar que la persona es la que la creó  -->
			    	<form:input type="hidden" path="organizador" value="${usuario.id}"/>
			        <div>
			            <form:label path="name">Event Name:</form:label>
			            <form:input type="text" path="name"/>
			            <form:errors class="text-danger" path="name"/>
			        </div>
			        <div>
			            <form:label path="fecha">Event Date:</form:label>
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
			        <input type="submit" value="Edit Event!"/>
			    </form:form>
		</div>
	</div>

</body>
</html>
