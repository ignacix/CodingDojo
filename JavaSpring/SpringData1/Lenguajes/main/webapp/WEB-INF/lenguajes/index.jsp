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
	<table class="table">
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Creator</th>
	            <th>Version</th>
	            <th>action</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${lenguaje}" var="lenguaje">
		        <tr>		            
		            <td> <a href="/lenguaje/${lenguaje.id}"> <c:out value="${lenguaje.name}"/> </a></td>
		            <td><c:out value="${lenguaje.creator}"/></td>
		            <td><c:out value="${lenguaje.version}"/></td>
					<td>
		            	<form action="/lenguaje/${lenguaje.id}" method="post">
		            		<input type="hidden" name="_method" value="delete">
		            		<input type="submit" value="Delete">          	
		            	</form>
		            </td>
		            <td>
		            	<a href="/lenguaje/${lenguaje.id}/edit">Edit</a>
		            </td>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<div class="card p-6">
		<form:form action="/lenguaje" method="post" modelAttribute="leng">
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
	</div>
	
	

</body>
</html>