package com.apc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/css/**", "/js/**", "/images/**", "/vendor/**", "/fonts/**").permitAll(); // Recursos estáticos permitidos
                auth.requestMatchers("/otrasRutas/**").permitAll(); // Cualquier usuario puede acceder
                auth.requestMatchers("/admin/**").hasRole("ADMIN"); // Solo usuarios con rol ADMIN
                auth.anyRequest().authenticated(); // Cualquier usuario autenticado
            }).formLogin(
                login -> {
                    login.loginPage("/login");
                    login.usernameParameter("txtUser");
                    login.passwordParameter("txtPassword");
                    boolean forzarRedireccion = false; // Tras un login exitoso, redirigir a la página protegida deseada, bloqueada inicialmente por el login
                    login.defaultSuccessUrl("/paginaPrincipal", forzarRedireccion);
                    login.permitAll();
                }
            );
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
