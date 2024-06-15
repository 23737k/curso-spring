package curso_spring.services;

import curso_spring.config.auth.AuthenticationRequest;
import curso_spring.config.auth.AuthenticationResponse;
import curso_spring.config.auth.RegisterRequest;
import curso_spring.dominio.Role;
import curso_spring.dominio.repositories.UserRepository;
import curso_spring.dominio.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest r) {
    var user = User.builder()
        .firstname(r.getFirstname())
        .lastname(r.getLastname())
        .email(r.getEmail())
        .password(passwordEncoder.encode(r.getPassword()))
        .role(Role.USER)
        .build();
    userRepository.save(user);
    var jwt = jwtService.generateToken(user);

    return AuthenticationResponse.builder()
        .token(jwt)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
    var jwt = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwt)
        .build();
  }
}
