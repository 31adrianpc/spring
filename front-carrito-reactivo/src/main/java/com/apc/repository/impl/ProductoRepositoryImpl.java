package com.apc.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import com.apc.dto.ProductoDTO;
import com.apc.repository.ProductoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository{
    
    private WebClient webClient;

    @Value("${url.api}")
    private String URL_API;

    public ProductoRepositoryImpl() {
        this.webClient = WebClient.create();
    }

    @Override
    public Flux<ProductoDTO> listarProductos() {
        return webClient.get()
                .uri(URL_API + "/productos")
                .retrieve()
                .bodyToFlux(ProductoDTO.class);
    }

    @Override
    public Mono<ProductoDTO> obtenerProducto(Integer idProducto) {
        return webClient.get()
                .uri(URL_API + "/productos/{id}", idProducto)
                .retrieve()
                .bodyToMono(ProductoDTO.class);
    }
}
