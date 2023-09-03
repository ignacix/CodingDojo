
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
<title>Index</title>

<link rel="Stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/index.js"></script>

</head>
<body>
	
		<div class="container">
		<h1>Bienvenido a Productos y Categorias</h1>
		
		<div class="col mx-auto ">
			<a  href="/categories/new"> Nueva Category</a> 
			<a  href="/products/new"> Nuevo Producto</a>
		</div>
		
		</div>
	
	
</body>
</html>
