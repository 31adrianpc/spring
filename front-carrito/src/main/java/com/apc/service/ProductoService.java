package com.apc.service;

import java.util.List;

import com.apc.dto.ProductoDTO;

public interface ProductoService {
    public List<ProductoDTO> listarProductos();
    public ProductoDTO obtenerProducto(Integer idProducto);
}
