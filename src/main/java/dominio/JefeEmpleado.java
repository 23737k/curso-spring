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
		// TODO Auto-generated method stub
		return "Informe creado por el Jefe: " + informeNuevo.getInforme();
	}

}
