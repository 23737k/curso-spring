package dominio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dominio.Alumno;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@RequestMapping("/formulario")
	public String formulario(Model modelo) {
		
		Alumno alumno = new Alumno();
		modelo.addAttribute("unAlumno", alumno);
		
		return "AlumnoFormulario";
	}
	/*
	 * El objeto de tipo Model sirve de puente entre el controlador y las vistas, es decir él almacenaremos nuestros objetos Java para que se puedan 
	 * transportar a las diferentes vistas.
	 * 
	 * addAttribute(String attributeName, Object attributeValue)--> Con este método agregamos nuestros objetos al Modelo, que luego serán invocados en las vistas
	 * */
	
	/**************************************************************************************************************************************************************/
	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario(@ModelAttribute("unAlumno") Alumno alumno) {
		return "RegistroConfirmacion";
	}
}

