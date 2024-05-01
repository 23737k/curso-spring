package dominio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Section {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private int sectionOrder;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;
}


/*
*   Relación ManyToOne:
*     1)Siempre que utilicemos este tipo de relación, Hibernate automáticamente creará una columna adicional que será la JoinColumn entre ambas entidades.
*       Esta columna contendrá la FK de la tabla padre. En este caso, se creará una tabla Section que tendrá una columna adicional llamada por defecto
*       course_id que contendrá la FK a la tabla Course. Opcionalmente podemos cambiar el nombre de esta columna mediante @JoinColumn(name="").
*       Sin embargo, esto no evitará que se cree una tabla intermedia entre ambas entidades. Ver Couse.java
*
*
* */