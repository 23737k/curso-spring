package dominio.empleados;

import dominio.informes.CreacionDeInforme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecretarioEmpleado implements Empleado {
	@Autowired
	@Qualifier("informeTrimestre2")
	private CreacionDeInforme informe;

	@Value("${correoElectronico}")			//colocamos el nombre de la propiedad que figura en el archivo de propiedades
	private String email;
	@Value("${nombreDeLaEmpresa}")
	private String nombreEmpresa;
	
	@Override
	public String getTareas() {
		return "Hago las tareas del secretario";
	}

	@Override
	public String getInforme() {
		return informe.getInforme();
	}

	public String getEmail() {
		return email;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
}
