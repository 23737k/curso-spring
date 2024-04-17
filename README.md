## Inyección de Dependencias
  - Crear clase + interfaz de las dependencias a utilizar
  - Agregar anotaciones
    - Agregar **@Component** a la [clase que va a ser inyectada](src/main/java/dominio/JefeEmpleado.java) y a [todas sus dependencias](src/main/java/dominio/Informe.java)
    - En la [clase que va a ser inyectada](src/main/java/dominio/JefeEmpleado.java), agregar **@Autowired** a la dependencia

  No hay necesidad de crear constructor ni setter. Sin embargo se puede hacer por cualquiera de estos 2 métodos. En estos casos bastaría con poner @Autowired arriba del constructor o setter en lugar de la dependencia. 
      
