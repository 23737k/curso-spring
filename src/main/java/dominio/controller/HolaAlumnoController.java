package dominio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolaAlumnoController {
	@RequestMapping("/formulario")
	public String mostrarFormulario() {
		return "HolaAlumnosFormulario";
	}
}
