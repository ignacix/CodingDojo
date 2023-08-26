
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
	<div>
		<a href="/dashboard">Dashboard</a>	
	</div>
	
	
		<div class="card p-6">
		<form:form action="/songs/new" method="post" modelAttribute="song">
		    <p>
		        <form:label path="title">Name</form:label>
		        <form:errors class="text-danger" path="title"/>
		        <form:input path="title"/>
		    </p>
<p>
		        <form:label path="artist">Creator</form:label>
		        <form:errors class="text-danger" path="artist"/>
		        <form:input path="artist"/>
		    </p>
		    <p>
		        <form:label path="rating">Version</form:label>
		        <form:errors class="text-danger" path="rating"/>
		        <form:input type="number" path="rating"/>
		    </p>
		    
		    <input type="submit" value="Add Song"/>
		</form:form>    
	</div>
	
	
	
</body>
</html>
