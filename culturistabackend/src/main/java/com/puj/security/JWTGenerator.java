package com.puj.security;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTGenerator {
    public static final Long EXPIRATION_TIME = 86400000L;
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(Authentication authentication) {
       String usuario = authentication.getName(); 
       Date currentDate = new Date();
       Date expirationDate = new Date(currentDate.getTime() + EXPIRATION_TIME);

       String token = Jwts.builder().setSubject(usuario)
       .setIssuedAt(currentDate)
       .setExpiration(expirationDate)
       .signWith(KEY, SignatureAlgorithm.HS256)
       .compact();

       return token;
    } 
    
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try{
            Jwts.parserBuilder()    
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
