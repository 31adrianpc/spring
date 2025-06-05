package com.apc.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.apc.entity.UsuarioEntity;
import com.apc.repository.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{
    private List<UsuarioEntity> listaUsuarios;

    public UsuarioRepositoryImpl(){
        listaUsuarios = List.of(
            new UsuarioEntity(1, "admin", "admin", "Administrador", 1),
            new UsuarioEntity(2, "user", "user", "usuario", 1)
        );
    }

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
        return listaUsuarios.stream()
            .filter(u -> u.getUser().equals(usuario.getUser()) && u.getPassword().equals(usuario.getPassword()))
            .findFirst()
            .orElse(null);
    }
}
