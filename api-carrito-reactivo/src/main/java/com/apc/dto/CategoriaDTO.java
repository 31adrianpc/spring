package com.apc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Categoria", description = "Entity de categoria")
public class CategoriaDTO {
    private Integer idCategoria;
    private String nombreCategoria;
}
