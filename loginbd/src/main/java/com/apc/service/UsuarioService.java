package com.apc.service;

import java.util.List;

import com.apc.entity.UsuarioEntity;

public interface UsuarioService {

    public UsuarioEntity validarUsuario(String user, String password);
    public List<UsuarioEntity> listarUsuarios();
    public UsuarioEntity obtenerUsuario(Integer idUsuario);
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario);
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario);
    public UsuarioEntity eliminarUsuario(Integer idUsuario);
}