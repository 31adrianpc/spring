package com.apc.util;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtUtil {

    private static final Key SECRET_KEY = Keys.hmacShaKeyFor("clave-super-secreta-de-mas-de-32-caracteres".getBytes());
    

    public static void generarToken(HttpServletResponse res, Authentication auth) {
        List<String> roles = auth.getAuthorities().stream()
                                                  .map(GrantedAuthority::getAuthority)
                                                  .toList();
        String token = Jwts.builder()
                        .subject(auth.getName())
                        .claim("roles", roles)
                        .expiration(new Date(System.currentTimeMillis() + 600000))
                        .signWith(SECRET_KEY)
                        .compact();
        res.addHeader("Authorization", "Bearer " + token);
    }
    

    public static Authentication leerToken(HttpServletRequest request) {
        String user;
        String token = request.getHeader("Authorization");
        List<GrantedAuthority> authorities = null;
        if (token != null) {
            try {
                Claims claims = Jwts.parser()
                           .verifyWith((SecretKey)SECRET_KEY)
                           .build()
                           .parseSignedClaims(token.replace("Bearer", "").trim())
                           .getPayload();
                user = claims.getSubject();
                @SuppressWarnings("unchecked")
                List<String> roles = claims.get("roles", List.class);
                authorities = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            } catch (Exception ex) {
                System.out.println("Ocurrio un erro en:"+ex.getMessage());
                user = null;
            }
            return user != null ? new UsernamePasswordAuthenticationToken(user, null, authorities) : null;
        }
         return null;
    }
}
