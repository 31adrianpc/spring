package com.apc.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.apc.entity.ProductoEntity;

public interface ProductoRepository extends ReactiveCrudRepository<ProductoEntity, Integer> {
    
}
