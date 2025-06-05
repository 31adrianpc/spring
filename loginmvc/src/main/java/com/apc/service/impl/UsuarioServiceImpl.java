package com.apc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apc.entity.UsuarioEntity;
import com.apc.repository.UsuarioRepository;
import com.apc.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.validarUsuario(usuario);
    }
    
}
