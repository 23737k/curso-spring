package dominio.informes;

import org.springframework.stereotype.Component;

@Component
public class InformeTrimestre1 implements CreacionDeInforme {

	@Override
	public String getInforme() {
		return "esta es la presentacion del informe del trimestre 1";
	}

}
