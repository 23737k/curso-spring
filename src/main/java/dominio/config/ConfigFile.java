package dominio.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("dominio") //le indicamos en que paquete debe escanear Spring en busca de annotations
@PropertySource("classpath:datosEmpresa.propiedades")
public class ConfigFile {
}
