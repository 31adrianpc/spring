package com.apc.service;

import java.util.List;

import com.apc.dto.CategoriaDTO;

public interface CategoriaService {
    public List<CategoriaDTO> listarCategorias();
    public CategoriaDTO obtenerCategoria(Integer idCategoria);
}
