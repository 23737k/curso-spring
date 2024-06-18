package curso_spring.validation;

import curso_spring.exceptions.ObjectNotValidException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ObjectValidator<T> {
  private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
  private final Validator validator = validatorFactory.getValidator();

  public void validate(T object){
    Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
    var errorMessages = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(
        Collectors.toSet());
    if(!constraintViolations.isEmpty()){
      throw new ObjectNotValidException(errorMessages);
    }
  }

}
