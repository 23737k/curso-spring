package dominio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String description;
  @ManyToMany
  @JoinTable(name = "authors_courses",
      joinColumns = {@JoinColumn(name = "course_id")},
      inverseJoinColumns = {@JoinColumn(name = "author_id")}
      )
  private List<Author> authors;

  @OneToMany(mappedBy = "course")
  private List<Section> sections;


}

/*
*
*   Relación OneToMany
*   1) la anotación OneToMany hará que Hibernate automáticamente cree una tabla intermedia entre las dos entidades. Y esto es debido a que Hibernate no sabe que
*      la entidad Section es la encargada de mapear la relación mediante la JoinColumn, por lo tanto se asegura que ambas entidades estén relacionadas mediante esta
*       tabla intermedia.
*      Para evitar que esto ocurra, debemos indicarle a Hibernate en la entidad @OneToMany, que la relación entre ambas tablas ya ha sido mapeada.
*      Esto lo haremos con mappedBy = "" donde le indicaremos el nombre de la propiedad que va a mapear la relación (JoinColumn).
*      En este caso mappedBy="course" -> "course" es el nombre de la propiedad @ManyToOne de la entidad Section. Ver Section.java
*
*
*
*
*
*
*
* */