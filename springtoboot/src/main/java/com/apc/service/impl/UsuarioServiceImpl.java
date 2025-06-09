/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apc.service.impl;

import com.apc.entity.UsuarioEntity;
import com.apc.repository.UsuarioRepository;
import com.apc.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity obtenerUsuarioPorId(Integer idUsuario) {
        return this.usuarioRepository.obtenerUsuarioPorId(idUsuario);
    }

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuarioEntity) {
        return this.usuarioRepository.validarUsuario(usuarioEntity);
    }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return this.usuarioRepository.listarUsuarios();
    }

    @Override
    public void insertarUsuario(UsuarioEntity usuarioEntity) {
        this.usuarioRepository.insertarUsuario(usuarioEntity);
    }

    @Override
    public void actualizarUsuario(UsuarioEntity usuarioEntity) {
        this.usuarioRepository.actualizarUsuario(usuarioEntity);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        this.usuarioRepository.eliminarUsuario(idUsuario);
    }
    
}
