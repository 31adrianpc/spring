package com.apc.repository;

import java.util.List;

import com.apc.dto.ProductoDTO;

public interface ProductoRepository {
    public List<ProductoDTO> listarProductos();
    public ProductoDTO obtenerProducto(Integer idProducto);
}
