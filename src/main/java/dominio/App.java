package dominio;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// Creamos el contexto mediante el xml
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Le pedimos el bean de JefeEmpleado al contexto
		
		Empleado empleado1 = contexto.getBean("miJefeEmpleado", JefeEmpleado.class);  // Inyeccion de dependencias por Constructor
		
		System.out.println(empleado1.getInforme());
/*--------------------------------------------------------------------------------------------------------------------------------------------*/		
		//Hicimos empleado2 de tipo SecretarioEmpleado y no Empleado, porque este ultimo no tiene definido los getters de email y nombreEmpresa
		SecretarioEmpleado empleado2 = contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);//Inyeccion de dependencias por Setter e inyeccion de campos
		
		System.out.println(empleado2.getInforme());								
		
		System.out.println("email: " + empleado2.getEmail());		
		System.out.println("nombre de la empresa: " + empleado2.getNombreEmpresa());
		//Nota: 
		
		//Cerramos el contexto
		contexto.close();
		
	}

}
