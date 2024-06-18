package curso_spring.exceptions;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ObjectNotValidException extends RuntimeException {
  private Set<String> errorMessages;
}
