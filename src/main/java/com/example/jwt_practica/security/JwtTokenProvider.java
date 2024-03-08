package com.example.jwt_practica.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
  private static final String SECRET_KEY = "7A33E3C6BC5E5CF99562D7CE46EDA";
  public String generateToken(Authentication auth) {
    String userName = auth.getName();
    Date actualTime = new Date();
    Date tokenExp = new Date(actualTime.getTime() + SecurityConstants.JWT_EXPIRATION_TOKEN);

    String token = Jwts.builder()
      .setSubject(userName)
      .setIssuedAt(new Date())
      .setExpiration(tokenExp)
      .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_FIRMA)
      .compact();
    return token;
  }

  public Claims getUsernameFromJwt(String token) {
    return Jwts
      .parserBuilder()
      .setSigningKey(getSigningKey())
      .build()
      .parseClaimsJwt(token)
      .getBody();
  }

  private Key getSigningKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
