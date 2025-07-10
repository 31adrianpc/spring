package com.apc.apim.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    /*
     * Con @LoadBalanced, indicamos a Spring Boot que cada vez que RestTemplate
     * realice una petición a una URL con un hostname que no sea real, lo consulte
     * con Eureka. Por ejemplo: http://apimatricula/api/v1/cursos.
     * En cada llamanda, Ribbon consulta a Eureka por las instancias y escoge una,
     * utilizando balanceo de carga (por defecto round-robin).
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new  RestTemplate();
    }
}
