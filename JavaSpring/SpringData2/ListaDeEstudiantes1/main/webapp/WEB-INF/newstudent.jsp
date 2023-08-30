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
<title>New Student</title>

<link rel="Stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/index.js"></script>

</head>
<body>
	<h1>New Student</h1>
	
	<div class="card p-6">
		<form:form action="/students/create" method="post" modelAttribute="student">
		    <div>
		        <form:label path="firstName">Name</form:label>
		        <form:errors class="text-danger" path="firstName"/>
		        <form:input path="firstName"/>
		    </div>
			<div>
		        <form:label path="lastName">Last Name</form:label>
		        <form:errors class="text-danger" path="lastName"/>
		        <form:input path="lastName"/>
		    </div>
		    <div>
		        <form:label path="age">Age</form:label>
		        <form:errors class="text-danger" path="age"/>
		        <form:input type="number" path="age"/>
		    </div>
		    
		    <input type="submit" value="Add Song"/>
		</form:form>    
	</div>
	
</body>
</html>

