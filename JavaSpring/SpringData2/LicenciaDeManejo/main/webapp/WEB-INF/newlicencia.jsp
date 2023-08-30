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

	<h1>New Licencias</h1>
	
	<div class="card p-6">
		<form:form action="/enviarlicencia/new" method="POST" modelAttribute="licencia">
		    <div class="form-group">
		    	<form:label path="persona"></form:label>		    
		    	<form:select path="persona">
			    	<c:forEach items="${listaPersonas}" var="p" >
			    		<form:option value="${p.id}">${p.firstName} ${p.lastName}</form:option>
			    	</c:forEach>
			    </form:select> 
		    </div>
		    
		    <div class="form-group">
		        <form:label path="state">State: </form:label>
		        <form:errors class="text-danger" path="state"/>
		        <form:input path="state"/>		    
		    </div>
		    		    
		    <div class="form-group">
		        <form:label path="expirationDate">Expiration Date: </form:label>
		        <form:errors class="text-danger" path="expirationDate"/>
		        <form:input type="date" path="expirationDate"/>		    
		    </div>
		    
		    <input type="submit" value="Create"/>
		</form:form>    
	</div>	 	


</body>
</html>
