package com.apc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apc.entity.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer>{
    
}
