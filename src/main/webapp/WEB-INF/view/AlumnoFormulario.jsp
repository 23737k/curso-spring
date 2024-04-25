<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="form-styles.css">
<meta charset="ISO-8859-1">
<title>Formulario</title>
</head>
<body>
    <form:form action="procesarFormulario" modelAttribute="unAlumno" class="container"> 
        <legend>Complete sus datos</legend>
       	<label for="nombre" >Nombre: </label><form:input id="nombre" path="nombre"/>	<form:errors path="nombre" style="color:red;"/>			
       	<br>
       	<label for="apellido">Apellido:</label> <form:input id="apellido" path="apellido"/>
       	<br><br>
       	<br><br>
              	
        <input type="submit" value="Enviar">
    </form:form>
</body>
</html>
