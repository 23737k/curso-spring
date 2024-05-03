package dominio;

import dominio.empleados.DirectorEmpleado;
import dominio.empleados.JefeEmpleado;
import dominio.empleados.SecretarioEmpleado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		//La línea de abajo ejecuta nuestra app de Spring y nos retorna el contexto, es decir el contenedor de Beans de Spring.
		ConfigurableApplicationContext contexto =  SpringApplication.run(App.class, args);

		//Podemos definir los beans en la clase App (fuera del main) o en una clase de configuración (ver ApplicationConfig.java)
		//En este caso, definimos el bean en ApplicationConfig.java

		//pedimos el bean al contexto
		DirectorEmpleado directorEmpleado = contexto.getBean(DirectorEmpleado.class);

		//usamos el bean
		System.out.println(directorEmpleado.getTareas());

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		//También podemos definir Beans mediante la anotación @Component/@Service/@Controller/@Repository en la clase (no interfaz) correspondiente.
		//Cuando se inicie la app, Spring va a escanear todas las clases en busca de estas anotaciones.
		//En este ejemplo utilizamos el Bean de jefeEmpleado.

		JefeEmpleado jefeEmpleado = contexto.getBean(JefeEmpleado.class);

		//hago uso del Bean
		System.out.println(jefeEmpleado.getTareas());

		/*-----------------------------------------------------------------------------------------------------------------------------*/
		// Inyección de dependencias.
		// Aquí utilizaremos el método getInforme() de JefeEmpleado. Este método hace uso de la dependencia informe, que nos devuelve el informe correspondiente.
		// En este caso se le inyecta la dependencia de tipo InformeTrimestre. Ver JefeEmpleado.java

		System.out.println(jefeEmpleado.getInforme());

		SecretarioEmpleado secretarioEmpleado = contexto.getBean(SecretarioEmpleado.class);
		System.out.println(secretarioEmpleado.getEmail() + "\n" +secretarioEmpleado.getNombreEmpresa());
		System.out.println(secretarioEmpleado.getTareas());

	}

}

//
//		/*  Inyeccion de dependencias  */
//		System.out.println("Inyeccion de dependencias");
//		Empleado empleado1 = contexto.getBean("JefeEmpleado", Empleado.class);
//		System.out.println(empleado1.getTareas());
//		System.out.println(empleado1.getInforme());
//
//		/*  Inyeccion de campos  */
//		System.out.println("\nInyeccion de campos");
//		SecretarioEmpleado
//				secretarioEmpleado = contexto.getBean("secretarioEmpleado", SecretarioEmpleado.class);
//		System.out.println(secretarioEmpleado.getEmail());
//		System.out.println(secretarioEmpleado.getNombreEmpresa());
//
//	/*---------------------------------------------------------------------------------------------------------------------------------------------*/
//		/* Singleton vs Prototype */
//		System.out.println("\nSingleton: misma direccion de memoria");
//		Empleado empleado2 = contexto.getBean("JefeEmpleado", Empleado.class);
//		System.out.println(empleado2 + "\n" + empleado1 );
//
//		System.out.println("\nPrototype: diferentes direcciones de memoria");
//		Empleado empleado3 = contexto.getBean("directorEmpleado", Empleado.class);
//		Empleado empleado4 = contexto.getBean("directorEmpleado", Empleado.class);
//
//		System.out.println(empleado3 + "\n" + empleado4);
//
//
//		contexto.close();