package com.apc.repository;

import java.util.List;

import com.apc.dto.CategoriaDTO;

public interface CategoriaRepository {
    public List<CategoriaDTO> listarCategorias();
    public CategoriaDTO obtenerCategoria(Integer idCategoria);
}
