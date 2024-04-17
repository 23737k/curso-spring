# Inyección de Dependencias
Consiste en configurar Spring para que instancie objetos y les inyecte las dependencias correspondientes (atributos), sin tener que hacerlo desde nuestro programa.
[Existen 2 métodos](src/main/resources/applicationContext.xml)
- Por constructor
  - Crear las clases e interfaces de las dependencias
  - Crear el constructor en la clase para la inyección de dependencias
  - configurar en el xml la inyeccion de dependencia
- Por setter
  - Crear las clases e interfaces de las dependencias
  - Crear el setter en la clase para la inyección de dependencias
  - configurar en el xml la inyeccion de dependencia  

Si no hubieramos usado Inyeccion de dependencias, normalmente hubieramos tenido que hacer un new Informe() y un new JefeEmpleado() y pasarle por parametro el informe.

Con Spring nos ahorramos esto, ya que lo gestiona.
Ademas al utilizar interfaces (Empleado y CreacionInforme) nos desacoplamos de las implementaciones. Es decir si en algun momento quisiera usar en mi programa un SecretarioEmpleado en el main, no tendría que cambiar mi código. Sólo tendría que cambiar el xml e indicar que quiero un SecretarioEmpleado.class.


[main](src/main/java/dominio/App.java) 

[applicationContext](src/main/resources/applicationContext.xml)

# Inyección de campos
Esta vez inyectaremos campos. La diferencia entre un campo y una dependencia, es que este último es un objeto. Mientras que un campo es un String, Int, Date, etc.

Los pasos son similares al método por setter:
  - Crear en la clase, los setters de los campos
  - configurar en el xml la inyeccion de campos, indicando un value (valor por defecto)

**Además existe una manera de inyectar valores en los campos, mediante un [archivo de propiedades](src/main/resources/datosEmpresa.propiedades)**

