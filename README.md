# Validacion de formularios 
Para comenzar debemos agregar la siguiente dependencia a nuestro pom.xml
``` xml
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
```

Los pasos para validar son:

1) Especificar las propiedades a validar en la [clase](src/main/java/dominio/Alumno.java) correspondiente
2) Especificar validacion en el [controller](src/main/java/dominio/controller/AlumnoController.java)
3) Especificar el [mensaje de validacion](src/main/webapp/WEB-INF/view/AlumnoFormulario.jsp) en el formulario de registro con
   ``` jsp
   <form:errors path="property"/>
   ```

[Más tipos de validaciones aquí](https://medium.com/@himani.prasad016/validations-in-spring-boot-e9948aa6286b)
