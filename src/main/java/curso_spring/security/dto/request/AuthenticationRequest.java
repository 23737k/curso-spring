package curso_spring.security.dto.request;

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
public class AuthenticationRequest {
  @NotNull(message = "Email must not be empty or null")
  @NotEmpty(message = "Email must not be empty or null")
  private String email;
  @NotNull(message = "Password must not be empty or null")
  @NotEmpty(message = "Password must not be empty or null")
  private String password;
}
