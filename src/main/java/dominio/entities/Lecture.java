package dominio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class Lecture {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "section_id")
  private Section section;

  @OneToOne
  @JoinColumn(name = "resource_id")
  private Resource resource;

}
/*
*   Relación OneToOne:
*     Puede ser unidireccional o bidireccional.
*     1) unidireccional: únicamente hay que colocar @OneToOne en la propiedad. Esto creará una columna con la FK de la otra tabla
*     2) bidireccional:  primero hacemos que la relación sea bidireccional agregando una referencia en la otra entidad. Ver Resource.java
*                        Luego agregamos lo mismo que en el paso 1)
*/