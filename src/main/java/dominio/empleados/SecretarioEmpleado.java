package dominio.empleados;

import dominio.informes.CreacionDeInforme;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Component
public class SecretarioEmpleado implements Empleado {

	private final CreacionDeInforme informe;

	@Value("${email.empresa}")			//colocamos el nombre de la propiedad que figura en el archivo de propiedades
	private String email;
	@Value("${nombre.empresa}")
	private String nombreEmpresa;

	public SecretarioEmpleado(@Qualifier("informeTrimestre2") CreacionDeInforme informe) {
		this.informe = informe;
	}

	@Override
	public String getTareas() {
		return "Hago las tareas del secretario";
	}

	@Override
	public String getInforme() {
		return informe.getInforme();
	}

}
