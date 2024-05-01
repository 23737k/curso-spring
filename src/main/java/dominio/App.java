package dominio;

import com.github.javafaker.Faker;
import dominio.entities.Author;
import dominio.repositories.AuthorRepository;
import java.time.LocalDate;
import java.util.Locale;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class,args);
		System.out.println("Executed Main Application");
	}


	// Esto nos permite ejecutar código al inicio de la aplicación.
	//DESCOMENTAR PARA INICIALIZAR BD

//	@Bean
//	public CommandLineRunner commandLineRunner(AuthorRepository repository) {				//Le indicamos los argumentos que necesita
//		return args -> {
////			Faker faker = new Faker(new Locale("es","AR"));				// creo un Faker que se encargará de crear datos falsos
////			for (int i = 0; i<10 ; i++) {
////				Author author = Author.builder()
////						.firstName(faker.name().firstName())
////						.lastName(faker.name().lastName())
////						.age(faker.number().numberBetween(10,100))
////						.email(faker.internet().emailAddress())
////						.createdAt(LocalDate.now())
////						.build();
////				repository.save(author);	//persistimos el autor
////			}
//
//			//repository.updateAge(161,26);
//		};
//	}




}




