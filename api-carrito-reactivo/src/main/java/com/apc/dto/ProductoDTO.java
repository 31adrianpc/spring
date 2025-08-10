package com.apc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Producto", description = "Entity de producto")
public class ProductoDTO {
    private Integer idProducto;
    private String nombreProducto;
    private CategoriaDTO categoria;
    private Double precioProducto;
    private Double precioAnteriorProducto;
    private Integer nuevoProducto;
    private String imagenProducto;
}
