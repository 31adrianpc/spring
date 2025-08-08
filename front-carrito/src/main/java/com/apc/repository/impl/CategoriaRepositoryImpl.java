package com.apc.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.apc.dto.CategoriaDTO;
import com.apc.repository.CategoriaRepository;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {
    
    private RestTemplate restTemplate;

    @Value("${url.api}")
    private String URL_API;

    public CategoriaRepositoryImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return restTemplate.getForObject(URL_API + "/categorias", List.class);
    }

    @Override
    public CategoriaDTO obtenerCategoria(Integer idCategoria) {
        return restTemplate.getForObject(URL_API + "/categorias/" + idCategoria, CategoriaDTO.class);
    }
}
