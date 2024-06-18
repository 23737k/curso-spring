package curso_spring.security.services;

import curso_spring.exceptions.UserAlreadyExistsException;
import curso_spring.security.dto.request.AuthenticationRequest;
import curso_spring.security.dto.response.AuthenticationResponse;
import curso_spring.security.dto.request.RegisterRequest;
import curso_spring.dominio.user.Role;
import curso_spring.dominio.user.User;
import curso_spring.services.UserService;
import curso_spring.validation.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final ObjectValidator<RegisterRequest> validator;

  public AuthenticationResponse register(RegisterRequest userRequest) {
    validator.validate(userRequest);
    if(userService.exist(userRequest.getEmail()))
      throw new UserAlreadyExistsException("El email ya se encuentra registrado");
    var user = User.builder()
        .firstname(userRequest.getFirstname())
        .lastname(userRequest.getLastname())
        .email(userRequest.getEmail())
        .password(passwordEncoder.encode(userRequest.getPassword()))
        .role(Role.USER)
        .build();
    userService.save(user);
    var jwt = jwtService.generateToken(user);

    return AuthenticationResponse.builder()
        .token(jwt)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    var user = userService.loadUserByUsername(request.getEmail());
    var jwt = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwt)
        .build();
  }
}
