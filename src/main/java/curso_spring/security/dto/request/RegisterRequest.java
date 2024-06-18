package curso_spring.security.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
  @NotNull(message="Firstname must not be null")
  @NotEmpty(message="Firstname must not be empty")
  private String firstname;
  @NotNull(message="Lastname must not be null")
  @NotEmpty(message="Lastname must not be empty")
  private String lastname;
  @NotNull(message="Email must not be null")
  @NotEmpty(message="Email must not be empty")
  @Email(message = "Email field has an invalid format")
  private String email;
  @NotNull(message="Password must not be null")
  @NotEmpty(message="Password must not be empty")
  private String password;
}
