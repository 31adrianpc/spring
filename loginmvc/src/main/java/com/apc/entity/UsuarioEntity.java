package com.apc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
    private Integer idUsuario;
    private String user;
    private String password;
    private String nombreApellido;
    private Integer estado;
}
