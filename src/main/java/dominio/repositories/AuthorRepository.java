package dominio.repositories;

import dominio.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


}

/*
* JpaRepository<T,ID>   ->   donde T es la clase de la entidad y ID es el tipo del id.
*
* */
