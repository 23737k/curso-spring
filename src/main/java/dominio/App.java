package dominio;

import java.sql.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dominio.bd.ConexionConBBDD;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class,args);
		System.out.println("Executed Main Application");
	
		Connection conexion = ConexionConBBDD.getInstance();
			
	}

	
		  
		
	
}
