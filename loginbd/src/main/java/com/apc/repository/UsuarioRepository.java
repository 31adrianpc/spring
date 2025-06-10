package com.apc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apc.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Integer>{
    
    public UsuarioEntity findByUserAndPassword(String user, String password);
    public List<UsuarioEntity> findByEstado(Integer estado);
    
}
