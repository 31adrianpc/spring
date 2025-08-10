package com.apc.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import com.apc.dto.CategoriaDTO;
import com.apc.repository.CategoriaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {
    
    private WebClient webClient;

    @Value("${url.api}")
    private String URL_API;

    public CategoriaRepositoryImpl() {
        this.webClient = WebClient.create();
    }

    @Override
    public Flux<CategoriaDTO> listarCategorias() {
        return webClient.get()
                .uri(URL_API + "/categorias")
                .retrieve()
                .bodyToFlux(CategoriaDTO.class);
    }

    @Override
    public Mono<CategoriaDTO> obtenerCategoria(Integer idCategoria) {
        return webClient.get()
                .uri(URL_API + "/categorias/{id}", idCategoria)
                .retrieve()
                .bodyToMono(CategoriaDTO.class);
    }
}
