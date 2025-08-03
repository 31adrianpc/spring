package com.apc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SecurityConfig {
    
    @Autowired
    private AuthenticationConfiguration authConfig;

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll();
                auth.requestMatchers("/api/v1/usuarios/**").hasRole("ADMIN");
                auth.requestMatchers("/api/v1/cursos/**").hasAnyRole("ADMIN", "USER");
                auth.anyRequest().authenticated();
            })
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(new GenerarTokenFilter("/api/v1/security", authenticationManagerBean()), UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(new LeerTokenFilter(), UsernamePasswordAuthenticationFilter.class); // No requerimos crear sesiones en el servidor
            
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
