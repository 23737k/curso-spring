package dominio;

public class DirectorEmpleado implements Empleado {
	private Informe informeNuevo;
	
	@Override
	public String getTareas() {
		return "Hago las tareas del Director";
	}

	@Override
	public String getInforme() {
		return "Informe creado por el Jefe: " + informeNuevo.getInforme();
	}

}
