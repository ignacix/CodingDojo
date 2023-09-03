<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formateo fechas (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Formulario form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Producto</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

<div class="container mx-auto col-3">
		<h1>New Product</h1>
		<form:form action="/products/new" method="POST" modelAttribute="producto">
			<div class="form-group">
				<form:label class="form-label" path="name">Name:  </form:label>
				<form:errors class="text-danger" path="name" />
				<form:input type="text" class="form-control" path="name" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="description">Description: </form:label>
				<form:errors class="text-danger" path="description" />
				<form:input type="text" class="form-control" path="description" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="price">Price:  </form:label>
				<form:errors class="text-danger" path="price" />
				<form:input type="number" class="form-control" path="price" />
			</div>
			<button class="btn btn-success">Create Product</button>
		</form:form>
	</div>

</body>
</html>