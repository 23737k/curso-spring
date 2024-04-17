package dominio;

public class SecretarioEmpleado implements Empleado {
	
	private CreacionDeInforme informe;
	
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


}
