package dominio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormularioController {
	
	/* METODOS QUE SOLO DEVUELVEN UNA VISTA */
	@RequestMapping("/formulario")
	public String mostrarFormulario() {
		return "Formulario";
	}

	@RequestMapping("/saludo")
	public String saludo() {
		return "Saludo";
	}
	
	/**********************************************/
	
	/* METODOS QUE MODIFICAN EL MODELO  */
	
	@RequestMapping("/saludoCool")
	public String saludoCool(@RequestParam("nombre")String nombre, Model model ) {		//CON @RequestParam(nombre) otengo el parametro y lo almaceno 
																						// en la variable String nombre
	/*
	 * public String saludoCool(HttpServletRequest request, Model model ) {		ASI SE HARIA SI NO TUVIERAMOS LA ANOTATION
	 *	
	 *	String nombre = request.getParameter("nombre");							Obtengo del request el parametro <nombre> del envio de formulario
	 *
	 **/	
	
		String saludoCool = "Hola " + nombre + " este es un saludo cool";
		//Agrego al Modelo el parametro saludoCool, para que se muestre en la vista
		model.addAttribute("saludoCool",saludoCool);
		//retorno la vista. Luego en ella invocaré el parametro que acabo de agregar para mostrarlo
		return "SaludoCool";	//Recordar cambiar el nombre del endpoint al que redirigira Formulario.jsp por saludoCool
	}
	
	
	
	
}
