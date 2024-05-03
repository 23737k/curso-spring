package dominio.empleados;

import dominio.informes.CreacionDeInforme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("JefeEmpleado")	//Si prescindimos de un nombre, Spring nombrara al bean como la clase pero con miniscula: jefeEmpleado
public class JefeEmpleado implements Empleado {

	@Autowired
	@Qualifier("informeTrimestre1")		//bean ID que debe utilizar Spring para inyectar la dependencia.
	private CreacionDeInforme informe;

	public String getInforme(){
		return informe.getInforme();
	}

	@Override
	public String getTareas() {
		return "Hago las tareas del Jefe";
	}



	

}
