package dominio;

import java.util.List;

public class Alumno {
	
	private String nombre;
	private String apellido;
	private String materiaOptativa;
	private String lugarDeEstudio;
	private List<String> idiomas;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMateriaOptativa() {
		return materiaOptativa;
	}
	public void setMateriaOptativa(String materiaOptativa) {
		this.materiaOptativa = materiaOptativa;
	}
	public String getLugarDeEstudio() {
		return lugarDeEstudio;
	}
	public void setLugarDeEstudio(String lugarDeEstudio) {
		this.lugarDeEstudio = lugarDeEstudio;
	}
	public List<String> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List<String> idiomas) {
		this.idiomas = idiomas;
	}
	
	
	
}
