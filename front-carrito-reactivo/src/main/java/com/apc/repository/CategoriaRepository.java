package com.apc.repository;

import com.apc.dto.CategoriaDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoriaRepository {
    public Flux<CategoriaDTO> listarCategorias();
    public Mono<CategoriaDTO> obtenerCategoria(Integer idCategoria);
}
