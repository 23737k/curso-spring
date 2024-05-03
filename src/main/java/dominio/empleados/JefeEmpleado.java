package dominio.empleados;

import dominio.informes.CreacionDeInforme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//Con esta anotación Spring considerará a JefeEmpleado como un Bean.
//Si prescindimos de un nombre, Spring nombrará al Bean como la clase pero con minúscula: jefeEmpleado
@Component
public class JefeEmpleado implements Empleado {

	private final CreacionDeInforme informe;

	// DI por constructor. Es la más recomendada. La DI por campos está desaconsejada.
	// En este caso le indicamos a Spring que inyecte la dependencia informe de tipo CreacionInforme. Pero como esta es una interfaz y tiene más de
	// una implementación, debemos indicarle a Spring cuál debe usar. Esto lo hacemos con la anotación @Qualifier("nombreDelBean").
	// Recordar que la dependencia también debe estar declarada como Bean.
	@Autowired
	public JefeEmpleado(@Qualifier("informeTrimestre1") CreacionDeInforme informe) {
		this.informe = informe;
	}
	//Cuando existe un único constructor, podemos prescindir de @Autowired

	public String getInforme(){
		return informe.getInforme();
	}

	@Override
	public String getTareas() {
		return "Hago las tareas del Jefe";
	}

}
