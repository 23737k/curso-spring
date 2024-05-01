package dominio.repositories;

import dominio.entities.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

  List<Author> findByFirstName(String firstName);

  // select * from author where first_name = 'fistName'   -> IGNORA SI ES MAYÚSCULA O MINÚSCULA
  List<Author> findByFirstNameIgnoreCase(String firstName);

  // select * from author where first_name like '%fistName%'   ->   BUSCA AQUELLOS QUE CONTENGAN LA PALABRA ESPECIFICADA
  List<Author> findByFirstNameContainingIgnoreCase(String firstName);

  // select * from author where first_name like 'fistName%'   ->   BUSCA AQUELLOS QUE EMPIECEN CON LA PALABRA ESPECIFICADA
  List<Author> findByFirstNameStartingWithIgnoreCase(String firstName);

  // select * from author where first_name like '%fistName'   ->   BUSCA AQUELLOS QUE TERMINEN CON LA PALABRA ESPECIFICADA
  List<Author> findByFirstNameEndsWithIgnoreCase(String firstName);

  // select * from author where first_name in ('kenti', 'pedro')   ->   BUSCA AQUELLOS QUE SE ENCUENTREN EN LA LISTA ESPECIFICADA
  List<Author> findByFirstNameInIgnoreCase(List<String> firstNames);

}

/*
* JpaRepository<T,ID> =>   donde T es la clase de la entidad y ID es el tipo del id.
*
*
* Query Methods: son métodos que se crean dinámicamente. Realizan consultas personalizadas.
*
*   findBy[property]: Se colocan la/s propiedad/es. Podemos utilizar operadores lógicos como AND y OR. El nombre de las propiedades empiezan con Mayúscula
*                     Hay un MONTÓN de métodos posibles para todos los campos. El menú intellisense de Spring nos proporciona todas las opciones posibles
*                     Sin embargo, hay muchos métodos autogenerados que no aplican siempre. Por ej: findByPropertyAfter/Before/Between, etc se utiliza para
*                     fechas. No funcionará por ejemplo para un campo de tipo String o int.
*
*       Nota: findByAll tiene el mismo comportamiento
*
*
*
*
*
*
* */
