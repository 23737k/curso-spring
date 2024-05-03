package dominio;

import dominio.empleados.Empleado;
import dominio.empleados.SecretarioEmpleado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
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
		
	}

}
