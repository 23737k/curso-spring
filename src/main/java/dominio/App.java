package dominio;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// Creamos el contexto mediante el xml
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Le pedimos el bean de JefeEmpleado al contexto
		
		Empleado empleado1 = contexto.getBean("JefeEmpleado", Empleado.class);  
		
		System.out.println(empleado1.getTareas());
		System.out.println(empleado1.getInforme());
		
		contexto.close();
		
	}

}
