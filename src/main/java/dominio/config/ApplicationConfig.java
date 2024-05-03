package dominio.config;

import dominio.empleados.DirectorEmpleado;
import dominio.empleados.SecretarioEmpleado;
import dominio.informes.CreacionDeInforme;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class ApplicationConfig {


  //El nombre del bean será el nombre del método, en este caso "secretarioEmpleado". En caso de que queramos cambiarle el nombre debemos agregarle a
  //la anotación @Bean("customName")
  @Bean
  public DirectorEmpleado directorEmpleado(){
    return new DirectorEmpleado();
  }

  /* Podemos crear varios beans del mismo tipo, por ejemplo podríamos crear dos o más beans de tipo DirectorEmpleado, pero inicializados de forma distinta.
     Debemos darle nombres distintos a los beans o nos tirará un error.
    Si luego queremos usarlos, debemos diferenciarlos de alguna forma:
    En el contexto, le indicamos el nombre del bean: context.get("directorEmpleado1", DirectorEmpleado.class);
    Si vamos a inyectarlo, debemos anotar el parámetro del constructor con @Qualifier("bean2"), para indicarle a Spring cuál debe inyectar. Ver JefeEmpleado.java
    Tener en cuenta que el nombre del bean y el nombre del qualifier son dos cosas distintas. @Qualifier se utiliza para que cuando queramos inyectar una dependencia
    de un tipo determinado (en este caso DirectorEmpleado), Spring sepa cuál debe inyectar con prioridad.

    @Bean
    @Qualifier("bean1")
    public DirectorEmpleado directorEmpleado1(){
      return new DirectorEmpleado(....);
    }

    @Bean
    @Qualifier("bean2")
    public DirectorEmpleado directorEmpleado2(){
      return new DirectorEmpleado(....);
    }
  *
  * */


}
