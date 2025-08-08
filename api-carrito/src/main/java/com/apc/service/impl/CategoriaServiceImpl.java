package com.apc.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apc.dto.CategoriaDTO;
import com.apc.mapper.CategoriaMapper;
import com.apc.repository.CategoriaRepository;
import com.apc.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    private CategoriaMapper categoriaMapper = Mappers.getMapper(CategoriaMapper.class);

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return categoriaMapper.convertirEntityADTO(categoriaRepository.findAll());
    }

    @Override
    public CategoriaDTO obtenerCategoria(Integer idCategoria) {
        return categoriaMapper.convertirEntityADTO(categoriaRepository.findById(idCategoria).orElse(null));
    }

    
    
}
