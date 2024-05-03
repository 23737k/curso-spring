package dominio.empleados;

import dominio.informes.CreacionDeInforme;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Component
//@Scope("prototype")
public class DirectorEmpleado implements Empleado {
//	@Autowired
//	@Qualifier("informeTrimestre2")
	private String nombre;
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
