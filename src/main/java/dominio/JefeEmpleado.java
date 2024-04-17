package dominio;

public class JefeEmpleado implements Empleado {
	
	private CreacionDeInforme informeNuevo;
	
	public JefeEmpleado(CreacionDeInforme informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
	@Override
	public String getTareas() {
		return "Hago las tareas del Jefe";
	}

	@Override
	public String getInforme() {
		return "Informe creado por el Jefe: " + informeNuevo.getInforme();
	}

	public CreacionDeInforme getInformeNuevo() {
		return informeNuevo;
	}

	public void setInformeNuevo(CreacionDeInforme informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	

}
