package dominio;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
				
		//Cargamos el archivo xml en el contexto
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Le pedimos al contexto, el bean que agregamos previamente en el xml (ver archivo)
		Empleado empleado1 = contexto.getBean("miEmpleado", JefeEmpleado.class);
		
		//Utilizamos el bean de JefeEmpleado
		System.out.println(empleado1.getTareas());
		
		//Cerramos el contexto 
		contexto.close();
		
		
		
		
		
		
		/*
		SpringApplication.run(App.class,args);
		System.out.println("Executed Main Application");
		*/
	}

}
