package dominio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dominio.services.ApiService;

@Controller
public class InicioController {
	@Autowired
	private ApiService apiService;
	@RequestMapping("/")
	public String redirigirAFormulario(Model model) {
		String origen = "avenida belgrano 2928, caba";
		String destino = "avenida san juan 3002, caba";
		String distancia = apiService.obtenerDistancia(origen,destino);
		model.addAttribute("distancia", distancia);
		
		return "Distancia";
	}
}
