package com.apc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apc.entity.UsuarioEntity;
import com.apc.repository.UsuarioRepository;
import com.apc.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioRepository.findByEstado(1);
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        UsuarioEntity usuarioTmp = obtenerUsuario(usuario.getIdUsuario());
        if (!passwordEncoder.matches(usuario.getPassword(), usuarioTmp.getPassword())) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity eliminarUsuario(Integer idUsuario) {
        UsuarioEntity usuario = obtenerUsuario(idUsuario);
        if (usuario != null) {
            usuario.setEstado(0);
            usuarioRepository.save(usuario);
        }
        return usuario;
    }
    
}
