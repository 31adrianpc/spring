package com.apc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apc.entity.UsuarioEntity;
import com.apc.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioRepository.findByUserAndEstado(username, 1);
        List<GrantedAuthority> roles;
        if (usuario != null) {
            /* Deberiamos traer roles de la BD, sin embargo, utilizaremos una lista.
             * List<RolesEntity> rolesUsuario = usuario.getRoles();
             * for (RolesEntity rol : rolesUsuario) {
             *     roles.add(new SimpleGrantedAuthority(rol.getNombre()));
             * }
            */
            roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("ADMIN"));
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        UserDetails userDetails = new User(usuario.getUser(), "{noop}" + usuario.getPassword(), roles);
        return userDetails;
    }
    
}
