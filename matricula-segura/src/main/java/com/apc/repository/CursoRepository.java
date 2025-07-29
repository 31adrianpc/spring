package com.apc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apc.entity.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {
    
}
