package curso_spring.config;

import curso_spring.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

//Creamos el JwtAuthFilter que tiene que extender OncePerRequestFilter para indicarle a Spring que debe estar activo cada vez que se haga una request
//Es decir que con cada request del usuario se disparará este JwtAuthFilter y hará su trabajo
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  //Este servicio se encargará de manipular el jwt y brindarnos todos los datos que necesitemos de este.
  private final JwtService jwtService;


  //Recibe las request y response, lo que le permite interceptarlas y por ejemplo modificarlas.
  //Ademas recibe un FilterChain, que utiliza el patron Chain of Responsibility. Es decir cuando se llame a doFilterInternal, se llamará al próximo filtro y este al
  //siguiente y asi sucesivamente.
  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                  @NonNull FilterChain filterChain) throws ServletException, IOException {

    //Obtenemos el Authorization Header de la request
    final String authHeader = request.getHeader("Authorization");
    final String jwt;       //aqui guardaremos el jwt
    final String userEmail;

    //Si el header no se encuentra o su valor no es valido (debe empezar con "Bearer ")
    if (authHeader == null || ! authHeader.startsWith("Bearer ")) {
     //le paso la request y response al siguiente filtro
      filterChain.doFilter(request, response);
      return;
    }
    //Si el header existe y su valor es válido, obtengo del mismo el token.
    jwt = authHeader.substring(7);
    //obtenemos
    userEmail = jwtService.extractUserEmail(jwt);
  }
}