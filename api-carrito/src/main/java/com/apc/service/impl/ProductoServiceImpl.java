package com.apc.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apc.dto.ProductoDTO;
import com.apc.mapper.ProductoMapper;
import com.apc.repository.ProductoRepository;
import com.apc.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    private ProductoMapper productoMapper = Mappers.getMapper(ProductoMapper.class);

    @Override
    public List<ProductoDTO> listarProductos() {
        return productoMapper.convertirEntityADTO(productoRepository.findAll());
    }

    @Override
    public ProductoDTO obtenerProducto(Integer idProducto) {
        return productoMapper.convertirEntityADTO(productoRepository.findById(idProducto).orElse(null));
    }
    
}
