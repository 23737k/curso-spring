package dominio.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionConBBDD {
	
	private static Connection conexion;
	private final static String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10699337";
	private final static String user = "sql10699337";
	private final static String pass = "MLeR2Lz8Ii";
	
	private ConexionConBBDD() {
		
	}
	
	public static Connection getInstance() {
		if(conexion==null)
			return realizarConexion();
		else {
			System.out.println("Instancia de conexion devuelta");
			return conexion;
		}
			
	}
	
	private static Connection realizarConexion() {
		try {
			System.out.println("Intentando conectar con la BBDD");
			//Crear conexion  
			conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion exitosa!!!");
			
		} catch (Exception e) {
			System.out.println("CONEXION FALLIDA");
			e.printStackTrace();					//esto hace que nos muestre que error hubo. Sino no muestra nada. Es muy util
		}
		
		return conexion;
	}
	  
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
