package com.apc.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apc.dto.ProductoDTO;
import com.apc.mapper.CategoriaMapper;
import com.apc.mapper.ProductoMapper;
import com.apc.repository.CategoriaRepository;
import com.apc.repository.ProductoRepository;
import com.apc.service.ProductoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    private ProductoMapper productoMapper = Mappers.getMapper(ProductoMapper.class);

    private CategoriaMapper categoriaMapper = Mappers.getMapper(CategoriaMapper.class);

    @Override
    public Flux<ProductoDTO> listarProductos() {
        return productoRepository.findAll().flatMap(producto -> categoriaRepository.findById(producto.getIdCategoria())
                                                                                    .map(categoria -> {
                                                                                        ProductoDTO productoDTO = productoMapper.convertirEntityADTO(producto);
                                                                                        productoDTO.setCategoria(categoriaMapper.convertirEntityADTO(categoria));
                                                                                        return productoDTO;
                                                                                    }));
    }

    @Override
    public Mono<ProductoDTO> obtenerProducto(Integer idProducto) {
        return productoRepository.findById(idProducto).flatMap(producto -> categoriaRepository.findById(producto.getIdCategoria())
                                                                                    .map(categoria -> {
                                                                                        ProductoDTO productoDTO = productoMapper.convertirEntityADTO(producto);
                                                                                        productoDTO.setCategoria(categoriaMapper.convertirEntityADTO(categoria));
                                                                                        return productoDTO;
                                                                                    }));
    }
    
}
