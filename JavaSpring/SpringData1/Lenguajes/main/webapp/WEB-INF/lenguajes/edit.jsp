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
	
	<div class="d-flex flex-row-reverse p-3">
		<a href="/lenguaje" >Dashboard</a>
		<form class="px-2" action="/lenguaje/${lenguaje.id}" method="post">
			<input type="hidden" name="_method" value="delete">
	        <input type="submit" value="Delete" style="none">          	
		</form>	
	</div>
	
	<form:form action="/lenguaje/${lenguaje.id}" method="post" modelAttribute="lenguaje">
	<input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors class="text-danger" path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors class="text-danger" path="creator"/>
        <form:input path="creator"/>
    </p>
    <p>
        <form:label path="version">Version</form:label>
        <form:errors class="text-danger" path="version"/>
        <form:input path="version"/>
    </p>
    
    <input type="submit" value="Submit"/>
</form:form>    
	
	

</body>
</html>