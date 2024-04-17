package dominio;

public class JefeEmpleado implements Empleado {
	
	private CreacionDeInforme informe;
	
	public JefeEmpleado(CreacionDeInforme informe) {
		this.informe = informe;
	}
	
	@Override
	public String getTareas() {
		return "Hago las tareas del Jefe";
	}

	@Override
	public String getInforme() {
		return "Informe creado por el Jefe: " + informe.getInforme();
	}

	public void setInforme(CreacionDeInforme informe) {
		this.informe = informe;
	}

	

}
