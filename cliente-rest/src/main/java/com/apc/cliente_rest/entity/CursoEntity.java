package com.apc.cliente_rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/* Construimos la clase a partir del contrato de la API */
public class CursoEntity {
    private Integer idCurso;
    private String nombreCurso;
    private String fechaInicio;
    private Integer alumnosMinimo;
    private Integer alumnosActual;
    private Integer estado;
}
