package com.apc.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.apc.dto.CategoriaDTO;
import com.apc.entity.CategoriaEntity;

@Mapper
public interface CategoriaMapper {
    public CategoriaEntity convertirDTOAEntity(CategoriaDTO categoriaDTO);
    public CategoriaDTO convertirEntityADTO(CategoriaEntity categoriaEntity);
    public List<CategoriaEntity> convertirDTOAEntity(List<CategoriaDTO> categoriaDTOs);
    public List<CategoriaDTO> convertirEntityADTO(List<CategoriaEntity> categoriaEntities);
}
