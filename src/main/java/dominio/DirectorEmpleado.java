package dominio;

import dominio.informes.CreacionDeInforme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DirectorEmpleado implements Empleado {
	@Autowired
	@Qualifier("informeTrimestre2")
	private CreacionDeInforme informe;

	@Override
	public String getTareas() {
		return "Hago las tareas del Director";
	}

	@Override
	public String getInforme() {
		return informe.getInforme() ;
	}
}
