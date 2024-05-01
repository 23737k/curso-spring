package dominio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "first-name")
  private String firstName;

  @Column(name = "last-name")
  private String lastName;

  @Column(nullable = false, unique = true)      //no puede ser nulo. En el futuro no se podran hacer inserts que tengan un mail que ya existe
  private String email;

  private int age;

  @Column( updatable = false,nullable = false)  //Por defecto es true. Esto se utiliza en campos que no quiero que se actualicen, por ej la fecha de creacion.
  private LocalDate createdAt;

  @Column(insertable = false)       //Por defecto es true. Esto hace que no se pueda insertar, es decir cuando se haga el primer insert de una fila, este campo
  private LocalDate lastModified;   //sera nulo. Solo puede ser actualizado, ya que la propiedad updatable es true por defecto.

  @ManyToMany(mappedBy = "authors")
  private List<Course> courses;


}

/*
 * Siempre para el id utilizamos wrappers en lugar de datos primitivos. En este caso elegimos utilizar Integer en lugar de int.
 *   ¿Por que? Esto es debido a que una variable de tipo int tiene un valor por defecto de 0, en cambio Integer tiene un valor por defecto de null
 *   Si nuestra variable es int, entonces tendrá un valor por defecto de 0, por lo cual cuando la persistamos Hibernate intentará buscar un registro de
 *   la tabla con el id=0 para hacerla coincidir.
 *   Si en cambio una variable es de tipo Integer, Hibernate entenderá que queremos persistir un nuevo elemento en la bd y le asignará un nuevo id.
 *
 *  Si uso LocalDateTime me tira error. Dont know why. Usar LocalDate
 *
 *  Relaciones ManyToMany:
 *    1) Agregamos la anotation correspondiente en ambos entidades
 *    2) Ahora debemos definir cuál entidad será la dueña de la relación.
 *       Esto se hace dado que la relación es bidireccional (ambas clases tienen una referencia una de la otra)
 *       La entidad dueña de la relación será aquella que tenga más control sobre la tabla intermedia que representa la relación many-to-many.
 *       Esto significa que esta entidad podría tener más información o funcionalidades asociadas con la relación en comparación con la otra entidad.
 *    3) La otra entidad que no es dueña, será la inversa de la relación.
 *    4) Para indicar estos dos últimos puntos, debemos agregar en la entidad que es inversa de la relación:  mappedBy = ""
 *       donde irá el nombre de la propiedad de la entidad que es dueña
 *       En este ejemplo, designamos a Course como dueño de la relación y a Author como inverso de la relación.
 *    5) Adicionalmente podríamos agregar en la entidad dueña de la relación, @JoinTable. Esto es opcional y se utiliza para modificar el nombre de la tabla
 *       intermedia o el de sus campos. Ver Course.java
 *
 *
 *
 * */