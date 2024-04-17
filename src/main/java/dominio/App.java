package dominio;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");

		
		Empleado empleado1 = contexto.getBean("JefeEmpleado", Empleado.class);

		System.out.println(empleado1.getTareas());
		System.out.println(empleado1.getInforme());



	/*---------------------------------------------------------------------------------------------------------------------------------------------*/
		/* Singleton vs Prototype */
		System.out.println("\nSingleton: misma direccion de memoria");
		Empleado empleado2 = contexto.getBean("JefeEmpleado", Empleado.class);
		System.out.println(empleado2 + "\n" + empleado1 );

		System.out.println("\nPrototype: diferentes direcciones de memoria");
		Empleado empleado3 = contexto.getBean("directorEmpleado", Empleado.class);
		Empleado empleado4 = contexto.getBean("directorEmpleado", Empleado.class);

		System.out.println(empleado3 + "\n" + empleado4);

		
		contexto.close();
		
	}

}
