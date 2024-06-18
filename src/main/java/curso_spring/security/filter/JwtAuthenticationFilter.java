package curso_spring.security.filter;

import curso_spring.security.services.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

//Creamos el JwtAuthFilter que tiene que extender OncePerRequestFilter para indicarle a Spring que debe estar activo cada vez que se haga una request
//Es decir que con cada request del usuario se disparará este JwtAuthFilter y hará su trabajo
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  //Este servicio se encargará de manipular el jwt y brindarnos todos los datos (claims) que necesitemos de este.
  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;

  //Recibe las request y response, lo que le permite interceptarlas y por ejemplo modificarlas.
  //Ademas recibe un FilterChain, que utiliza el patron Chain of Responsibility. Es decir cuando se llame a doFilterInternal, se llamará al próximo filtro y este al
  //siguiente y asi sucesivamente.
  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                  @NonNull FilterChain filterChain) throws ServletException, IOException {

    if(request.getServletPath().contains("/api/auth")){
      filterChain.doFilter(request,response);
      return;
    }

    //Obtenemos el Authorization Header de la request
    final String authHeader = request.getHeader(AUTHORIZATION);
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

    try {
      userEmail = jwtService.extractUserEmail(jwt);

      if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
        if(jwtService.validateToken(jwt, userDetails))
        {
          UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
          authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(authToken);
        }
      }
      filterChain.doFilter(request, response);
    } catch (ExpiredJwtException e) {
      // Manejo específico de la excepción ExpiredJwtException
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.setContentType("application/json");
      response.getWriter().write("{\"error\": \"JWT Token expired. Please, authenticate again to get a new token.\"}");
    }
  }


}
