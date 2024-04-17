package dominio;

import org.springframework.stereotype.Component;

@Component("JefeEmpleado")	//por coherencia ponemos el mismo nombre de la clase
public class JefeEmpleado implements Empleado {
		
	@Override
	public String getTareas() {
		return "Hago las tareas del Jefe";
	}



	

}
