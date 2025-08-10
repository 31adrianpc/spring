package com.apc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apc.dto.ProductoDTO;
import com.apc.repository.ProductoRepository;
import com.apc.service.ProductoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Flux<ProductoDTO> listarProductos() {
        return productoRepository.listarProductos();
    }

    @Override
    public Mono<ProductoDTO> obtenerProducto(Integer idProducto) {
        return productoRepository.obtenerProducto(idProducto);
    }
    
}
