package com.apc.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.apc.entity.CategoriaEntity;

public interface CategoriaRepository extends ReactiveCrudRepository<CategoriaEntity, Integer>{
    
}
