/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apc.repository.impl;

import com.apc.entity.UsuarioEntity;
import com.apc.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{
    
    private List<UsuarioEntity> listaUsuarios;
    
    public UsuarioRepositoryImpl(){
        this.listaUsuarios = new ArrayList<>();
        this.listaUsuarios.add(new UsuarioEntity(1,"apc","apc123apc","AdrianPC",null,"1",null));
        this.listaUsuarios.add(new UsuarioEntity(2,"admin","admin","Administrador apc",null,"1",null));
    }

    @Override
    public UsuarioEntity obtenerUsuarioPorId(Integer idUsuario) {
        return this.listaUsuarios.stream().filter(u->u.getIdUsuario().equals(idUsuario)).findFirst().get();
    }

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuarioEntity) {
        UsuarioEntity resultado = null;
        List<UsuarioEntity> aux = this.listaUsuarios.stream().filter(u->u.getUser().equals(usuarioEntity.getUser()) && u.getPassword().equals(usuarioEntity.getPassword())).toList();
        if(!aux.isEmpty())
            resultado=aux.get(0);
        return resultado;
    }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return this.listaUsuarios.stream().filter(u->u.getEstado().equals("1")).toList();
    }

    @Override
    public void insertarUsuario(UsuarioEntity usuarioEntity) {
        usuarioEntity.setIdUsuario(this.listaUsuarios.size()+1);
        usuarioEntity.setEstado("1");
        this.listaUsuarios.add(usuarioEntity);
    }

    @Override
    public void actualizarUsuario(UsuarioEntity usuarioEntity) {
        List<UsuarioEntity> tmp = new ArrayList<>();
        this.listaUsuarios.forEach(u->{
            if(u.getIdUsuario().equals(usuarioEntity.getIdUsuario()))
                tmp.add(usuarioEntity);
            else
                tmp.add(u);
        });
        this.listaUsuarios = tmp;
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        List<UsuarioEntity> tmp = new ArrayList<>();
        this.listaUsuarios.forEach(u->{
            if(u.getIdUsuario().equals(idUsuario))
                u.setEstado("0");
            tmp.add(u);
        });
        this.listaUsuarios = tmp;
    }
    
}
