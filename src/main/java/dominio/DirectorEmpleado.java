package dominio;

public class DirectorEmpleado implements Empleado {
	private String email;
	private String nombreEmpresa;
	
	@Override
	public String getTareas() {
		return "Hago las tareas del Director";
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
