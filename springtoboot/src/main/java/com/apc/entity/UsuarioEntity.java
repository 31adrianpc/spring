/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apc.entity;

import java.util.Base64;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data //getters and setters
public class UsuarioEntity {
    private Integer idUsuario;
    @Size(min = 3, max = 40, message = "El username debe tener entre 3 y 30 caracteres")
    private String user;
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombreApellido;
    private byte[] foto;
    private String estado;
    private String fotoBase64;
  
    public String getFotoBase64() {
        return Base64.getEncoder().encodeToString(foto);
    }
    
}
