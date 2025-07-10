package com.apc.apim.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    /*
     * Con @LoadBalanced, indicamos a Spring Cloud LoadBalancer que cada vez que RestTemplate
     * realice una petición a una URL con nombre lógico (por ejemplo: http://apimatricula/api/v1/cursos),
     * lo consulte con Eureka para obtener las instancias disponibles.
     * Luego, LoadBalancer selecciona una utilizando balanceo de carga (por defecto, round-robin).
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new  RestTemplate();
    }
}
