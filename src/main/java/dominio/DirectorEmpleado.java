package dominio;

public class DirectorEmpleado implements Empleado {
	private CreacionDeInforme informe;
	private String email;
	private String nombreEmpresa;
	
	@Override
	public String getTareas() {
		return "Hago las tareas del Director";
	}

	@Override
	public String getInforme() {
		return "Informe creado por el Director: " + informe.getInforme();
	}

	public void setInforme(CreacionDeInforme informe) {
		this.informe = informe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

}
