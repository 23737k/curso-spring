## Spring MVC
Modelo:

  El objeto de tipo  Model en Spring, es un contenedor que contiene los datos que irán a la vista. Estos datos pueden ser Objetos de Java, Información  obtenida de la BBDD, colecciones, etc. Sin embargo en MVC, el modelo representa el dominio junto con la persistencia

Vista: 

  Son aquellos archivos que se muestran al usuario en el Front. Consta de archivos html o jsp

Controlador:

  son aquellos que manejan los endpoints. Cada uno maneja un endpoint distinto (Ej: "/", "/formulario"), e interactúa con el Modelo para luego devolver una vista.  

  
  [Controlador](src/main/java/dominio/controller/Controlador.java)  
  
  [Index](src/main/webapp/WEB-INF/view/Index.jsp)
  
  [FormularioController](src/main/java/dominio/controller/FormularioController.java)

  [Formulario.jsp](src/main/webapp/WEB-INF/view/Formulario.jsp)

  [SaludoCool](src/main/webapp/WEB-INF/view/SaludoCool.jsp)
  
