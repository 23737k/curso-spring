package dominio.repositories;

import dominio.entities.Author;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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

  @Transactional
  @Modifying
  @Query("update Author a set a.age = :age where a.id = :id")
  void updateAge(int id, int age);

  @Transactional
  @Modifying
  @Query("update Author a set a.age = :age")    // a diferencia del anterior modifica el campo edad de todos los registros
  void updateAuthorsAge(int age);




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
*                     Nota: findByAll tiene el mismo comportamiento
*
* Queries: se pueden definir métodos que ejecuten queries sql con la anotación @Query. Sin embargo esta anotación sólo soporta SELECTs
*   @Modifying: Esta anotación se agrega para poder potenciar las queries de tal forma que podamos ejecutar también: UPDATE, INSERT, DELETE e incluso DDL
*   @Transactional: Debemos agregar esta anotación para que Spring ejecute este método dentro de una transacción. De otra manera nos saldrá una excepción
*                   Los métodos de la interfaz CRUD (findBy... updateBy... deleteBy... etc) todos son @Transactional por defecto.
*                   Sin embargo si agregamos nuestras propias queries debemos indicarles que los ejecute en una transacción.
*
*
*
*
*
* */
