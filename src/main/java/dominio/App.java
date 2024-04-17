package dominio;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// Creamos el contexto mediante el xml
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Le pedimos el bean de JefeEmpleado al contexto
		
		Empleado empleado1 = contexto.getBean("miJefeEmpleado", JefeEmpleado.class);  // Inyeccion de dependencias por Constructor
		
		//Usamos el bean
		System.out.println(empleado1.getInforme());
		
		Empleado empleado2 = contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		System.out.println(empleado2.getInforme());									//Inyeccion de dependencias por Setter
		
		//Cerramos el contexto
		contexto.close();
		
	}

}
