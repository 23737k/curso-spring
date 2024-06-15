package curso_spring.dominio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
	 
	@GetMapping("/")
	public ResponseEntity<?> greeting() {
		return new ResponseEntity<>("Hola", HttpStatus.OK);
	}
}
