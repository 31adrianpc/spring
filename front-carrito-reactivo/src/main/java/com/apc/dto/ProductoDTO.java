package com.apc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Integer idProducto;
    private String nombreProducto;
    private CategoriaDTO categoria;
    private Double precioProducto;
    private Double precioAnteriorProducto;
    private Integer nuevoProducto;
    private String imagenProducto;
}
