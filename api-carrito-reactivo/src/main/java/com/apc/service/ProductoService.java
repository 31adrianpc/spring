package com.apc.service;

import com.apc.dto.ProductoDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {
    public Flux<ProductoDTO> listarProductos();
    public Mono<ProductoDTO> obtenerProducto(Integer idProducto);
}
