package dominio;

public class SecretarioEmpleado implements Empleado {
	
	private CreacionDeInforme informe;
	private String email;
	private String nombreEmpresa;
	
	public void setInforme(CreacionDeInforme informe) {
		this.informe = informe;
	}
	
	@Override
	public String getTareas() {
		return "Hago las tareas del secretario";
	}

	@Override
	public String getInforme() {
		return "Informe creado por el Secretario: " + informe.getInforme();
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
