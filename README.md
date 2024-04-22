# MVC Tags
Para poder utilizar esta funcionalidad debemos colocar esta directiva al inicio de nuestro .jsp
``` jsp
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
```

- ### Formulario
  ``` jsp
  <form:form path="attributeName" ></form:form>
  ```
  
  Se utiliza para formularios. En path colocaremos el nombre del atributo que agregamos previamente al modelo. Este atributo se trata de un objeto Java/bean
- ### Input
  ```jsp
  <form:input path="property"/>
  ```
  
  Path va a referenciar a los getters y setters de las properties del objeto que agregamos como atributo. El valor de path será el nombre del getter/setter pero sin el get/set y comenzando con minúsculas.

  Cada vez que se cargue el formulario, el path llamará al getter de la propiedad. Cada vez que se envíe el formulario, llamará al setter con el valor que hayamos introducido en el campo.
- ### Menu Desplegable (Select)
  ```jsp
  <form:select path="property">
      <form:option value="valorDeLaOpcion" label="descripcionDeLaOpcion"/>
  </form:select>
  ```

- ### Radio
  ``` jsp
  <form:radiobutton path="property" value=""/>
  ```
- ### Checkbox
  ``` jsp
  <form:checkbox path="" value="">
  ```


# ¿Cómo utilizarlos? 
1) En el [controller](src/main/java/dominio/controller/AlumnoController.java) creamos el método que se encargará de:
    - Agregar nuestro objeto al modelo.
    - Devolvernos la vista que muestra el formulario
2) En nuestra [vista](src/main/webapp/WEB-INF/view/AlumnoFormulario.jsp) utilizaremos las MVC tags para poder capturar la información y almacenarla en nuestro objeto. Esta debe redirigirnos a una ruta que procese el formulario
3) En el [controller](src/main/java/dominio/controller/AlumnoController.java) creamos el método que se encargará de:
   - Procesar el formulario: rescatar la informacion del objeto almacenado en el modelo y operar sobre él (almacenar en bd, llamar a métodos, etc.)
   - Devolver la vista de confirmación del formulario: esta vista se muestra despues de enviar el formulario. Puede o no, hacer uso del objeto rescatado mediante jsp tags
4) En la [vista](src/main/webapp/WEB-INF/view/RegistroConfirmacion.jsp), podemos invocar ahora a nuestro objeto mediante jsp tags: `${attributeName.property}`

