## Inyección de Dependencias
  - Crear clase + interfaz de las dependencias a utilizar
  - Agregar anotaciones
    - Agregar **@Component** a la [clase que va a ser inyectada](src/main/java/dominio/JefeEmpleado.java) y a [todas sus dependencias](src/main/java/dominio/informes)
    - En la [clase que va a ser inyectada](src/main/java/dominio/JefeEmpleado.java), agregar **@Autowired** a la dependencia

  No hay necesidad de crear constructor ni setter. Sin embargo se puede hacer por cualquiera de estos 2 métodos. En estos casos bastaría con poner @Autowired arriba del constructor o setter en lugar de la dependencia. 

## Annotation @Qualifier
Esta anotación la utilizamos cuando queremos hacer una inyección de dependencias, pero la interfaz de la dependencia [tiene más de una implementación](src/main/java/dominio/informes).

En este caso, Spring no sabrá cual implementación inyectar. Cabe aclarar que nos referimos a implementaciones que tengan @Component. Aquellas que no lo tengan, no serán consideradas por Spring.


Para solucionar este problema se coloca arriba de la dependencia la annotation: @Qualifier("nombreDelComponente").
Recordemos que si no le colocamos un nombre en @Component, el nombre por defecto será el nombre de la clase pero comenzando en minúscula.

## Singleton/Prototype con @Scope
Spring utiliza por defecto el patrón Singleton para la generación de beans. Es decir, si nosotros le pedimos varios beans de la misma clase al contenedor de Spring, estos apuntará al mismo objeto.

Podemos cambiar esto, haciendo que Spring utilice Prototype. Es decir, Spring creará el primer bean y luego generará copias a medida que se las pidamos.

Para cambiar esto, colocamos la annotation [@Scope("prototype")](src/main/java/dominio/DirectorEmpleado.java) arriba del bean.

## Utilizar una clase java como archivo de configuracion (@Configuration - @ComponentScan)
Consiste en crear una clase java como archivo de configuración en lugar del archivo xml que comunmente se usaba. 

[Creacion del contexto](src/main/java/dominio/App.java)

[Clase de configuracion](src/main/java/dominio/config/ConfigFile.java)

## Inyeccion de Campos (@PropertySource - @Value)

Para inyectar campos debemos tener un [archivo de propiedades creado](src/main/resources/datosEmpresa.propiedades)

Colocamos la annotation @PropertySource en la [clase de config](src/main/java/dominio/config/ConfigFile.java) para indicar donde buscar el archivo de propiedades

Colocamos en [los campos a inyectar](src/main/java/dominio/SecretarioEmpleado.java), la annotation @Value donde indicamos el nombre de la propiedad en el archivo
