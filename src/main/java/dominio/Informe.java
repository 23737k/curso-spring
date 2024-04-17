package dominio;

import org.springframework.stereotype.Component;

@Component
public class Informe implements CreacionDeInforme {

	@Override
	public String getInforme() {
		return " esta es la presentacion del informe";
	}

}
