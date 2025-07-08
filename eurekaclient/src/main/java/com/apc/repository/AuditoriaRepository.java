package com.apc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.apc.entity.AuditoriaEntity;

import io.swagger.v3.oas.annotations.tags.Tag;

@RepositoryRestResource(path = "auditoria") // Exponemos la API en la ruta /auditoria
@Tag(name = "Auditoria", description = "Operaciones relacionadas con la auditoría del sistema") // Cambiamos de Auditoria_Entity a Auditoria
public interface AuditoriaRepository extends JpaRepository<AuditoriaEntity, Integer> {
    
}
