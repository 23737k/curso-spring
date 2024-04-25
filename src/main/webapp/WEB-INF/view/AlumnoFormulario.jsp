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
       	<label for="email">E-mail:</label> <form:input type="email" id="email" path="email"/>	<form:errors path="email" style="color:red;"/>	
       	<br><br>
       	Materia Optativa: 
       	<form:select path="materiaOptativa">
       		<form:option value="arte" label="Arte"/>
       		<form:option value="danza" label="Danza"/>
       		<form:option value="football" label="Football"/>
       		<form:option value="volley" label="Volley"/>
       	</form:select>
       	<br><br>
       	Lugar de Estudios: <br>
       	<form:radiobutton id="argentina" value="Argentina" path="lugarDeEstudio"/> <label for="argentina"> Argentina</label> <br>
       	<form:radiobutton id="chile" value="Chile" path="lugarDeEstudio"/> <label for="chile"> Chile</label><br>
       	<form:radiobutton id="brasil" value="Brasil" path="lugarDeEstudio"/> <label for="brasil">Brasil</label>  <br>
       <br><br>
       Idiomas: <br>
       <form:checkbox id="ingles" path="idiomas" value="ingles"/> <label for="ingles">Ingles</label>  <br>
       <form:checkbox id="frances" path="idiomas" value="frances"/> <label for="frances">Frances</label> <br>
       <form:checkbox id="aleman" path="idiomas" value="aleman"/> <label for="aleman">Aleman</label> <br>
       <form:checkbox id="chino" path="idiomas" value="chino"/> <label for="chino">Chino</label> <br>
       <br><br><br>
              	
        <input type="submit" value="Enviar">
    </form:form>
</body>
</html>
