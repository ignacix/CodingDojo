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
		
			<div class="col-4">
				<h2>Register!</h2>
			    
			    <p><form:errors class="text-danger" path="user.*"/></p>
			    
			    <form:form method="POST" action="/registration" modelAttribute="user">
			        <div>
			            <form:label path="firstName">FirstName:</form:label>
			            <form:input type="text" path="firstName"/>
			        </div>
			        <div>
			            <form:label path="lastName">LastName:</form:label>
			            <form:input type="text" path="lastName"/>
			        </div>
			        
			        <div>
			            <form:label path="location">Location:</form:label>
			            <form:input type="text" path="location"/>
			        </div>
			        <div>
			            <form:label path="provincia">Provincia:</form:label>
			            <form:select path="provincia" type="text" class="form-control">
			            	<c:forEach items="${provincias}" var="provincia">
			            		<form:option value="${provincia}"></form:option>
			            	</c:forEach>
			            </form:select>			           
			        </div>
			        
			        <div>
			            <form:label path="email">Email:</form:label>
			            <form:input type="email" path="email"/>
			        </div>
			        <div>
			            <form:label path="password">Password:</form:label>
			            <form:password path="password"/>
			        </div>
			        <div>
			            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
			            <form:password path="passwordConfirmation"/>
			        </div>
			        <input type="submit" value="Register!"/>
			    </form:form>
				<p class="text-success"> <c:out value="${registro}"></c:out> </p>
			</div>
			
			<div class="col-4">
				
			<h2>Login!</h2>
			    
			    <p><form:errors class="text-danger" path="login.*"/></p>
			    
			    <form:form method="POST" action="/login" modelAttribute="login">
			        <p>
			            <form:label path="email">Email:</form:label>
			            <form:input type="email" path="email"/>
			        </p>
			        <p>
			            <form:label path="password">Password:</form:label>
			            <form:password path="password"/>
			        </p>
			        <input type="submit" value="Login!"/>
			    </form:form>
				
			</div>
				    
		</div>
									
	</div>							    				   			    			    			   
</body>
</html>