# Inyección de Dependencias
Consiste en configurar Spring para que instancie objetos y les inyecte las dependencias correspondientes (atributos), sin tener que hacerlo desde nuestro programa.
[Existen 2 métodos](src/main/resources/applicationContext.xml)
- Por constructor
  - Crear las clases e interfaces de las dependencias
  - Crear el constructor en la clase para la inyección de dependencias
  - configurar en el xml la inyeccion de dependencia   
- Por getter

[main](src/main/java/dominio/App.java) 

[applicationContext](src/main/resources/applicationContext.xml)
