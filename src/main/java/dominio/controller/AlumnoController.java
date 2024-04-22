package dominio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dominio.Alumno;
import jakarta.validation.Valid;

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
	
	
	/*												VALIDACION																*/
	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario(@Valid @ModelAttribute("unAlumno") Alumno alumno, BindingResult resultadoValidacion) {
		
		if(resultadoValidacion.hasErrors())
			return "AlumnoFormulario";
		else
			return "RegistroConfirmacion";
	}
	/*
	 * Antes de que el método procesarFormulario sea invocado, ya tenemos los resultados de la validacion de campos
	 * Estos resultados se almacenarán en una variable de tipo BindingResult que agregaremos como parámetro del metodo
	 * 
	 * Además debemos indicar que estamos haciendo una validacion del Alumno. Para ello agregamos la anotacion @Valid en Alumno
	 * 
	 * Luego consultamos los resultados de validacion, y en caso de que haya errores devolvemos el formulario nuevamente. En caso de que no
	 * devolvemos la confirmacion del formulario
	 * 
	 * */
	
}

