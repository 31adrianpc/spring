package com.apc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apc.dto.ProductoDTO;
import com.apc.repository.ProductoRepository;
import com.apc.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProductos() {
        return productoRepository.listarProductos();
    }

    @Override
    public ProductoDTO obtenerProducto(Integer idProducto) {
        return productoRepository.obtenerProducto(idProducto);
    }
    
}
