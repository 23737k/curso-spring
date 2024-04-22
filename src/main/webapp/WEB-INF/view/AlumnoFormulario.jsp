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
       	Nombre: <form:input path="nombre"/>				
       	<br>
       	Apellido: <form:input path="apellido"/>
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
       	<form:radiobutton value="Chile" path="lugarDeEstudio"/> Chile <br>
       	<form:radiobutton value="Brasil" path="lugarDeEstudio"/> Brasil <br>
       <br><br>
       Idiomas: <br>
       <form:checkbox path="idiomas" value="ingles"/> Ingles <br>
       <form:checkbox path="idiomas" value="frances"/> Frances <br>
       <form:checkbox path="idiomas" value="aleman"/> Aleman <br>
       <form:checkbox path="idiomas" value="chino"/> Chino <br>
       <br><br><br>
              	
        <input type="submit" value="Enviar">
    </form:form>
</body>
</html>
