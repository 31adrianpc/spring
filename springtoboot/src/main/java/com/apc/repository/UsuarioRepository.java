/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apc.repository;

import com.apc.entity.UsuarioEntity;
import java.util.List;

public interface UsuarioRepository {
    public UsuarioEntity obtenerUsuarioPorId(Integer idUsuario);
    public UsuarioEntity validarUsuario(UsuarioEntity usuarioEntity);
    public List<UsuarioEntity> listarUsuarios();
    public void insertarUsuario(UsuarioEntity usuarioEntity);
    public void actualizarUsuario(UsuarioEntity usuarioEntity);
    public void eliminarUsuario(Integer idUsuario);
}
