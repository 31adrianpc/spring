package com.apc.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.apc.dto.ProductoDTO;
import com.apc.entity.ProductoEntity;

@Mapper
public interface ProductoMapper {
    public ProductoEntity convertirDTOAEntity(ProductoDTO productoDTO);
    public ProductoDTO convertirEntityADTO(ProductoEntity productoEntity);
    public List<ProductoEntity> convertirDTOAEntity(List<ProductoDTO> productoDTOs);
    public List<ProductoDTO> convertirEntityADTO(List<ProductoEntity> productoEntities);
}
