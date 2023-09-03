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
<title>Producto</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

	<div class="container mx-auto">

		<h1>
			<c:out value="${producto.name }"></c:out>
		</h1>

		<div class="row">
			<div class="col-6">
				<h2>Categorias</h2>
				<ul>
					<c:forEach items="${producto.getCategories()}" var="categoria">
						<li> <c:out value="${categoria.name }"></c:out>  </li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-6">
				<h2>Add Category:</h2>
				<form:form action="/aso/${producto.id }" method="post"
					modelAttribute="asociacion">
					<form:input type="hidden" path="product" value="${producto.id }" />
					<form:select class="form-control" path="category">
						<c:forEach items="${categorias}" var="categoria">
							<form:option value="${categoria.id} "> ${categoria.name}  
									</form:option>
						</c:forEach>
					</form:select>
					<button>Agregar</button>
				</form:form>


			</div>
		</div>
	</div>
</body>
</html>