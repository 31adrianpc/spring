package com.apc.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apc.dto.CategoriaDTO;
import com.apc.mapper.CategoriaMapper;
import com.apc.repository.CategoriaRepository;
import com.apc.service.CategoriaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    private CategoriaMapper categoriaMapper = Mappers.getMapper(CategoriaMapper.class);

    @Override
    public Flux<CategoriaDTO> listarCategorias() {
        return categoriaRepository.findAll().map(categoriaMapper::convertirEntityADTO);
    }

    @Override
    public Mono<CategoriaDTO> obtenerCategoria(Integer idCategoria) {
        return categoriaRepository.findById(idCategoria).map(categoriaMapper::convertirEntityADTO);
    } 
}
