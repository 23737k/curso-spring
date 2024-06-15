package curso_spring.dominio.user;

import curso_spring.dominio.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  @Enumerated(EnumType.STRING)
  private Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  //Note: cuando implementamos los métodos de UserDetails, aparecerán todos menos el de getPassword(), debido a que Lombok ya lo crea ya que tenemos un atributo llamado password
  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email; //en nuestro caso elegimos el email del usuario como el username
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;  // Ponemos true para que los usuarios se puedan conectar
  }

  @Override
  public boolean isAccountNonLocked() {
    return true; //Ponemos true para que los usuarios se puedan conectar
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true; //idem arriba
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
