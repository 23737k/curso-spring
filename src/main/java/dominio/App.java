package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class,args);
		System.out.println("Executed Main Application");
	
		conectarConBBDD();
			
	}

	public static void conectarConBBDD() {
		final String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10699337";
		  final String user = "sql10699337";
		  final String pass = "MLeR2Lz8Ii";
		  
		  try {
			System.out.println("Intentando conectar con la BBDD");
			//Crear conexion  
			Connection conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion exitosa!!!");
			
		} catch (Exception e) {
			System.out.println("CONEXION FALLIDA");
			e.printStackTrace();					//esto hace que nos muestre que error hubo. Sino no muestra nada. Es muy util
		}
		  
		 /* 
		 SessionFactory sessionFactory =  new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UnaClase.class).buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 
		 try {
			 UnaClase objeto = new UnaClase("nafta",3.0);
			session.beginTransaction();
			session.persist(objeto);
			session.getTransaction().commit();
			session.close();
		} finally {
			session.close();
		}
		*/
	}
}
