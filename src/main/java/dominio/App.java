package dominio;

import dominio.entities.Author;
import dominio.repositories.AuthorRepository;
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
//	@Bean
//	public CommandLineRunner commandLineRunner(AuthorRepository repository) {
//		return args -> {
//			Author author = new Author();
//			author.builder().age(29).
//			;
//		}
//	}

	
}
