package com.apc.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.apc.dto.ProductoDTO;
import com.apc.repository.ProductoRepository;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository{
    
    private RestTemplate restTemplate;

    @Value("${url.api}")
    private String URL_API;

    public ProductoRepositoryImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<ProductoDTO> listarProductos() {
        return restTemplate.getForObject(URL_API + "/productos", List.class);
    }

    @Override
    public ProductoDTO obtenerProducto(Integer idProducto) {
        return restTemplate.getForObject(URL_API + "/productos/" + idProducto, ProductoDTO.class);
    }
}
