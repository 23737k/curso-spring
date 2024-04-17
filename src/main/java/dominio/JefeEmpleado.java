package dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("JefeEmpleado")	//Si prescindimos de un nombre, Spring nombrara al bean como la clase pero con miniscula: jefeEmpleado
public class JefeEmpleado implements Empleado {

	@Autowired
	private CreacionDeInforme informe;

	public JefeEmpleado(CreacionDeInforme informe) {
		this.informe = informe;
	}

	public String getInforme(){
		return informe.getInforme();
	}

	@Override
	public String getTareas() {
		return "Hago las tareas del Jefe";
	}



	

}
