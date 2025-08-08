package com.apc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apc.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
    
}
