## Inversión de Control (con archivo xml)
Básicamente consiste en hacer que Spring sea el agente externo que se encargue de instanciar y manipular nuestros objetos. Es decir, la aplicación no tendrá que hacerlo, sino que nosotros le indicaremos a Spring que tipo de objeto queremos y él nos lo proporcionará
Para ellos debemos: 
- Indicar en el archivo [applicationContext.xml](src/main/resources/applicationContext.xml) los beans que queremos utilizar. Allí indicaremos el nombre del bean y la clase
- En el [main](src/main/java/dominio/App.java):
  -  Le pedimos un bean al contexto
  - Cerramos el contexto

Cabe aclarar que siempre debemos tener un contructor sin argumentos, para que Spring pueda instanciar al bean.

La gracia de esto, es delegar la responsabilidad de crear objetos al contenedor de Spring. De esta manera el dev solo se preocupa de configurar los beans.
Esto tiene más sentido con una característica que deriva de la Inversión de control llamada **Inyección de Dependencias**.
