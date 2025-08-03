package com.apc.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.apc.entity.UsuarioEntity;
import com.apc.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GenerarTokenFilter extends AbstractAuthenticationProcessingFilter{
    
    protected GenerarTokenFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        
                InputStream body = request.getInputStream();
                UsuarioEntity user = new ObjectMapper().readValue(body, UsuarioEntity.class);
                // Acá sigue todo el flujo de autenticación: ProviderManaer, DaoAuthenticationProvider, UserDetailsService -> Authentication
                return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                        user.getUser(),
                        user.getPassword(),
                        Collections.emptyList()
                    )
                );

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
                JwtUtil.generarToken(response,  authResult);
    }
}
