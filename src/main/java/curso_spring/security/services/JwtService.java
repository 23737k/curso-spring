package curso_spring.security.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Este servicio se encargará de manipular el jwt y brindarnos todos los datos que necesitemos de este.
 */

@Service
public class JwtService {
  @Value("${spring.application.security.jwt.secret-key}")
  private String secretKey;
  @Value("${spring.application.security.jwt.expiration}")
  private long expiration;

  public String extractUserEmail(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public String generateToken(UserDetails userDetails) {
    return  generateToken(new HashMap<>(), userDetails);
  }

  public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
    return Jwts
        .builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + expiration))
        .signWith(getSignedKey(), SignatureAlgorithm.HS256)
        .compact();
  }


  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractClaims(token);
    return claimsResolver.apply(claims);
  }


  private Claims extractClaims(String token) {
    return Jwts.parserBuilder().setSigningKey(getSignedKey()).build().parseClaimsJws(token).getBody();
  }

  private Key getSignedKey() {
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public boolean validateToken(String token, UserDetails userDetails) {
    final String username = extractUserEmail(token);
    return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
  }

  public boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }
  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }
}