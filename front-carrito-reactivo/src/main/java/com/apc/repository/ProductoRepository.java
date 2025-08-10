package com.apc.repository;

import com.apc.dto.ProductoDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoRepository {
    public Flux<ProductoDTO> listarProductos();
    public Mono<ProductoDTO> obtenerProducto(Integer idProducto);
}
