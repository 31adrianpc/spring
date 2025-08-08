package com.apc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.apc.dto.CategoriaDTO;
import com.apc.repository.CategoriaRepository;
import com.apc.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return categoriaRepository.listarCategorias();
    }

    @Override
    public CategoriaDTO obtenerCategoria(Integer idCategoria) {
        return categoriaRepository.obtenerCategoria(idCategoria);
    }
    
}
